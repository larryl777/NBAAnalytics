package com.na.nba_zone.AdvancedMetrics;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

//separate class to store advanced metrics (will be stored in different table)
    //will be easier to query w/different endpoint

@Entity
@Table(name="advanced_metrics",
    uniqueConstraints = @UniqueConstraint(columnNames = {"player_name", "season"}))
public class AdvancedMetrics {
    //our advanced metric will store data outside of the basic data table
        //like ts, box score, etc
    //id and player tracking
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "player_name")
    private String playerName;
    private Integer season;

    //actual new advanced metric data

    //efficiency metrics
    @Column(name = "true_shooting_percent")
    private Float trueShootingPercent;
    @Column(name = "effective_field_goal_percent")
    private Float effectiveFieldGoalPercent;
    @Column(name = "usage_rate")
    private Float usageRate;

    //advanced impact metrics
    @Column(name = "player_efficiency_rating")
    private Float playerEfficiencyRating;
    @Column(name = "offensive_rating")
    private Float offensiveRating;
    @Column(name = "defensive_rating")
    private Float defensiveRating;

    //per 36 rate stats
    @Column(name = "points_per_36")
    private Float pointsPer36;
    @Column(name = "assists_per_36")
    private Float assistsPer36;
    @Column(name = "rebounds_per_36")
    private Float reboundsPer36;
    @Column(name = "blocks_per_36")
    private Float blocksPer36;
    @Column(name = "steals_per_36")
    private Float stealsPer36;

    //percentages and overall rates
    @Column(name = "assist_rate")
    private Float assistRate;
    @Column(name = "turnover_rate")
    private Float turnoverRate;
    @Column(name = "rebound_rate")
    private Float reboundRate;
    @Column(name = "steal_rate")
    private Float stealRate;
    @Column(name = "block_rate")
    private Float blockRate;

    //shooting stats
    @Column(name = "three_point_attempt_rate")
    private Float threePtAttemptRate;
    @Column(name = "free_throw_rate")
    private Float freeThrowRate;

    //constructors
    public AdvancedMetrics(){

    }
    public AdvancedMetrics(String playerName, Integer season){
        this.playerName = playerName;
        this.season = season;
    }
    
    public AdvancedMetrics(Long id, String playerName, Integer season, Float trueShootingPercent,
            Float effectiveFieldGoalPercent, Float usageRate, Float playerEfficiencyRating, Float offensiveRating,
            Float defensiveRating, Float pointsPer36, Float assistsPer36, Float reboundsPer36, Float blocksPer36,
            Float stealsPer36, Float assistRate, Float turnoverRate, Float reboundRate, Float stealRate,
            Float blockRate, Float threePtAttemptRate, Float freeThrowRate) {
        this.id = id;
        this.playerName = playerName;
        this.season = season;
        this.trueShootingPercent = trueShootingPercent;
        this.effectiveFieldGoalPercent = effectiveFieldGoalPercent;
        this.usageRate = usageRate;
        this.playerEfficiencyRating = playerEfficiencyRating;
        this.offensiveRating = offensiveRating;
        this.defensiveRating = defensiveRating;
        this.pointsPer36 = pointsPer36;
        this.assistsPer36 = assistsPer36;
        this.reboundsPer36 = reboundsPer36;
        this.blocksPer36 = blocksPer36;
        this.stealsPer36 = stealsPer36;
        this.assistRate = assistRate;
        this.turnoverRate = turnoverRate;
        this.reboundRate = reboundRate;
        this.stealRate = stealRate;
        this.blockRate = blockRate;
        this.threePtAttemptRate = threePtAttemptRate;
        this.freeThrowRate = freeThrowRate;
    }

    //getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public Integer getSeason() {
        return season;
    }
    public void setSeason(Integer season) {
        this.season = season;
    }
    public Float getTrueShootingPercent() {
        return trueShootingPercent;
    }
    public void setTrueShootingPercent(Float trueShootingPercent) {
        this.trueShootingPercent = trueShootingPercent;
    }
    public Float getEffectiveFieldGoalPercent() {
        return effectiveFieldGoalPercent;
    }
    public void setEffectiveFieldGoalPercent(Float effectiveFieldGoalPercent) {
        this.effectiveFieldGoalPercent = effectiveFieldGoalPercent;
    }
    public Float getUsageRate() {
        return usageRate;
    }
    public void setUsageRate(Float usageRage) {
        this.usageRate = usageRage;
    }
    public Float getPlayerEfficiencyRating() {
        return playerEfficiencyRating;
    }
    public void setPlayerEfficiencyRating(Float playerEfficiencyRating) {
        this.playerEfficiencyRating = playerEfficiencyRating;
    }
    public Float getOffensiveRating() {
        return offensiveRating;
    }
    public void setOffensiveRating(Float offensiveRating) {
        this.offensiveRating = offensiveRating;
    }
    public Float getDefensiveRating() {
        return defensiveRating;
    }
    public void setDefensiveRating(Float defensiveRating) {
        this.defensiveRating = defensiveRating;
    }
    public Float getPointsPer36() {
        return pointsPer36;
    }
    public void setPointsPer36(Float pointsPer36) {
        this.pointsPer36 = pointsPer36;
    }
    public Float getAssistsPer36() {
        return assistsPer36;
    }
    public void setAssistsPer36(Float assistsPer36) {
        this.assistsPer36 = assistsPer36;
    }
    public Float getReboundsPer36() {
        return reboundsPer36;
    }
    public void setReboundsPer36(Float reboundsPer36) {
        this.reboundsPer36 = reboundsPer36;
    }
    public Float getBlocksPer36() {
        return blocksPer36;
    }
    public void setBlocksPer36(Float blocksPer36) {
        this.blocksPer36 = blocksPer36;
    }
    public Float getStealsPer36() {
        return stealsPer36;
    }
    public void setStealsPer36(Float stealsPer36) {
        this.stealsPer36 = stealsPer36;
    }
    public Float getAssistRate() {
        return assistRate;
    }
    public void setAssistRate(Float assistRate) {
        this.assistRate = assistRate;
    }
    public Float getTurnoverRate() {
        return turnoverRate;
    }
    public void setTurnoverRate(Float turnoverRate) {
        this.turnoverRate = turnoverRate;
    }
    public Float getReboundRate() {
        return reboundRate;
    }
    public void setReboundRate(Float reboundRate) {
        this.reboundRate = reboundRate;
    }
    public Float getStealRate() {
        return stealRate;
    }
    public void setStealRate(Float stealRate) {
        this.stealRate = stealRate;
    }
    public Float getBlockRate() {
        return blockRate;
    }
    public void setBlockRate(Float blockRate) {
        this.blockRate = blockRate;
    }
    public Float getThreePtAttemptRate() {
        return threePtAttemptRate;
    }
    public void setThreePtAttemptRate(Float threePtAttemptRate) {
        this.threePtAttemptRate = threePtAttemptRate;
    }
    public Float getFreeThrowRate() {
        return freeThrowRate;
    }
    public void setFreeThrowRate(Float freeThrowRate) {
        this.freeThrowRate = freeThrowRate;
    }   
}
