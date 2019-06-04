package SDA.Streams.FootballLeague.Models;

import java.util.List;

public class FootballLeague {
    private String name;
    private String country;
    private int level; //poziom rozgrywek
    private List<FootballTeam> teams;

    public FootballLeague(String name, String country, int level, List<FootballTeam> teams) {
        this.name = name;
        this.country = country;
        this.level = level;
        this.teams = teams;
    }
    public FootballLeague(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<FootballTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<FootballTeam> teams) {
        this.teams = teams;
    }
}
