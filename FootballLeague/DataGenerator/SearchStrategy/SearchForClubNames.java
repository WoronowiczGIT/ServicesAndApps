package SDA.Streams.FootballLeague.DataGenerator.SearchStrategy;

import java.util.function.UnaryOperator;

public class SearchForClubNames implements UnaryOperator<String> {
    @Override
    public String apply(String input) {
        String[] clubName = input.split("-");
        return clubName[0];
    }
}
