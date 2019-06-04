package SDA.Streams.FootballLeague.Models;

import java.util.List;

public class FootballTeam {
    private String name;
    private List<FootballPlayer> players;
    private FootballMenager manager;
    private int age; //wiek klubu

    public FootballTeam(String name, List<FootballPlayer> players, FootballMenager manager, int age) {
        this.name = name;
        this.players = players;
        this.manager = manager;
        this.age = age;
    }
    public FootballTeam(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FootballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<FootballPlayer> players) {
        this.players = players;
    }

    public FootballMenager getManager() {
        return manager;
    }

    public void setManager(FootballMenager manager) {
        this.manager = manager;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
