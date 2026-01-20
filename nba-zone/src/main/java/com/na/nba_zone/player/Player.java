package com.na.nba_zone.player;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

//initalize player objects/class

@Entity
@Table(name="player_stats")
public class Player {
    @Id
    @Column(name = "name", unique = true)
    private String name;
    private Integer age;
    private String team;
    private String pos;
    private Integer g;
    private Integer gs;
    private Float mp;
    private Float fg;
    private Float fga;

    @Column(name = "FG%") // Maps the % column correctly
    private Float fgPercent;

    private Float threeP;
    private Float threePA;

    @Column(name = "3P%")
    private Float threePPercent;

    private Float twoP;
    private Float twoPA;

    @Column(name = "2P%")
    private Float twoPPercent;

    @Column(name = "eFG%")
    private Float efgPercent;

    private Float ft;
    private Float fta;

    @Column(name = "FT%")
    private Float ftPercent;

    private Float orb;
    private Float drb;
    private Float trb;
    private Float ast;
    private Float stl;
    private Float blk;
    private Float tov;
    private Float pf;
    private Float pts;

    @Column(name = "Trp-Dbl")
    private Integer trpDbl;

    private String awards;

    //parameterized constructor
    public Player(String name, Integer age, String team, String pos, Integer g, Integer gs, Float mp, Float fg,
            Float fga, Float fgPercent, Float threeP, Float threePA, Float threePPercent, Float twoP, Float twoPA,
            Float twoPPercent, Float efgPercent, Float ft, Float fta, Float ftPercent, Float orb, Float drb, Float trb,
            Float ast, Float stl, Float blk, Float tov, Float pf, Float pts, Integer trpDbl, String awards) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.pos = pos;
        this.g = g;
        this.gs = gs;
        this.mp = mp;
        this.fg = fg;
        this.fga = fga;
        this.fgPercent = fgPercent;
        this.threeP = threeP;
        this.threePA = threePA;
        this.threePPercent = threePPercent;
        this.twoP = twoP;
        this.twoPA = twoPA;
        this.twoPPercent = twoPPercent;
        this.efgPercent = efgPercent;
        this.ft = ft;
        this.fta = fta;
        this.ftPercent = ftPercent;
        this.orb = orb;
        this.drb = drb;
        this.trb = trb;
        this.ast = ast;
        this.stl = stl;
        this.blk = blk;
        this.tov = tov;
        this.pf = pf;
        this.pts = pts;
        this.trpDbl = trpDbl;
        this.awards = awards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getGs() {
        return gs;
    }

    public void setGs(Integer gs) {
        this.gs = gs;
    }

    public Float getMp() {
        return mp;
    }

    public void setMp(Float mp) {
        this.mp = mp;
    }

    public Float getFg() {
        return fg;
    }

    public void setFg(Float fg) {
        this.fg = fg;
    }

    public Float getFga() {
        return fga;
    }

    public void setFga(Float fga) {
        this.fga = fga;
    }

    public Float getFgPercent() {
        return fgPercent;
    }

    public void setFgPercent(Float fgPercent) {
        this.fgPercent = fgPercent;
    }

    public Float getThreeP() {
        return threeP;
    }

    public void setThreeP(Float threeP) {
        this.threeP = threeP;
    }

    public Float getThreePA() {
        return threePA;
    }

    public void setThreePA(Float threePA) {
        this.threePA = threePA;
    }

    public Float getThreePPercent() {
        return threePPercent;
    }

    public void setThreePPercent(Float threePPercent) {
        this.threePPercent = threePPercent;
    }

    public Float getTwoP() {
        return twoP;
    }

    public void setTwoP(Float twoP) {
        this.twoP = twoP;
    }

    public Float getTwoPA() {
        return twoPA;
    }

    public void setTwoPA(Float twoPA) {
        this.twoPA = twoPA;
    }

    public Float getTwoPPercent() {
        return twoPPercent;
    }

    public void setTwoPPercent(Float twoPPercent) {
        this.twoPPercent = twoPPercent;
    }

    public Float getEfgPercent() {
        return efgPercent;
    }

    public void setEfgPercent(Float efgPercent) {
        this.efgPercent = efgPercent;
    }

    public Float getFt() {
        return ft;
    }

    public void setFt(Float ft) {
        this.ft = ft;
    }

    public Float getFta() {
        return fta;
    }

    public void setFta(Float fta) {
        this.fta = fta;
    }

    public Float getFtPercent() {
        return ftPercent;
    }

    public void setFtPercent(Float ftPercent) {
        this.ftPercent = ftPercent;
    }

    public Float getOrb() {
        return orb;
    }

    public void setOrb(Float orb) {
        this.orb = orb;
    }

    public Float getDrb() {
        return drb;
    }

    public void setDrb(Float drb) {
        this.drb = drb;
    }

    public Float getTrb() {
        return trb;
    }

    public void setTrb(Float trb) {
        this.trb = trb;
    }

    public Float getAst() {
        return ast;
    }

    public void setAst(Float ast) {
        this.ast = ast;
    }

    public Float getStl() {
        return stl;
    }

    public void setStl(Float stl) {
        this.stl = stl;
    }

    public Float getBlk() {
        return blk;
    }

    public void setBlk(Float blk) {
        this.blk = blk;
    }

    public Float getTov() {
        return tov;
    }

    public void setTov(Float tov) {
        this.tov = tov;
    }

    public Float getPf() {
        return pf;
    }

    public void setPf(Float pf) {
        this.pf = pf;
    }

    public Float getPts() {
        return pts;
    }

    public void setPts(Float pts) {
        this.pts = pts;
    }

    public Integer getTrpDbl() {
        return trpDbl;
    }

    public void setTrpDbl(Integer trpDbl) {
        this.trpDbl = trpDbl;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }
   

}

