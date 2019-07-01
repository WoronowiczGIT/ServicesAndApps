package galaktyka.designatePattern;

import galaktyka.directions.Direction;
import galaktyka.selectingConditions.conditions.InitialConditions;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import static galaktyka.directions.Direction.*;

public class SpinRight implements SpinPattern {
    private int width;
    private int height;

    private boolean[][] matrix;

    private int topBoundary;
    private int bottomBoundary;
    private int rightBoundary;
    private int leftBoundary;

    private Direction direction;
    private int x;
    private int y;

    private int radius;

    public SpinRight(InitialConditions conditions) {
        this.width = conditions.getWidth();
        this.height = conditions.getHeight();

        this.matrix = new boolean[height][width];

        this.topBoundary = conditions.getTopBoundary();
        this.bottomBoundary = conditions.getBottomBoundary();
        this.rightBoundary = conditions.getRightBoundary();
        this.leftBoundary = conditions.getLeftBoundary();

        this.direction = conditions.getDirection();
        this.x = conditions.getXCoordinate();
        this.y = conditions.getYCoordinate();

        this.radius = 2;
    }

    @Override
    public boolean[][] getPattern() {
        Map<Direction, Runnable> moves = setMoves();

        final double maxGalaxyLength = width * height * 0.5;
        IntStream
                .range(0, (int) maxGalaxyLength)
                .forEach(i -> {
                    matrix[y][x] = true;
                    moves.get(direction).run();
                });

        return matrix;
    }

    private Map<Direction,Runnable> setMoves(){
        Map<Direction, Runnable> moves = new HashMap<>();
            moves.put(RIGHT, this::moveRight);
            moves.put(DOWN, this::moveDown);
            moves.put(LEFT, this::moveLeft);
            moves.put(UP, this::moveUP);

        return moves;
    }

    private void moveRight() {
        if (x >= rightBoundary) {
            rightBoundary -= radius;
            direction = Direction.DOWN;
        } else x++;
    }

    private void moveDown() {
        if (y >= bottomBoundary) {
            bottomBoundary -= radius;
            direction = Direction.LEFT;
        } else y++;
    }

    private void moveLeft() {
        if (x <= leftBoundary) {
            leftBoundary += radius;
            direction = Direction.UP;
        } else x--;
    }

    private void moveUP() {
        if (y <= topBoundary) {
            topBoundary += radius;
            direction = RIGHT;
        } else y--;
    }

}
