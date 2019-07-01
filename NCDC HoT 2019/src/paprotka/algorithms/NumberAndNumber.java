package paprotka.algorithms;

import paprotka.exceptions.IncorrectValueException;
import java.math.BigInteger;
import java.util.List;

import static paprotka.algorithms.claculator.Calculator.listToString;
import static paprotka.algorithms.claculator.Calculator.numberToFactors;
import static paprotka.algorithms.claculator.Calculator.stringToNumber;

public class NumberAndNumber implements Algorithm{
    private static BigInteger number;
    private static BigInteger factor;
    private static List<BigInteger> factors;

    @Override
    public void execute(List<String> lines) throws IncorrectValueException {

        Long longNumber = stringToNumber(lines.get(0));
            number = BigInteger.valueOf(longNumber);

        Long longFactor = stringToNumber(lines.get(1));
            factor = BigInteger.valueOf(longFactor);

            if (!factor.isProbablePrime(1)) throw new IncorrectValueException();
            if (!numbersAreDivisible()) throw new IncorrectValueException();

            getRemainingFactors();

            presentResult();
        }

    private static boolean numbersAreDivisible(){
        return number.mod(factor).equals(BigInteger.ZERO);
    }

    private static void getRemainingFactors(){
        BigInteger newNumber = number.divide(factor);
        factors = numberToFactors(newNumber);
    }

    private static void presentResult(){
        if(factors.isEmpty()){
            System.out.print(number);
        }else
            System.out.print(number + "\n" + listToString(factors));
    }
}

