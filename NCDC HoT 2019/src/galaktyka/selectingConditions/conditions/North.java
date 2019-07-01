package galaktyka.selectingConditions.conditions;

import galaktyka.directions.Direction;

public class North extends InitialConditions {

    public North(int size) {
        setSize(size);
        setDimensions();
        setBoundaries();
        setPosition();
        setDirection(Direction.DOWN);
    }

    private void setDimensions() {
        setWidth(getSize() + 3);
        setHeight(getSize() + 2);
    }

    private void setBoundaries() {
        setTopBoundary(1);
        setRightBoundary(getWidth() - 4);
        setBottomBoundary(getHeight() - 2);
        setLeftBoundary(1);
    }

    private void setPosition() {
        setyCoordinate(0);
        setxCoordinate(getWidth() - 2);
    }
}
