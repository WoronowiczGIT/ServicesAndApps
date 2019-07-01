package paprotka.algorithms.claculator;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Calculator {
    private static final String separator = ",";

    public static final String listToString(List<BigInteger> input) {
        String out = input.stream()
                .map(n -> (n.toString() + separator))
                .collect(Collectors.joining());
        //deleting last coma
        return out.substring(0, out.length() - 1);
    }

    public static final List<Long> stringToList(String input) {
        String[] numbers = input.split(separator);
        List<Long> numbersList = new LinkedList<>();

        Stream.of(numbers).forEach(number -> numbersList.add(Long.parseLong(number)));

        return numbersList;
    }

    public static final Long stringToNumber(String input) {
        return Long.parseLong(input);
    }

    public static final boolean isPrime(Long number) {
        return BigInteger.valueOf(number).isProbablePrime(1);
    }

    public static final List<BigInteger> numberToFactors(BigInteger number) {
        List<BigInteger> primeFactors = new LinkedList<>();

        long n = number.longValue();

        int timesDivided = 0;

        while (n % 2 == 0) {
            n >>= 1;
            timesDivided++;
        }
        while (timesDivided > 0) {
            primeFactors.add(BigInteger.valueOf(2));
            timesDivided--;
        }

        for (long i = 3; i <= (long) Math.sqrt(n); i += 2) {

            while (n % i == 0) {
                timesDivided++;
                n = n / i;
            }
            while (timesDivided > 0) {
                primeFactors.add(BigInteger.valueOf(i));
                timesDivided--;
            }
        }

        if (n > 1) {
            primeFactors.add(BigInteger.valueOf(n));
        }

        return primeFactors;
    }
}
