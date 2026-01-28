package com.na.nba_zone.player;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name="player_statistic",
       uniqueConstraints = @UniqueConstraint(columnNames = {"player_name", "season", "team_name"}))
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "player_name")
    private String name;
    
    private Integer season;
    private Integer age;
    
    @Column(name = "team_name")  
    private String teamName;      
    
    private String position;

    private Integer games_played;
    private Integer games_started;
    private Float minutes_played;

    private Float field_goals;
    private Float field_goal_attempts;
    private Float field_goal_percent;

    private Float three_point_field_goals;
    private Float three_point_attempts;
    private Float three_point_percent;

    private Float two_point_field_goals;
    private Float two_point_attempts;
    private Float two_point_percent;

    private Float effective_field_goal_percent;

    private Float free_throws;
    private Float free_throw_attempts;
    private Float free_throw_percent;

    private Float offensive_rebounds;
    private Float defensive_rebounds;
    private Float total_rebounds;
    private Float assists;
    private Float steals;
    private Float blocks;
    private Float turnovers;
    private Float personal_fouls;
    
    private Float total_points;

    private Integer triple_doubles;

    private String awards;

    public Player(){

    }
    
    //parameterized constructor
    public Player(String name, Integer season, Integer age, String teamName, String position, 
            Integer games_played, Integer games_started, Float minutes_played, Float field_goals, 
            Float field_goal_attempts, Float field_goal_percent, Float three_point_field_goals, 
            Float three_point_attempts, Float three_point_percent, Float two_point_field_goals, 
            Float two_point_attempts, Float two_point_percent, Float effective_field_goal_percent, 
            Float free_throws, Float free_throw_attempts, Float free_throw_percent,
            Float offensive_rebounds, Float defensive_rebounds, Float total_rebounds, Float assists, 
            Float steals, Float blocks, Float turnovers, Float personal_fouls, Float total_points, 
            Integer triple_doubles, String awards) {
        this.name = name;
        this.season = season;
        this.age = age;
        this.teamName = teamName; 
        this.position = position;
        this.games_played = games_played;
        this.games_started = games_started;
        this.minutes_played = minutes_played;
        this.field_goals = field_goals;
        this.field_goal_attempts = field_goal_attempts;
        this.field_goal_percent = field_goal_percent;
        this.three_point_field_goals = three_point_field_goals;
        this.three_point_attempts = three_point_attempts;
        this.three_point_percent = three_point_percent;
        this.two_point_field_goals = two_point_field_goals;
        this.two_point_attempts = two_point_attempts;
        this.two_point_percent = two_point_percent;
        this.effective_field_goal_percent = effective_field_goal_percent;
        this.free_throws = free_throws;
        this.free_throw_attempts = free_throw_attempts;
        this.free_throw_percent = free_throw_percent;
        this.offensive_rebounds = offensive_rebounds;
        this.defensive_rebounds = defensive_rebounds;
        this.total_rebounds = total_rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.turnovers = turnovers;
        this.personal_fouls = personal_fouls;
        this.total_points = total_points;
        this.triple_doubles = triple_doubles;
        this.awards = awards;
    }
    
    // getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getSeason() {
        return season;
    }
    
    public void setSeason(Integer season) {
        this.season = season;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    // CHANGE THESE TWO METHODS
    public String getTeamName() {
        return teamName;
    }
    
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public Integer getGames_played() {
        return games_played;
    }
    
    public void setGames_played(Integer games_played) {
        this.games_played = games_played;
    }
    
    public Integer getGames_started() {
        return games_started;
    }
    
    public void setGames_started(Integer games_started) {
        this.games_started = games_started;
    }
    
    public Float getMinutes_played() {
        return minutes_played;
    }
    
    public void setMinutes_played(Float minutes_played) {
        this.minutes_played = minutes_played;
    }
    
    public Float getField_goals() {
        return field_goals;
    }
    
    public void setField_goals(Float field_goals) {
        this.field_goals = field_goals;
    }
    
    public Float getField_goal_attempts() {
        return field_goal_attempts;
    }
    
    public void setField_goal_attempts(Float field_goal_attempts) {
        this.field_goal_attempts = field_goal_attempts;
    }
    
    public Float getField_goal_percent() {
        return field_goal_percent;
    }
    
    public void setField_goal_percent(Float field_goal_percent) {
        this.field_goal_percent = field_goal_percent;
    }
    
    public Float getThree_point_field_goals() {
        return three_point_field_goals;
    }
    
    public void setThree_point_field_goals(Float three_point_field_goals) {
        this.three_point_field_goals = three_point_field_goals;
    }
    
    public Float getThree_point_attempts() {
        return three_point_attempts;
    }
    
    public void setThree_point_attempts(Float three_point_attempts) {
        this.three_point_attempts = three_point_attempts;
    }
    
    public Float getThree_point_percent() {
        return three_point_percent;
    }
    
    public void setThree_point_percent(Float three_point_percent) {
        this.three_point_percent = three_point_percent;
    }
    
    public Float getTwo_point_field_goals() {
        return two_point_field_goals;
    }
    
    public void setTwo_point_field_goals(Float two_point_field_goals) {
        this.two_point_field_goals = two_point_field_goals;
    }
    
    public Float getTwo_point_attempts() {
        return two_point_attempts;
    }
    
    public void setTwo_point_attempts(Float two_point_attempts) {
        this.two_point_attempts = two_point_attempts;
    }
    
    public Float getTwo_point_percent() {
        return two_point_percent;
    }
    
    public void setTwo_point_percent(Float two_point_percent) {
        this.two_point_percent = two_point_percent;
    }
    
    public Float getEffective_field_goal_percent() {
        return effective_field_goal_percent;
    }
    
    public void setEffective_field_goal_percent(Float effective_field_goal_percent) {
        this.effective_field_goal_percent = effective_field_goal_percent;
    }
    
    public Float getFree_throws() {
        return free_throws;
    }
    
    public void setFree_throws(Float free_throws) {
        this.free_throws = free_throws;
    }
    
    public Float getFree_throw_attempts() {
        return free_throw_attempts;
    }
    
    public void setFree_throw_attempts(Float free_throw_attempts) {
        this.free_throw_attempts = free_throw_attempts;
    }
    
    public Float getFree_throw_percent() {
        return free_throw_percent;
    }
    
    public void setFree_throw_percent(Float free_throw_percent) {
        this.free_throw_percent = free_throw_percent;
    }
    
    public Float getOffensive_rebounds() {
        return offensive_rebounds;
    }
    
    public void setOffensive_rebounds(Float offensive_rebounds) {
        this.offensive_rebounds = offensive_rebounds;
    }
    
    public Float getDefensive_rebounds() {
        return defensive_rebounds;
    }
    
    public void setDefensive_rebounds(Float defensive_rebounds) {
        this.defensive_rebounds = defensive_rebounds;
    }
    
    public Float getTotal_rebounds() {
        return total_rebounds;
    }
    
    public void setTotal_rebounds(Float total_rebounds) {
        this.total_rebounds = total_rebounds;
    }
    
    public Float getAssists() {
        return assists;
    }
    
    public void setAssists(Float assists) {
        this.assists = assists;
    }
    
    public Float getSteals() {
        return steals;
    }
    
    public void setSteals(Float steals) {
        this.steals = steals;
    }
    
    public Float getBlocks() {
        return blocks;
    }
    
    public void setBlocks(Float blocks) {
        this.blocks = blocks;
    }
    
    public Float getTurnovers() {
        return turnovers;
    }
    
    public void setTurnovers(Float turnovers) {
        this.turnovers = turnovers;
    }
    
    public Float getPersonal_fouls() {
        return personal_fouls;
    }
    
    public void setPersonal_fouls(Float personal_fouls) {
        this.personal_fouls = personal_fouls;
    }
    
    public Float getTotal_points() {
        return total_points;
    }
    
    public void setTotal_points(Float total_points) {
        this.total_points = total_points;
    }
    
    public Integer getTriple_doubles() {
        return triple_doubles;
    }
    
    public void setTriple_doubles(Integer triple_doubles) {
        this.triple_doubles = triple_doubles;
    }
    
    public String getAwards() {
        return awards;
    }
    
    public void setAwards(String awards) {
        this.awards = awards;
    }
}