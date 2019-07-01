package wilk;

import wilk.dataStructure.Valve;
import wilk.validation.ValveValidator;
import wilk.validation.Validator;
import wilk.validation.CapacityValidator;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

import static wilk.Calculator.*;

public class Wilk {
    private static final String INPUT_SEPARATOR = " ";
    private static final char DEC_SEPARATOR = '.';
    private static final String DISPLAY_PATTERN = "#.#####";
    private static final String ERROR_MESSAGE = "klops";

    private static final int VALVE_LIMIT = 1000000;

    private static BigDecimal expectedCapacity;
    private static boolean isCapacityDefined = false;

    private static List<Valve> allValves = new LinkedList<>();
    private static Validator valveFormat = new ValveValidator();
    private static CapacityValidator capacityFormat = new CapacityValidator();

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.lines()
                    .filter(n -> allValves.size() < VALVE_LIMIT)
                    .forEach(line -> {
                        if (!isCapacityDefined) {
                            defineCapacity(line);
                        } else if (valveFormat.isCorrect(line)) {
                            addValve(line);
                        }
                    });

            BigDecimal totalFlowRate = calculateTotalFlowRate(allValves);
            BigDecimal timeInMinutes = calculateTotalFlowTime(expectedCapacity, totalFlowRate);
            BigDecimal temperature = calculateTemperature(allValves, timeInMinutes);
            BigDecimal timeInSeconds = minutesToSeconds(timeInMinutes);

            DecimalFormat formatter = getPresentationFormat();

            System.out.print(
                    formatter.format(timeInSeconds)
                            + "\n"
                            + formatter.format(temperature)
            );

        } catch (ArithmeticException | OutOfMemoryError | NullPointerException e) {
            terminateApplication();
        }
    }

    private static void defineCapacity(String line) {
        if (!capacityFormat.isCorrect(line)) {
            terminateApplication();
        }
        expectedCapacity = new BigDecimal(line.trim());
        isCapacityDefined = true;
    }

    private static void addValve(String line) {
        String[] columns = line.split(INPUT_SEPARATOR);
            Double flowRate = Double.parseDouble(columns[0].trim());
            Double temp = Double.parseDouble(columns[1].trim());
                allValves.add(new Valve(flowRate, temp));
    }

    private static void terminateApplication() {
        System.out.print(ERROR_MESSAGE);
        System.exit(0);
    }

    private static DecimalFormat getPresentationFormat() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(DEC_SEPARATOR);

        DecimalFormat formatter = new DecimalFormat();
            formatter.setDecimalFormatSymbols(symbols);
            formatter.setRoundingMode(RoundingMode.FLOOR);

        formatter.applyPattern(DISPLAY_PATTERN);

        return formatter;
    }
}
