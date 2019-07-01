package galaktyka.selectingConditions.conditions;

import galaktyka.directions.Direction;

public abstract class InitialConditions {
    private int size;
    private int xCoordinate;
    private int yCoordinate;

    private Direction direction;

    private int width;
    private int height;

    private int topBoundary;
    private int bottomBoundary;
    private int rightBoundary;
    private int leftBoundary;

    void setSize(int size) {
        this.size = size;
    }

    void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    void setDirection(Direction direction) {
        this.direction = direction;
    }

    void setWidth(int width) {
        this.width = width;
    }

    void setHeight(int height) {
        this.height = height;
    }

    void setTopBoundary(int topBoundary) {
        this.topBoundary = topBoundary;
    }

    void setBottomBoundary(int bottomBoundary) {
        this.bottomBoundary = bottomBoundary;
    }

    void setRightBoundary(int rightBoundary) {
        this.rightBoundary = rightBoundary;
    }

    void setLeftBoundary(int leftBoundary) {
        this.leftBoundary = leftBoundary;
    }

    int getSize() { return this.size; }

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getTopBoundary() {
        return this.topBoundary;
    }

    public int getBottomBoundary() {
        return this.bottomBoundary;
    }

    public int getRightBoundary() {
        return this.rightBoundary;
    }

    public int getLeftBoundary() {
        return this.leftBoundary;
    }

    public Direction getDirection() {
        return this.direction;
    }





}
