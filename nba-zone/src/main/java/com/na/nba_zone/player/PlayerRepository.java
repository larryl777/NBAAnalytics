package com.na.nba_zone.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

//define interface methods
@Repository
public interface PlayerRepository extends JpaRepository<Player, String>{
    void deleteByName(String playerName); //delete players
    Optional<Player> findByName(String name); //find players
}

