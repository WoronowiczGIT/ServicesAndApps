package galaktyka.selectingConditions;


import galaktyka.selectingConditions.conditions.*;

import java.util.HashMap;
import java.util.Map;

public class ConditionsSelector {
    private Map<String,InitialConditions> conditions;
    private int size;
    private int directionIndex;
    private String parameters;
    private String direction;
    private final String[] marks = {"W","N","E","S"};

    public ConditionsSelector(String line){
        parameters = line.trim();
        directionIndex = parameters.length()-1;
        conditions = new HashMap<>();
        setParameters();
        setConditions();
    }

    private void setParameters(){
        direction = parameters
                .substring(directionIndex);

        size = Integer
                .parseInt(parameters
                        .substring(0,directionIndex));
    }

    private void setConditions(){
        conditions.put(marks[0], new West(size));
        conditions.put(marks[1], new North(size));
        conditions.put(marks[2], new East(size));
        conditions.put(marks[3], new South(size));
    }

    public InitialConditions getCondition(){
        return conditions.get(direction);
    }
}
