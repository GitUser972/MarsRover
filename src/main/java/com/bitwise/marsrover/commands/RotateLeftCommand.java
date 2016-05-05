package com.bitwise.marsrover.commands;

import com.bitwise.marsrover.MarsRover;

public class RotateLeftCommand implements ICommand {

    
    public void execute(final MarsRover rover) {
        rover.turnLeft();
    }

}
