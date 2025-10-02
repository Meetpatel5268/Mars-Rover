package com.marsrover.util;

import com.marsrover.command.Command;
import com.marsrover.command.MoveCommand;
import com.marsrover.command.TurnLeftCommand;
import com.marsrover.command.TurnRightCommand;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A utility class to parse a string of command characters into a list of Command objects.
 * It uses a Map to avoid conditional logic, adhering to the Open/Closed Principle.
 */
public class CommandParser {

    private static final Map<Character, Command> commandMap;

    // Static initializer block to create the map in a Java 8 compatible way
    static {
        Map<Character, Command> map = new HashMap<>();
        map.put('M', new MoveCommand());
        map.put('L', new TurnLeftCommand());
        map.put('R', new TurnRightCommand());
        commandMap = Collections.unmodifiableMap(map);
    }

    public static List<Command> parse(String commands) {
        if (commands == null) {
            throw new IllegalArgumentException("Command string cannot be null.");
        }
        return commands.chars()
                .mapToObj(c -> (char) c)
                .map(CommandParser::getCommandForChar)
                .collect(Collectors.toList());
    }

    private static Command getCommandForChar(char c) {
        Command command = commandMap.get(Character.toUpperCase(c));
        if (command == null) {
            throw new IllegalArgumentException("Invalid command character: " + c);
        }
        return command;
    }
}

