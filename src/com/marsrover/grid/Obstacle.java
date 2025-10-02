package com.marsrover.grid;

/**
 * Leaf class representing a non-traversable obstacle.
 */
public class Obstacle implements GridComponent {
    @Override
    public boolean isTraversable() {
        return false;
    }
}
