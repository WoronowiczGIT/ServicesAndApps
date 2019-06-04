package SDA.Streams.FootballLeague.DataGenerator.SearchStrategy;

import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

import static java.lang.Character.isLetter;

/**
 * Explanation: we cant use simple .split() method because of inconsistencies of received data
 * the only 2 constants are the country name as the first value, and the nationality as a last.
 * The easiest approach would be to fetch the last sequence of letters in each line, and then reverse it.
 */

public class SearchForNationalities implements UnaryOperator<String> {
    @Override
    public String apply(String input) {

        int limit = input.length() - 1;
        String nationalityReversed = "";

        for (int i = limit; i >= 0; i--) {
            if (isLetter(input.charAt(i))) {
                nationalityReversed += input.charAt(i);
            } else break;
        }

        String result = new StringBuilder(nationalityReversed).reverse().toString();
        return result;
    }
}
