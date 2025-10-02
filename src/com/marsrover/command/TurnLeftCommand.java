package com.marsrover.command;
import com.marsrover.rover.Rover;

/**
 * Concrete command to turn the rover left.
 */
public class TurnLeftCommand implements Command {
    @Override
    public void execute(Rover rover) {
        rover.turnLeft();
    }
}
