package com.marsrover.command;

import com.marsrover.rover.Rover;

/**
 * Concrete command to move the rover forward.
 */
public class MoveCommand implements Command {
    @Override
    public void execute(Rover rover) {
        rover.move();
    }
}
