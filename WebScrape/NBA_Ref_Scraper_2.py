#this version will iterate over multiple seasons, and also directly import data into our
#postgresql table rather than generating a csv file that we have to import 
    #bascially trying to make a way to keep the current season as updated as possible

#IMPORTANT: we also need to add a new 'season' column into our table to be able to keep track 3


import pandas as pd
import requests
import time
from bs4 import BeautifulSoup
from io import StringIO
#import sql adapter to directly add to our talbe
import psycopg2
from psycopg2.extras import execute_values
import os


seasons = [2022, 2023, 2024, 2025, 2026]


for season in seasons:
    print(f"Scraping seasons {season}...")
    url = f"https://www.basketball-reference.com/leagues/NBA_{season}_totals.html"
    html = requests.get(url)
    html.encoding = 'utf-8' 

    soup = BeautifulSoup(html.text, 'lxml') 
    table = soup.find("table", id = "totals_stats")

    data_Frame = pd.read_html(StringIO(str(table)))[0]
    data_Frame = data_Frame[data_Frame['Player'] != 'Player'] 
    #add new column called seasons
    data_Frame['Season'] = season
    
    string_Cols = ['Player', 'Team', 'Pos', 'Awards', 'Season'] #add seasons to strings we "skip" since we already added it
    for col in data_Frame.columns:
        if col in string_Cols:
            continue
        data_Frame[col] = pd.to_numeric(data_Frame[col], errors= "coerce").fillna(0)
        if '%' in col:
            data_Frame[col] = data_Frame[col].astype(float)
        else:
            data_Frame[col] = data_Frame[col].astype(int)

    #create a csv file for each season, 
    #we will format out actual sql table to just 1 table with all of the seasons
    data_Frame.to_csv(f"newstats_{season}.csv", index = False, encoding= "utf-8-sig") #need to save encoding as utf-8, then export 

    #env variables
    db_username = os.getenv('DB_USERNAME')

    #connect to postgreSQL table
    try:
        con = psycopg2.connect(
            host = "localhost",
            port = "5432",
            database = f"{db_username}",
            user = f"{db_username}",
            password= ""
        )
        cursor = con.cursor()

        mapping = {
            'Player': 'player_name',	
            'Age': 'age',	
            'Team': 'team_name',	
            'Pos': 'position',
            'G': 'games_played',
            'GS': 'games_started',	
            'MP': 'minutes_played',	
            'FG': 'field_goals',	
            'FGA': 'field_goal_attempts',	
            'FG%': 'field_goal_percent',	
            '3P': 'three_point_field_goals',	
            '3PA': 'three_point_attempts',	
            '3P%': 'three_point_percent',
            '2P': 'two_point_field_goals',	
            '2PA': 'two_point_attempts',	
            '2P%': 'two_point_percent',	
            'eFG%': 'effective_field_goal_percent',	
            'FT': 'free_throws',	
            'FTA': 'free_throw_attempts',	
            'FT%': 'free_throw_percent',
            'ORB': 'offensive_rebounds',	
            'DRB': 'defensive_rebounds',
            'TRB': 'total_rebounds',	
            'AST': 'assists',	
            'STL': 'steals',	
            'BLK': 'blocks',	
            'TOV': 'turnovers',	
            'PF': 'personal_fouls',	
            'PTS': 'total_points',	
            'Trp-Dbl': 'triple_doubles',	
            'Awards': 'awards',	
            'Season': 'season'
        }
        #rename columns to match DB
        data_Frame.rename(columns=mapping, inplace = True)

        #fetch column names to query
        db_Cols = list(mapping.values())
        col_String = ', '.join(db_Cols)

        #handle duplicates
        update_Cols = [f"{col} = EXCLUDED.{col}" for col in db_Cols if col not in ['player_name', 'season']]
        update_String = ', '.join(update_Cols)

        insert_Query = f"""
            INSERT INTO player_statistic ({col_String})
            VALUES %s
            ON CONFLICT (player_name, season, team_name)
            DO UPDATE SET {update_String}
        """
        val = [tuple(row) for row in data_Frame[db_Cols].values]

        execute_values(cursor, insert_Query, val)
        con.commit()
        print(f"Successfully updated or inserted {len(val)} records for season {season}")
        
    
    except Exception as e:
        print(f"Error for season {season}: {e}")
        if con:
            con.rollback
    finally:
        if con:
            cursor.close()
            con.close()
    
print("All seasons scraped successfully")