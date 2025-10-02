package com.marsrover.command;


import com.marsrover.rover.Rover;

/**
 * Concrete command to turn the rover right.
 */
public class TurnRightCommand implements Command {
    @Override
    public void execute(Rover rover) {
        rover.turnRight();
    }
}
