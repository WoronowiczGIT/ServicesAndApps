package wilk.validation;

import java.math.BigDecimal;

public class CapacityValidator implements Validator {
    private static int maximumPrecision = 5;
    private static BigDecimal maxVolume = BigDecimal.valueOf(100000);
    private static BigDecimal minVolume = BigDecimal.valueOf(0.00001);
    private static int isGreater = 1;
    @Override
    public boolean isCorrect(String line) {

        try {

            BigDecimal volume = new BigDecimal(line.trim());
            if (minVolume.compareTo(volume) == isGreater) return false;
            if (volume.compareTo(maxVolume) == isGreater) return false;
            if (volume.scale() > maximumPrecision) return false;

        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
