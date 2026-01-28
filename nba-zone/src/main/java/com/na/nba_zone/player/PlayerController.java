package com.na.nba_zone.player;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


//rest controller combines @Controller and @ResponseBody
    //able to handle HTTP reqs, return Java objects as JSON/HTMlL
    //acts as an endpoint for client server communication
//also beans = dependencies
@RestController
//change URL mapping
@RequestMapping(path = "api/v1/player")
public class PlayerController {
    private final PlayerService playerService; 
    //use autowire to inject an instance of our PlayerService into the Controller 
        //Spring automatically does this in version 4.3+ (if we only use 1 constructor in this class)
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    //HTTP methods/requests
    @GetMapping
    public List<Player> getPlayers(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String team,
        @RequestParam(required = false) String pos){

            // long startTime = System.currentTimeMillis(); //meeasure query MS
            List<Player> result; 
            //get players by their team, name, or position
            if(team != null && pos != null){
                result = playerService.getPlayerByTeamAndPosition(team, pos);
            }

            else if(team != null){
                result = playerService.getPlayerFromTeam(team);
            }

            else if(name != null){
                result =  playerService.getPlayerByName(name);
            }
            else if(pos != null){
                result =  playerService.getPlayerByPos(pos);
            }
            //return otherwise
            else{
                result =  playerService.getPlayers();
            }
            // long endTime = System.currentTimeMillis();
            // System.out.println("Query executed in: " + (endTime-startTime) + "ms");
            // System.out.println("Results returned: " + result.size() + " records");
            return result;
    }
    
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        //try to add this player
        Player createdPlayer = playerService.addPlayer(player);
        //return the created player with status code 201 if successful
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }
    
    //update existing player
    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updatePlayer = playerService.update(player);

        //successfully updated player
        if (updatePlayer != null){
            return new ResponseEntity<>(updatePlayer, HttpStatus.OK);
        }
        else{
            //didn't find player
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //@pathvariable is what gets passed into {playerName}
    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName){
        playerService.removePlayer(playerName);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }
}