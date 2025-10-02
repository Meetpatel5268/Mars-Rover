package com.marsrover.rover;

import com.marsrover.grid.Grid;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Represents the Mars Rover. It maintains its current position and direction,
 * and interacts with the Main.java.com.marsrover.grid to move and report its status.
 */
public class Rover {
    private static final Logger LOGGER = Logger.getLogger(Rover.class.getName());

    private Position position;
    private Direction direction;
    private final Grid grid;

    public Rover(Position startPosition, Direction startDirection, Grid grid) {
        if (grid == null) {
            throw new IllegalArgumentException("Grid cannot be null.");
        }
        this.grid = grid;
        // Validate that the starting position is within bounds and traversable
        if (!grid.isValidAndTraversable(startPosition)) {
            throw new IllegalArgumentException("Invalid starting position: " + startPosition);
        }
        this.position = startPosition;
        this.direction = startDirection;
        LOGGER.log(Level.INFO, "Rover initialized at {0} facing {1}", new Object[]{position, direction});
    }

    public void move() {
        Position nextPosition = direction.move(this.position);
        if (grid.isValidAndTraversable(nextPosition)) {
            this.position = nextPosition;
            LOGGER.log(Level.INFO, "Rover moved to {0}", position);
        } else {
            LOGGER.log(Level.WARNING, "Move blocked. Obstacle or boundary detected at {0}", nextPosition);
        }
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
        LOGGER.log(Level.INFO, "Rover turned left. Now facing {0}", direction);
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
        LOGGER.log(Level.INFO, "Rover turned right. Now facing {0}", direction);
    }

    public String getStatusReport() {
        String report = String.format("Rover is at %s facing %s.", position, direction.name());
        LOGGER.log(Level.INFO, "Status Report: {0}", report);
        return report;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
