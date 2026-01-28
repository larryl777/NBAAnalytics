package com.na.nba_zone.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


//spring will parse these repository interaces, where it uses the feature of Query Derivation
//"findBy" will let Spring know that we want to generate a "SELECT" sql statement, and then "TeamName", "Name" indicates the fields
//"And" acts as a "WHERE" statement
//"ContainingIgnoreCase" acts like a "LIKE" statement, and wraps strings in LOWER()
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    
    //find by player name (exact match)
    List<Player> findByName(String name);
    
    //find by team
    List<Player> findByTeamName(String teamName);
    
    //find by team and position
    List<Player> findByTeamNameAndPosition(String teamName, String position);
    
    //find by name and season
    List<Player> findByNameAndSeason(String name, Integer season);
    
    //find players and pos  
    List<Player> findByNameContainingIgnoreCase(String name); //case insensetive and partial search
    List<Player> findByPositionContainingIgnoreCase(String positoon);

    // Delete by name (all records for that player)
    void deleteByName(String name);
}