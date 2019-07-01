package wilk.dataStructure;

public class Valve {
    private Double flowRate;
    private Double temperature;

    public Valve(Double flowRate, Double temperature) {
        this.flowRate = flowRate;
        this.temperature = temperature;
    }

    public Double getFlowRate() {
        return flowRate;
    }

    public Double getTemperature() {
        return temperature;
    }
}
