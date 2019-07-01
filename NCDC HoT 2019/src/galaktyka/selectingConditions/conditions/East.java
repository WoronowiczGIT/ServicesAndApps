package galaktyka.selectingConditions.conditions;

import galaktyka.directions.Direction;

public class East extends InitialConditions {

    public East(int size) {
        setSize(size);
        setDimensions();
        setBoundaries();
        setPosition();
        setDirection(Direction.LEFT);
    }

    private void setDimensions() {
        setWidth(getSize() + 2);
        setHeight(getSize() + 3);
    }

    private void setBoundaries() {
        setTopBoundary(1);
        setRightBoundary(getWidth() - 2);
        setBottomBoundary(getHeight() - 4);
        setLeftBoundary(1);
    }

    private void setPosition() {
        setyCoordinate(getHeight() - 2);
        setxCoordinate(getWidth() - 1);
    }
}
