package com.marsrover;

import com.marsrover.command.Command;
import com.marsrover.grid.Grid;
import com.marsrover.rover.Direction;
import com.marsrover.rover.Position;
import com.marsrover.rover.Rover;
import com.marsrover.util.CommandParser;

import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Main application class to run the Mars Rover simulation.
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger("com.marsrover");

    private static final Map<Character, Direction> directionMap;

    // Static initializer block to create the map in a Java 8 compatible way
    static {
        Map<Character, Direction> map = new HashMap<>();
        map.put('N', Direction.NORTH);
        map.put('E', Direction.EAST);
        map.put('S', Direction.SOUTH);
        map.put('W', Direction.WEST);
        directionMap = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        setupLogger();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--- Mars Rover Simulation Setup ---");

            // 1. Get Grid Size
            System.out.print("Enter grid width and height (e.g., 10 10): ");
            int gridWidth = scanner.nextInt();
            int gridHeight = scanner.nextInt();
            Grid grid = new Grid(gridWidth, gridHeight);

            // 2. Get Obstacles
            System.out.print("Enter the number of obstacles: ");
            int obstacleCount = scanner.nextInt();
            for (int i = 0; i < obstacleCount; i++) {
                System.out.printf("Enter position for obstacle %d (x y): ", i + 1);
                int obsX = scanner.nextInt();
                int obsY = scanner.nextInt();
                grid.addObstacle(new Position(obsX, obsY));
            }

            // 3. Get Rover's Starting Position
            System.out.print("Enter Rover's starting position and direction (e.g., 0 0 N): ");
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            char dirChar = scanner.next().toUpperCase().charAt(0);

            Direction startDirection = directionMap.get(dirChar);
            if (startDirection == null) {
                throw new IllegalArgumentException("Invalid direction character. Use N, S, E, or W.");
            }
            Position startPosition = new Position(startX, startY);
            Rover rover = new Rover(startPosition, startDirection, grid);

            // 4. Get Commands
            System.out.print("Enter the command string (e.g., MMRMLM): ");
            String commandString = scanner.next();
            List<Command> commands = CommandParser.parse(commandString);

            System.out.println("\n--- Mars Rover Simulation Starting ---");
            System.out.println("Starting configuration: " + rover.getStatusReport());
            System.out.println("Commands to execute: " + commandString);
            System.out.println("------------------------------------\n");

            // 5. Execute Commands
            for (Command command : commands) {
                command.execute(rover);
            }

            // 6. Print Final Status
            System.out.println("\n--- Simulation Complete ---");
            System.out.println("Final position: " + rover.getStatusReport());
            System.out.println("---------------------------");

        } catch (InputMismatchException e) {
            LOGGER.log(Level.SEVERE, "Invalid input format. Please enter the correct data types.", e);
            System.err.println("Input Error: Invalid format. Please ensure you enter numbers and characters as required.");
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.SEVERE, "Error initializing simulation: {0}", e.getMessage());
            System.err.println("Configuration Error: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An unexpected error occurred", e);
            System.err.println("An unexpected error occurred during the simulation.");
        }
    }

    private static void setupLogger() {
        // Get the top-level logger and remove existing handlers
        Logger rootLogger = Logger.getLogger("");
        for (java.util.logging.Handler handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler);
        }

        // Add a new console handler
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        handler.setLevel(Level.INFO); // Set the desired logging level
        LOGGER.addHandler(handler);
        LOGGER.setLevel(Level.INFO);
    }
}

