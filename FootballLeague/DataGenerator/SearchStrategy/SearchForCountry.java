package SDA.Streams.FootballLeague.DataGenerator.SearchStrategy;

import java.util.OptionalInt;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Character.isLetter;

public class SearchForCountry implements UnaryOperator<String> {
    @Override
    public String apply(String input) {
        int separatorIndex = IntStream.range(0, input.length())
                .filter(i ->!Character.isAlphabetic(input.charAt(i)))
                .findFirst()
                .orElse(-1);
        if (separatorIndex == -1) return input;
        if (separatorIndex < 5) return "England";
        return input.substring(0, separatorIndex);
    }
}
