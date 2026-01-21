package com.na.nba_zone.player;

import java.util.Optional;
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
        return playerRepository.findAll().stream()  
                .filter(player -> teamName.equals(player.getTeam_name()))    //get players by specific teamName
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
                .filter(player -> player.getPosition().toLowerCase().contains(position.toLowerCase()))   
                .collect(Collectors.toList()); //convert remaining players back into a list
    }

    //get players from team and position
    public List<Player> getPlayerByTeamAndPosition(String team, String position){
        return playerRepository.findAll().stream()  
                .filter(player -> team.equals(player.getTeam_name()) && position.equals(player.getPosition()))   
                .collect(Collectors.toList()); //convert remaining players back into a list
    }

    //add player to DB
    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    //update player
    public Player update(Player player){    
        //find player by their name
        Optional<Player> exists = playerRepository.findByName(player.getName());

        //if the player exists, update their name, team 
        if (exists.isPresent()){
            Player update = exists.get();
            update.setName(player.getName());
            update.setTeam_name(player.getTeam_name());
            update.setPosition(player.getPosition());
            playerRepository.save(update); //save the actual changes in the update

            //update more stats if needed in future
            return update;

        }
        return null;
    }
    //delete player 
    //use transactional to prevent partial deletions (ensures player is entirely deleted or not)
        //maintain data integrity
    @Transactional
    public void removePlayer(String player){
        //if player doesn't exist, throw error
        if (!playerRepository.existsById(player)){
            throw new IllegalStateException(player + " does not exist");
        }
        //else delete player
        playerRepository.deleteByName(player);
    }
}
