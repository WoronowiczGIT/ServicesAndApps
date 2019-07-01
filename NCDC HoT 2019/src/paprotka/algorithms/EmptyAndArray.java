package paprotka.algorithms;

import java.math.BigInteger;
import java.util.List;

import static paprotka.algorithms.claculator.Calculator.stringToList;

public class EmptyAndArray implements Algorithm {
    @Override
    public void execute(List<String> lines){
        List<Long> list = stringToList(lines.get(1));

        BigInteger result = list.stream()
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);

        System.out.println(result);
    }
}
