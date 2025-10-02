package com.marsrover.grid;

/**
 * Component Interface (Composite Pattern)
 * Defines the common interface for both leaf objects (GridSquare, Obstacle)
 * and composite objects (Grid).
 */
public interface GridComponent {
    boolean isTraversable();
}
