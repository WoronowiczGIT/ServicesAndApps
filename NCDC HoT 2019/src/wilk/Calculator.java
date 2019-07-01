package wilk;

import wilk.dataStructure.Valve;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Calculator {
    private static long m3ToLitersRatio = 1000;
    private static int secondsInMinute = 60;
    private static int scale = 10;

    static public BigDecimal calculateTotalFlowRate(List<Valve> valves) {

        return valves.stream()
                .map(Valve::getFlowRate)
                .map(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    static public BigDecimal calculateTotalFlowTime(BigDecimal capacity, BigDecimal flowRate) {

        BigDecimal totalCapacity = capacity
                .multiply(BigDecimal.valueOf(m3ToLitersRatio));

        return totalCapacity
                .divide(flowRate, scale, RoundingMode.CEILING);
    }

    static public BigDecimal minutesToSeconds(BigDecimal timeInMinutes) {

        return timeInMinutes
                .multiply(BigDecimal.valueOf(secondsInMinute));
    }

    static public BigDecimal calculateTemperature(List<Valve> valves, BigDecimal timeInMinutes) {
        BigDecimal numerator = BigDecimal.ZERO;
        BigDecimal denominator = BigDecimal.ZERO;

        for (Valve valve : valves) {
            BigDecimal flowRate = BigDecimal.valueOf(valve.getFlowRate());
            BigDecimal temperature = BigDecimal.valueOf(valve.getTemperature());

            BigDecimal fuelMass = flowRate.multiply(timeInMinutes);

            numerator = numerator.add(temperature.multiply(fuelMass));
            denominator = denominator.add(fuelMass);
        }

        return numerator.divide(denominator, scale, RoundingMode.HALF_UP);
    }
}
