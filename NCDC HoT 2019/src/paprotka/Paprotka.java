package paprotka;

import paprotka.algorithms.Algorithm;
import paprotka.exceptions.IncorrectValueException;
import paprotka.validation.AlgorithmSelector;
import paprotka.validation.LineType;
import paprotka.validation.LineAnalyzer;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Paprotka {
    private static final String ERROR_MESSAGE = "klops";
    private static final short LINES_LIMIT = 2;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<LineType> lineTypes = new LinkedList<>();
        LineAnalyzer analyzer = new LineAnalyzer();
        List<String> valuesAsString = new LinkedList<>();

        String line;
        while ((line = reader.readLine()) != null && lineTypes.size() < LINES_LIMIT) {
            lineTypes.add(analyzer.analyzeLine(line));
            valuesAsString.add(line);
        }
        reader.close();

        LineType number = lineTypes.get(0);
        LineType factors = lineTypes.get(1);
        AlgorithmSelector selector = new AlgorithmSelector(number, factors);

        try {
            Algorithm algorithm = selector.select();
            algorithm.execute(valuesAsString);

        } catch (IncorrectValueException | NumberFormatException  | NullPointerException e) {
            System.out.print(ERROR_MESSAGE);
        }
    }
}