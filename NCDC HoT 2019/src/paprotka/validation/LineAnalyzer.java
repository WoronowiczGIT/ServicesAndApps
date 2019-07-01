package paprotka.validation;

import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static paprotka.algorithms.claculator.Calculator.isPrime;

public class LineAnalyzer {
    private static final String separator = ",";
    private static final int limitOfFactors = 64;

    public LineType analyzeLine(String line) {
        line = line.trim();

        if (line.isEmpty()) return LineType.EMPTY;

        char lastCharacter = line.charAt(line.length() - 1);
        if (!isDigit(lastCharacter)) return LineType.INCORRECT;

        try {
            if (line.contains(separator)) {
                return checkIfArray(line);
            } else {
                return checkIfNumber(line);
            }

        } catch (NumberFormatException e) {
            return LineType.INCORRECT;
        }
    }

    private LineType checkIfArray(String line) throws NumberFormatException {
        String[] numbers = line.split(separator, limitOfFactors);

        boolean isArrayValid = Stream.of(numbers)
                .map(Long::parseLong)
                .allMatch(n -> (n > 1 && isPrime(n)));

        if (isArrayValid) {
            return LineType.PRIMES_ARRAY;
        } else
            throw new NumberFormatException();
    }

    private LineType checkIfNumber(String line) throws NumberFormatException {
        long number = Long.parseLong(line);

        if (number > 1) {
            return LineType.NUMBER;
        } else
            throw new NumberFormatException();
    }
}
