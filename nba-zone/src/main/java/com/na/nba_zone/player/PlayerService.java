package com.na.nba_zone.player;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

//service class sits between controller and repository (business logic)
//tells spring to create an instance of this class and manage its lifecycle
@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    //inject this playerRepository into service to allow it to interact with our PostgreSQL databse.
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    //retrieve all players
    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }
    //get player by team name
    public List<Player> getPlayerFromTeam(String teamName){
        return playerRepository.findAll().stream()  
                .filter(player -> teamName.equals(player.getTeam()))    //get players by specific teamName
                .collect(Collectors.toList()); //convert remaining players back into a list
    }

    //get players by specific name
    public List<Player> getPlayerByName(String name){
        return playerRepository.findAll().stream()  
                .filter(player -> player.getName().toLowerCase().contains(name.toLowerCase()))   
                .collect(Collectors.toList()); //convert remaining players back into a list
    }
    //get players by position
    public List<Player> getPlayerByPos(String position){
        return playerRepository.findAll().stream()  
                .filter(player -> player.getPos().toLowerCase().contains(position.toLowerCase()))   
                .collect(Collectors.toList()); //convert remaining players back into a list
    }

    //get players from team and position
    public List<Player> getPlayerByTeamAndPosition(String team, String position){
        return playerRepository.findAll().stream()  
                .filter(player -> team.equals(player.getTeam()) && position.equals(player.getPos()))   
                .collect(Collectors.toList()); //convert remaining players back into a list
    }

    //add player to DB
}
