package com.bitwise.marsrover.commands;

import com.bitwise.marsrover.MarsRover;

public class RotateRightCommand implements ICommand {

   
    public void execute(final MarsRover rover) {
        rover.turnRight();
    }

}
