package com.marsrover.grid;
/**
 * Leaf class representing an empty, traversable square.
 */
public class GridSquare implements GridComponent {
    @Override
    public boolean isTraversable() {
        return true;
    }
}

