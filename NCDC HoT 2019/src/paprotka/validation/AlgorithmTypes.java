package paprotka.validation;

import paprotka.algorithms.*;

public enum AlgorithmTypes {
    NumberNumber(LineType.NUMBER,LineType.NUMBER,new NumberAndNumber()),
    NumberEmpty(LineType.NUMBER,LineType.EMPTY,new NumberAndEmpty()),
    NumberArray(LineType.NUMBER,LineType.PRIMES_ARRAY,new NumberAndArray()),
    EmptyNumber(LineType.EMPTY,LineType.NUMBER,new EmptyAndNumber()),
    EmptyArray(LineType.EMPTY,LineType.PRIMES_ARRAY,new EmptyAndArray());

    private Algorithm algorithm;
    private LineType firstLine;
    private LineType secondLine;

    AlgorithmTypes(LineType firstLine, LineType secondLine,Algorithm algorithm) {
        this.algorithm = algorithm;
        this.firstLine = firstLine;
        this.secondLine = secondLine;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public LineType getFirstLine() {
        return firstLine;
    }

    public LineType getSecondLine() {
        return secondLine;
    }
}
