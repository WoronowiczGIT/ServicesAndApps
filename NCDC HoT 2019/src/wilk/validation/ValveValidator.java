package wilk.validation;

import java.math.BigDecimal;

public class ValveValidator implements Validator {
    private BigDecimal maximumTemperature = BigDecimal.valueOf(90);
    private BigDecimal minimumTemperature = BigDecimal.valueOf(1);
    private int maximumPrecision = 5;
    private int requiredArguments = 2;
    private String separator = " ";
    private int isGreater = 1;
    private int isLess = -1;

    @Override
    public boolean isCorrect(String line) {

        String[] values = line.split(separator);

        if (values.length != requiredArguments) return false;

        try {
            BigDecimal flowRate = new BigDecimal(values[0].trim());
            BigDecimal temp = new BigDecimal(values[1].trim());

            if (temp.compareTo(maximumTemperature) == isGreater) return false;
            if (temp.compareTo(minimumTemperature) == isLess) return false;
            if (flowRate.scale() > maximumPrecision) return false;
            if (temp.scale() > maximumPrecision) return false;

        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
