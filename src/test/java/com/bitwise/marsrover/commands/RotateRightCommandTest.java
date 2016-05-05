package com.bitwise.marsrover.commands;

import org.junit.Assert;
import org.junit.Test;

import com.bitwise.marsrover.MarsRover;
import com.bitwise.marsrover.commands.RotateRightCommand;
import com.bitwise.marsrover.universe.Coordinates;
import com.bitwise.marsrover.universe.Direction;
import com.bitwise.marsrover.universe.Plateau;

public class RotateRightCommandTest {

    @Test
    public void testThatRotateRightCommandRotatesTheNavigableObjectRight() {
        //Given
        RotateRightCommand command = new RotateRightCommand();
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MarsRover rover = new MarsRover(plateau, Direction.N, startingPosition);

        //When
        command.execute(rover);

        //Then
        Assert.assertEquals("1 2 E", rover.currentLocation());
    }

}
