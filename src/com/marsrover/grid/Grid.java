package com.marsrover.grid;

import com.marsrover.rover.Position;
import java.util.logging.Logger;
import java.util.logging.Level;


public class Grid {
    private static final Logger LOGGER = Logger.getLogger(Grid.class.getName());

    private final GridComponent[][] grid;
    private final int width;
    private final int height;

    public Grid(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Grid dimensions must be positive.");
        }
        this.width = width;
        this.height = height;
        this.grid = new GridComponent[width][height];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[x][y] = new GridSquare();
            }
        }
        LOGGER.log(Level.INFO, "Grid initialized with size {0}x{1}", new Object[]{width, height});
    }

    public void addObstacle(Position position) {
        if (isWithinBounds(position)) {
            grid[position.x()][position.y()] = new Obstacle();
            LOGGER.log(Level.INFO, "Obstacle added at {0}", position);
        } else {
            LOGGER.log(Level.WARNING, "Cannot add obstacle outside grid bounds at {0}", position);
        }
    }

    public boolean isValidAndTraversable(Position position) {
        return isWithinBounds(position) && grid[position.x()][position.y()].isTraversable();
    }

    private boolean isWithinBounds(Position position) {
        return position.x() >= 0 && position.x() < width &&
                position.y() >= 0 && position.y() < height;
    }
}
