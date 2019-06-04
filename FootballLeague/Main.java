package SDA.Streams.FootballLeague;

import SDA.Streams.FootballLeague.DataGenerator.Generator;
import SDA.Streams.FootballLeague.Models.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        Generator g = new Generator();
        List<FootballLeague> leagues = g.generateMultipleLeagues(100);

//        3.1. Na podstawie wszystkich dostępnych lig zwróć wszystkich treneerów
        List<FootballMenager> menagers = leagues.stream()
                .flatMap(league -> league.getTeams().stream())
                .map(footballTeam -> footballTeam.getManager())
                .collect(Collectors.toList());
//        3.2. Na podstawie wszystkich dostępnych lig zwróć nazwiska wszystkich trenenerów mających co najmniej 50 lat
        List<FootballMenager> menagersOver50 = leagues.stream()
                .flatMap(league -> league.getTeams().stream())
                .map(footballTeam -> footballTeam.getManager())
                .filter(menager -> {
                    int age = LocalDate.now().getYear() - menager.getDateOfBirth().getYear();
                    return age >= 50;
                })
                .collect(Collectors.toList());
        // menagersOver50.stream().forEach(menager-> System.out.println(menager.getDateOfBirth()));
//        3.3. Na podstawie wszystkich dostępnych lig zwróć wszystkich trenenerów mających co najwyżej 30 lat
        List<FootballMenager> menagersUnder30 = leagues.stream()
                .flatMap(league -> league.getTeams().stream())
                .map(footballTeam -> footballTeam.getManager())
                .filter(menager -> {
                    int age = LocalDate.now().getYear() - menager.getDateOfBirth().getYear();
                    return age <= 30;
                })
                .collect(Collectors.toList());
        // menagersUnder30.stream().forEach(menager-> System.out.println(menager.getName()+" "+ (menager.getDateOfBirth())));
//        3.4. Na podstawie wszystkich dostępnych lig zwróć wszystkich trenenerów narodowości niemieckiej
        List<FootballMenager> germanMenagers = leagues.stream()
                .flatMap(league -> league.getTeams().stream())
                .map(footballTeam -> footballTeam.getManager())
                .filter(menager -> menager.getNationality().equals("German"))
                .collect(Collectors.toList());
        //   germanMenagers.stream().forEach(menager-> System.out.println(menager.getName()+" "+ menager.getNationality()));
//        3.5. Na podstawie wszystkich dostępnych lig zwróć wszystkich piłkarzy
        List<FootballPlayer> allPlayersWorldWide = leagues.stream()
                .flatMap(league -> league.getTeams().stream())
                .flatMap(footballTeam -> footballTeam.getPlayers().stream())
                .collect(Collectors.toList());
        //  allPlayersWorldWide.stream().forEach(footballPlayer -> System.out.println(footballPlayer.getName()+" "+footballPlayer.getPosition()));
//        3.6. Na podstawie wszystkich dostępnych lig zwróć wszystkich piłkarzy - atakujacych
        List<FootballPlayer> allAttackers = leagues.stream()
                .flatMap(league -> league.getTeams().stream())
                .flatMap(footballTeam -> footballTeam.getPlayers().stream())
                .filter(footballPlayer -> footballPlayer.getPosition().equals(Position.ATTACK))
                .collect(Collectors.toList());

        // allAttackers.stream().forEach(footballPlayer -> System.out.println(footballPlayer.getName()+"  "+footballPlayer.getPosition()));
//        3.7.  Na podstawie wszystkich dostępnych lig zwróć imiona wszystkich piłkarzy - obrońców mających mniej niż 30 lat
        List<FootballPlayer> defendersUnder30 = leagues.stream()
                .flatMap(league -> league.getTeams().stream())
                .flatMap(footballTeam -> footballTeam.getPlayers().stream())
                .filter(footballPlayer -> footballPlayer.getPosition().equals(Position.DEFENCE))
                .filter(footballPlayer -> (LocalDate.now().getYear() - footballPlayer.getDateOfBirth().getYear()) <= 30)
                .collect(Collectors.toList());

        // defendersUnder30.stream().forEach(footballPlayer -> System.out.println(footballPlayer.getDateOfBirth()+" "+ footballPlayer.getPosition()));
//        3.8. Na podstawie wszystkich dostępnych lig zwróć wszystkich piłkarzy - bramkarzy mających co najmniej 50 lat
        List<FootballPlayer> goalkeepersOver50 = leagues.stream()
                .flatMap(league -> league.getTeams().stream())
                .flatMap(footballTeam -> footballTeam.getPlayers().stream())
                .filter(footballPlayer -> footballPlayer.getPosition().equals(Position.GOALKEEPER))
                .filter(footballPlayer -> Period.between(footballPlayer.getDateOfBirth(), LocalDate.now()).getYears() >= 50)
                .collect(Collectors.toList());

//        goalkeepersOver50.stream().forEach(footballPlayer -> System.out.println(
//                footballPlayer.getPosition() + " "
//                        + Period.between(footballPlayer.getDateOfBirth(), LocalDate.now()).getYears()));
//        3.9. Na podstawie wszystkich dostępnych lig zwróć wszystkie kluby
        List<FootballTeam> teamsWorldwide = leagues.stream()
                .flatMap(league -> league.getTeams().stream())
                .collect(Collectors.toList());

       // teamsWorldwide.stream().forEach(team -> System.out.println(team.getName()));
//        3.10. Na podstawie wszystkich dostępnych lig zwróć wszystkie kluby zawierające co najmniej 2 piłkarzy
        List<FootballTeam> teamsOver2Players = leagues.stream()
                .flatMap(league -> league.getTeams().stream())
                .filter(team -> team.getPlayers().size()>2)
                .collect(Collectors.toList());

        //teamsOver2Players.stream().forEach(team-> System.out.println(team.getPlayers().size()));
//        3.11. Na podstawie wszystkich dostępnych lig zwróć wszystkie kluby mające trenera narodowości brazyliskiej
        List<FootballTeam> managedByBrazilian = leagues.stream()
                .flatMap(league -> league.getTeams().stream())
                .filter(team->team.getManager().getNationality().equals("Brazilian"))
                .collect(Collectors.toList());

       // managedByBrazilian.stream().forEach(team-> System.out.println(team.getName()+" "+team.getManager().getNationality()));
//        3.12. Na podstawie wszystkich dostępnych lig zwróć wszystkie polskie kluby
        List<FootballTeam> polishTeams = leagues.stream()
                .filter(league -> league.getCountry().equals("Poland"))
                .flatMap(league -> league.getTeams().stream())
                .collect(Collectors.toList());
//        leagues.stream()
//                .filter(league -> league.getCountry().equals("Poland"))
//                .forEach(league -> System.out.println(league.getCountry()+" "+league.getTeams().size()));
//        3.13. Na podstawie wszystkich dostępnych lig zwróć wszystkie kluby mające ponad 50 lat
        List<FootballTeam> teamsOver50 = leagues.stream()
                .flatMap(league -> league.getTeams().stream())
                .filter(team -> team.getAge()>50).collect(Collectors.toList());

        //teamsOver50.stream().forEach(team -> System.out.println(team.getAge()+" "+team.getName()));
//        3.14. Na podstawie wszystkich dostępnych lig zwróć wszystkie te które zawierają w swoich rozgrywkach co najmniej 12 zespołów
        List<FootballLeague> leaguesOver12 = leagues.stream()
                .filter(league -> league.getTeams().size()>=12)
                .collect(Collectors.toList());

      //  leaguesOver12.stream().forEach(league -> System.out.println(league.getTeams().size()+" "+league.getName()));
//        3.15. Na podstawie wszystkich dostępnych lig zwróć wszystkie kluby pierwszoligowe (level == 1)
        leagues.stream()
                .filter(league -> league.getLevel()==1)
                .flatMap(league -> league.getTeams().stream())
                .forEach(team-> System.out.println(team.getName()));
       long firstLeague =  leagues.stream()
               .filter(league -> league.getLevel()==1)
               .flatMap(league -> league.getTeams().stream())
               .count();
        System.out.println(firstLeague);

        leagues.stream().map(league -> league.getCountry()).forEach(System.out::println);

    }
}
