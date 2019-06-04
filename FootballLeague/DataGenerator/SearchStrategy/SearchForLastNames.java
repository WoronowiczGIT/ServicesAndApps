package SDA.Streams.FootballLeague.DataGenerator.SearchStrategy;

import java.util.function.UnaryOperator;

public class SearchForLastNames implements UnaryOperator<String> {
    @Override
    public String apply(String input) {
        return input.trim();
    }
}
