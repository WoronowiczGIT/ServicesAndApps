package galaktyka.selectingConditions.conditions;

import galaktyka.directions.Direction;

public class West extends InitialConditions {

    public West(int size) {
        setSize(size);
        setDimensions();
        setBoundaries();
        setPosition();
        setDirection(Direction.RIGHT);
    }

    private void setDimensions() {
        setWidth(getSize() + 2);
        setHeight(getSize() + 3);
    }

    private void setBoundaries() {
        setTopBoundary(3);
        setRightBoundary(getWidth() - 2);
        setBottomBoundary(getHeight() - 2);
        setLeftBoundary(1);
    }

    private void setPosition() {
        setyCoordinate(1);
        setxCoordinate(0);
    }

}
