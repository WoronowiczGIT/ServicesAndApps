package paprotka.algorithms;

import paprotka.exceptions.IncorrectValueException;

import java.math.BigInteger;
import java.util.List;

import static paprotka.algorithms.claculator.Calculator.*;

public class NumberAndArray implements Algorithm {
    private static BigInteger number;
    private static BigInteger factorsProduct;
    private static List<BigInteger> factors;

    @Override
    public void execute(List<String> lines) throws IncorrectValueException {

        Long number = stringToNumber(lines.get(0));
        NumberAndArray.number = BigInteger.valueOf(number);

        List<Long> list = stringToList(lines.get(1));
        Long product = list.stream()
                .reduce(1L, (a, b) -> a * b);
        factorsProduct = BigInteger.valueOf(product);

        if(!numbersAreDivisible()) throw new IncorrectValueException();

        getRemainingFactors();

        presentResult();
    }

    private static void getRemainingFactors(){
        BigInteger newNumber = number.divide(factorsProduct);
            factors = numberToFactors(newNumber);
    }

    private static boolean numbersAreDivisible(){
        return number.mod(factorsProduct).equals(BigInteger.ZERO);
    }

    private static void presentResult(){
        if(factors.isEmpty()){
            System.out.print(number);
        }else
            System.out.print(number + "\n" + listToString(factors));
    }




}
