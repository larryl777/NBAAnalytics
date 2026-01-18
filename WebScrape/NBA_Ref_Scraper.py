#install pandas, requests, beautifulSoup
    #pandas for data handling, formatting, exporting to a CSV
    #requests to make http reqeusts
    #beautiful soup to parse HTML/XML from BasketBall Ref

import pandas as pd
import requests
import time
from bs4 import BeautifulSoup
from io import StringIO

#start by scarping only 2025-2026 season
    #need to scrape other seasons 

#list to store NBA stats of each player
all_Players = []

url = "https://www.basketball-reference.com/leagues/NBA_2026_totals.html"
html = requests.get(url)
html.encoding = 'utf-8' #force utf encoding

#parse text
soup = BeautifulSoup(html.text, 'lxml') 
table = soup.find("table", id = "totals_stats")

#extract and format html strings
data_Frame = pd.read_html(StringIO(str(table)))[0]
data_Frame = data_Frame[data_Frame['Player'] != 'Player'] #cleanup repeating header rows

#because pandas uses float as default, we need to convert certain stats to integers to match data on basketball ref
string_Cols = ['Player', 'Team', 'Pos', 'Awards']
for col in data_Frame.columns:
    #don't do anything to strings
    if col in string_Cols:
        continue

    #convert rest of columns to numerics
    data_Frame[col] = pd.to_numeric(data_Frame[col], errors= "coerce").fillna(0)
    #only % need to be saved as floats, rest of the data can be stored as integers
    if '%' in col:
        data_Frame[col] = data_Frame[col].astype(float)
    else:
        data_Frame[col] = data_Frame[col].astype(int)


data_Frame.to_csv("stats.csv", index = False, encoding= "utf-8-sig") #need to save encoding as utf-8, then export 
