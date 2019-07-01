package galaktyka;

import galaktyka.designatePattern.SpinPattern;
import galaktyka.designatePattern.SpinRight;
import galaktyka.display.GalaxyPresenter;
import galaktyka.display.Presenter;
import galaktyka.selectingConditions.ConditionsSelector;
import galaktyka.selectingConditions.conditions.InitialConditions;

import static galaktyka.validation.GalacticValidator.isArgumentValid;

public class Galaktyka {
    private static final int requiredArgs = 1;
    private static final String TRAIL_SYMBOL = " ";
    private static final String BACKGROUND_SYMBOL = "*";
    private static final String ERROR_MESSAGE = "klops";

    public static void main(String[] args) {
        validateInput(args);
        String input = args[0];

        if (!isArgumentValid(input)) { terminateApplication(); }

        ConditionsSelector selector = new ConditionsSelector(input);
        InitialConditions conditions = selector.getCondition();

        SpinPattern pattern = new SpinRight(conditions);
        boolean[][] result = pattern.getPattern();

        Presenter presenter = new GalaxyPresenter(TRAIL_SYMBOL, BACKGROUND_SYMBOL);

        presenter.display(result);

    }

    private static void validateInput(String[] args){
        if(args.length != requiredArgs){
            terminateApplication();
        }
    }

    private static void terminateApplication(){
        System.out.print(ERROR_MESSAGE);
        System.exit(0);
    }
}
