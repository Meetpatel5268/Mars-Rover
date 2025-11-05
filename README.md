# 🚀 Mars Rover Simulation

A Java-based simulation of a Mars Rover navigating a grid-based terrain, designed with strong **Object-Oriented Programming (OOP)** principles, **SOLID** practices, and modern **software design patterns**. This project demonstrates clean, scalable, and maintainable code while simulating a realistic rover navigation scenario on Mars.

---

## 🌌 Overview

The Mars Rover Simulation allows users to:

- Define a customizable grid environment.
- Place obstacles dynamically.
- Set the rover's initial position and orientation.
- Issue a sequence of navigation commands.
- Receive real-time logging of rover actions and its final position.

The application emphasizes **robust design**, showcasing advanced programming techniques and patterns.

---

## 🛠 Features

### 1. Dynamic Environment Setup
- Define grid width and height.
- Specify the number and location of obstacles.
- Set the rover's starting position and facing direction.

### 2. Rover Navigation
The rover accepts a string of commands to navigate the grid:
- `M` – Move one step forward.
- `L` – Turn left 90°.
- `R` – Turn right 90°.

### 3. Obstacle Detection
- The rover cannot move into a grid square occupied by an obstacle.

### 4. Boundary Checks
- The rover is prevented from moving outside the grid boundaries.

### 5. Status Reporting
- Real-time logs of rover actions.
- Final position and orientation displayed after command execution.

---

## 🏗 Design & Architecture

The application demonstrates best practices in software design:

### Object-Oriented Principles
- **Encapsulation:** Rover and Grid states are protected, accessible only through public methods.
- **Polymorphism:** Command and GridComponent interfaces allow flexible implementation and uniform treatment.

### SOLID Principles
- **Single Responsibility Principle:** Each class has a single, well-defined responsibility.
- **Open/Closed Principle:** New commands can be added without modifying existing logic.
- **Liskov Substitution Principle:** Obstacles and GridSquares can be used interchangeably as GridComponents.

### Design Patterns
- **Command Pattern:** Encapsulates rover actions (`Move`, `TurnLeft`, `TurnRight`) as objects, decoupling the invoker from the executor.
- **Composite Pattern:** Represents the grid; both `GridSquare` and `Obstacle` implement `GridComponent`.
- **State Pattern (via Enum):** `Direction` enum elegantly handles rover orientation changes without conditional logic.

---

## 💻 How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) version 8 or higher.

### Step 1: Compile the Code
Navigate to the project root (where `src` folder is located) and run:

```bash
javac -d bin src/com/marsrover/command/*.java src/com/marsrover/grid/*.java src/com/marsrover/rover/*.java src/com/marsrover/util/*.java src/com/marsrover/Main.java
````

### Step 2: Run the Application

Run the compiled program:

```bash
java -cp bin com.marsrover.Main
```

### Step 3: Follow the Prompts

* Enter grid dimensions, obstacles, rover starting position, and command sequence.
* The simulation logs will display in real-time, followed by the final position.

---

## 📝 Example Session

```
Enter grid width and height (e.g., 10 10):
10 10
Enter the number of obstacles:
2
Enter position for obstacle 1 (x y):
2 2
Enter position for obstacle 2 (x y):
3 5
Enter Rover's starting position and direction (e.g., 0 0 N):
0 0 N
Enter the command string (e.g., MMRMLM):
MMRMLM

--- Mars Rover Simulation Starting ---
...logs...
--- Simulation Complete ---
Final position: Rover is at (1, 3) facing NORTH.
```

> ✅ Note: The final position `(1, 3, NORTH)` is calculated correctly according to the command sequence.

---

## 🎯 Project Highlights

* Strong emphasis on **OOP** and **SOLID principles**.
* Implemented **Command, Composite, and State patterns** for robust design.
* Dynamic and interactive simulation.
* Scalable architecture suitable for extending new commands or grid features.

---

## 📂 Project Structure

```
src/
├─ com/marsrover/command/      # Command pattern implementations
├─ com/marsrover/grid/         # Grid, obstacles, and composite components
├─ com/marsrover/rover/        # Rover logic and movement
├─ com/marsrover/util/         # Utility classes (e.g., input parser)
└─ com/marsrover/Main.java     # Entry point
```

