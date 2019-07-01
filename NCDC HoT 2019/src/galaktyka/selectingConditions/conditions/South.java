package galaktyka.selectingConditions.conditions;

import galaktyka.directions.Direction;

public class South extends InitialConditions{

    public South(int size) {
        setSize(size);
        setDimensions();
        setBoundaries();
        setPosition();
        setDirection(Direction.UP);
    }

    private void setDimensions() {
        setWidth(getSize() + 3);
        setHeight(getSize() + 2);
    }

    private void setBoundaries() {
        setTopBoundary(1);
        setRightBoundary(getWidth() - 2);
        setBottomBoundary(getHeight() - 2);
        setLeftBoundary(3);
    }

    private void setPosition() {
        setyCoordinate(getHeight() - 1);
        setxCoordinate(1);
    }
}
