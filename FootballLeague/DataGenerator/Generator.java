package SDA.Streams.FootballLeague.DataGenerator;

import SDA.Streams.FootballLeague.Models.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static SDA.Streams.FootballLeague.DataGenerator.Repository.getRandomBirthDay;
import static SDA.Streams.FootballLeague.DataGenerator.Repository.getRandomValueFromList;

public class Generator {
    private Repository repository;

    public Generator() throws IOException {
        this.repository = new Repository();
        repository.setUP();
    }

    public List<FootballLeague> generateMultipleLeagues(int numberOfLeagues) {
        List<FootballLeague> leagues = new ArrayList<>();

        IntStream.range(0,numberOfLeagues)
                .forEach(index->{
                    leagues.add(new FootballLeague());
                    leagues.get(index).setName(getRandomValueFromList(repository.getCountries()) + "LEAGUE!");
                    leagues.get(index).setCountry((String) getRandomValueFromList(repository.getCountries()));
                    leagues.get(index).setLevel(new Random().nextInt(3) + 1);
                    leagues.get(index).setTeams(generateMultipleTeams(new Random().nextInt(10) + 10));
                });

        return leagues;
    }

    List<FootballTeam> generateMultipleTeams(int numberOfTeams) {
        List<FootballTeam> teams = new ArrayList<>();

        IntStream.range(0,numberOfTeams)
                .forEach(index->{
                    teams.add(new FootballTeam());
                    teams.get(index).setAge(new Random().nextInt(100) + 1);
                    teams.get(index).setName((String) getRandomValueFromList(repository.getClubNames()));
                    teams.get(index).setManager(generateManager());
                    teams.get(index).setPlayers(generateTeam());
                });
        return teams;
    }

    List<FootballPlayer> generateTeam() {
        List<FootballPlayer> list = new ArrayList<>();

        int teamSize = 11;
        while (list.size() < teamSize)
        {
            FootballPlayer player = generatePlayer();
            Position position = assignPlayerPosition(list);
            player.setPosition(position);
            list.add(player);
        }
        return list;
    }

    Position assignPlayerPosition(List<FootballPlayer> list) {
        int numberOfGoalKeepers = 1;
        int numberOfAttackers = 3;

        long goalKeepers = list.stream()
                .map(footballPlayer -> footballPlayer.getPosition())
                .filter(position -> position.equals(Position.GOALKEEPER))
                .count();

        long attackers = list.stream()
                .map(footballPlayer -> footballPlayer.getPosition())
                .filter(position -> position.equals(Position.ATTACK))
                .count();

        if (goalKeepers < numberOfGoalKeepers) return Position.GOALKEEPER;
        if (attackers < numberOfAttackers) return Position.ATTACK;

        Random random = new Random();
        int value = random.nextInt(10);
        if (value < 7) return Position.MIDFIELD;
        else return Position.DEFENCE;
    }

    FootballPlayer generatePlayer(){
        String name = (String) getRandomValueFromList(repository.getNames());
        String lastName = (String) getRandomValueFromList(repository.getLastNames());
        LocalDate dateOfBirth = getRandomBirthDay();

        return new FootballPlayer(name, lastName, Position.NULLPOSITION, dateOfBirth);
    }

    FootballMenager generateManager(){
        String name = (String) getRandomValueFromList(repository.getNames());
        String lastName = (String) getRandomValueFromList(repository.getLastNames());
        String nationality = (String) getRandomValueFromList(repository.getNationalities());
        LocalDate dateOfBirth = getRandomBirthDay();

        return new FootballMenager(name, lastName, nationality, dateOfBirth);
    }






}
