package paprotka.algorithms;

import paprotka.exceptions.IncorrectValueException;
import java.util.List;

import static paprotka.algorithms.claculator.Calculator.isPrime;
import static paprotka.algorithms.claculator.Calculator.stringToNumber;

public class EmptyAndNumber implements Algorithm {
    @Override
    public void execute(List<String> lines) throws IncorrectValueException {
        Long result = stringToNumber(lines.get(1));

        if(isPrime(result)){
            System.out.println(result);
        }else
            throw new IncorrectValueException();
    }
}
