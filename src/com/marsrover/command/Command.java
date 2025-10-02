package com.marsrover.command;

import com.marsrover.rover.Rover;

/**
 * Command Interface (Command Pattern)
 * Defines a common method for all command objects.
 */
@FunctionalInterface
public interface Command {
    void execute(Rover rover);
}
