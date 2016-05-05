package com.bitwise.marsrover;

import java.util.List;

import com.bitwise.marsrover.commands.ICommand;
import com.bitwise.marsrover.parser.StringCommandParser;
import com.bitwise.marsrover.universe.Coordinates;
import com.bitwise.marsrover.universe.Direction;
import com.bitwise.marsrover.universe.Plateau;

public class MarsRover {

    private Coordinates currentCoordinates;
    private Direction currentDirection;
    private Plateau plateau;


    public MarsRover(final Plateau plateau, final Direction direction, final Coordinates coordinates) {
        this.plateau = plateau;
        this.currentDirection = direction;
        this.currentCoordinates = coordinates;
    }

    public void run(final String commandString) {
        List<ICommand> roverCommands = new StringCommandParser(commandString).toCommands();
        for (ICommand command : roverCommands) {
            command.execute(this);
        }
    }

    public String currentLocation() {
        return currentCoordinates.toString() + " " + currentDirection.toString();
    }

    public void turnRight() {
        this.currentDirection = this.currentDirection.right();
    }

    public void turnLeft() {
        this.currentDirection = this.currentDirection.left();
    }

    public void move() {
        Coordinates positionAfterMove = currentCoordinates.newCoordinatesForStepSize(currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForYAxis());

        //ignores the command if rover is being driven off plateau
        if(plateau.hasWithinBounds(positionAfterMove))
            currentCoordinates = currentCoordinates.newCoordinatesFor(currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForYAxis());
    }
    public static void main(String[] args) {
    	 Plateau plateau = new Plateau(5,5);
         Coordinates startingPosition = new Coordinates(1,2);
         MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);
         marsRover.run("LMLMLMLMM");
         System.out.println(marsRover.currentLocation());
         
	}
}
