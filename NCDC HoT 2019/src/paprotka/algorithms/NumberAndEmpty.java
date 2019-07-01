package paprotka.algorithms;

import java.math.BigInteger;
import java.util.List;

import static paprotka.algorithms.claculator.Calculator.listToString;
import static paprotka.algorithms.claculator.Calculator.numberToFactors;
import static paprotka.algorithms.claculator.Calculator.stringToNumber;

public class NumberAndEmpty implements Algorithm{
    @Override
    public void execute(List<String> lines) {

        Long longNumber = stringToNumber(lines.get(0));
        BigInteger number = BigInteger.valueOf(longNumber);

            List<BigInteger> otherFactors = numberToFactors(number);
            System.out.print(number + "\n" + listToString(otherFactors));
    }
}
