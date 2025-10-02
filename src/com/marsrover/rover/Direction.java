package com.marsrover.rover;

public enum Direction {
    NORTH("NORTH") {
        @Override
        public Direction turnLeft() { return WEST; }
        @Override
        public Direction turnRight() { return EAST; }
        @Override
        public Position move(Position current) {
            return new Position(current.x(), current.y() + 1);
        }
    },
    EAST("EAST") {
        @Override
        public Direction turnLeft() { return NORTH; }
        @Override
        public Direction turnRight() { return SOUTH; }
        @Override
        public Position move(Position current) {
            return new Position(current.x() + 1, current.y());
        }
    },
    SOUTH("SOUTH") {
        @Override
        public Direction turnLeft() { return EAST; }
        @Override
        public Direction turnRight() { return WEST; }
        @Override
        public Position move(Position current) {
            return new Position(current.x(), current.y() - 1);
        }
    },
    WEST("WEST") {
        @Override
        public Direction turnLeft() { return SOUTH; }
        @Override
        public Direction turnRight() { return NORTH; }
        @Override
        public Position move(Position current) {
            return new Position(current.x() - 1, current.y());
        }
    };

    private final String name;

    Direction(String name) {
        this.name = name;
    }

    public abstract Direction turnLeft();
    public abstract Direction turnRight();
    public abstract Position move(Position current);

    @Override
    public String toString() {
        return this.name;
    }
}

