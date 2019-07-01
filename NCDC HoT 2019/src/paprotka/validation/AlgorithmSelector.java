package paprotka.validation;

import paprotka.algorithms.*;

public class AlgorithmSelector {
    private LineType firstLine;
    private LineType secondLine;

    public AlgorithmSelector(LineType firstLine, LineType secondLine) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
    }

    public Algorithm select() throws NullPointerException {

       for(AlgorithmTypes type: AlgorithmTypes.values()){
           if(type.getFirstLine().equals(firstLine)
                   && type.getSecondLine().equals(secondLine)){
               return type.getAlgorithm();
           }
       }
       throw new NullPointerException();
    }


}
