package com.na.nba_zone.player;

import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
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
        return playerRepository.findByTeamName(teamName); //repository method
    }

    //get players by specific name
    public List<Player> getPlayerByName(String name){
        // return playerRepository.findAll().stream()  
        //         .filter(player -> player.getName() != null && 
        //                 player.getName().toLowerCase().contains(name.toLowerCase()))   
        //         .collect(Collectors.toList());
        return playerRepository.findByNameContainingIgnoreCase(name); //repository method for effiency
    }
    
    //get players by position
    public List<Player> getPlayerByPos(String position){
        // return playerRepository.findAll().stream()  
        //         .filter(player -> player.getPosition() != null && 
        //                 player.getPosition().toLowerCase().contains(position.toLowerCase()))   
        //         .collect(Collectors.toList());
        return playerRepository.findByPositionContainingIgnoreCase(position); //repository method for effiency
    }

    //get players from team and position with the PlayerRepository method
    public List<Player> getPlayerByTeamAndPosition(String team, String position){
        return playerRepository.findByTeamNameAndPosition(team, position);
    }

    //add player to database
    public Player addPlayer(Player player){
        return playerRepository.save(player);
    }

    //update player
    public Player update(Player player){    
        //find player by their name, return a list since we have multiple seasons
        List<Player> playerList = playerRepository.findByName(player.getName());

        //if the player exists, update the first match
        if (!playerList.isEmpty()){
            Player update = playerList.get(0);
            update.setName(player.getName());
            update.setTeamName(player.getTeamName());
            update.setPosition(player.getPosition());
            update.setSeason(player.getSeason());
            playerRepository.save(update);

            return update;
        }
        return null;
    }
    
    //delete player, deletes all records for that player and their seasons + teams
    @Transactional
    public void removePlayer(String playerName){
        List<Player> players = playerRepository.findByName(playerName);
        
        //if player doesn't exist, throw error
        if (players.isEmpty()){
            throw new IllegalStateException(playerName + " does not exist");
        }
        //else delete all records for that player
        playerRepository.deleteByName(playerName);
    }
}