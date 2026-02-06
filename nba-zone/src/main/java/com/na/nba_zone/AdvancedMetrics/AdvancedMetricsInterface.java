package com.na.nba_zone.AdvancedMetrics;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface AdvancedMetricsInterface extends JpaRepository<AdvancedMetrics, Long> {
    //get metrics by player name
    List<AdvancedMetrics> findByPlayerName(String playerName);

    //get metrics by player name and season
    Optional<AdvancedMetrics> findByPlayerNameAndSeason(String playerName, Integer season);
    
    //get metrics by season
    List<AdvancedMetrics> findBySeason(Integer season);
 
    //get top players for a specific metric (TS, PER, Usage Rate, Effective Field Goal % )
    //query and search from seasons labeled by the input season, no need to search through entire database
    @Query("SELECT a FROM AdvancedMetrics WHERE a.season = :season  ORDER BY a.trueShootingPercent DESC")
    List<AdvancedMetrics> findTopByTS(@Param("season") Integer season);

    @Query("SELECT a FROM AdvancedMetrics WHERE a.season = :season  ORDER BY a.playerEfficiencyRating DESC")
    List<AdvancedMetrics> findTopByPER(@Param("season") Integer season);

    @Query("SELECT a FROM AdvancedMetrics WHERE a.season = :season  ORDER BY a.usageRate DESC")
    List<AdvancedMetrics> findTopByUsage(@Param("season") Integer season);

    @Query("SELECT a FROM AdvancedMetrics WHERE a.season = :season  ORDER BY a.effectiveFieldGoalPercent DESC")
    List<AdvancedMetrics> findTopByEFG(@Param("season") Integer season);
   
    //delete by player name
    void deleteByPlayerName(String playerName);

}
