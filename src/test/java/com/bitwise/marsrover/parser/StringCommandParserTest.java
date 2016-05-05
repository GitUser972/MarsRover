package com.bitwise.marsrover.parser;

import org.junit.Assert;
import org.junit.Test;

import com.bitwise.marsrover.commands.ICommand;
import com.bitwise.marsrover.commands.MoveCommand;
import com.bitwise.marsrover.commands.RotateLeftCommand;
import com.bitwise.marsrover.commands.RotateRightCommand;
import com.bitwise.marsrover.parser.StringCommandParser;

import java.util.List;

public class StringCommandParserTest {

    @Test
    public void stringLMapsToRotateLeftCommand() {
        //Given
        StringCommandParser parser = new StringCommandParser("L");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof RotateLeftCommand);
        Assert.assertEquals(1, commands.size());
    }

    @Test
    public void stringRMapsToRotateRightCommand() {
        //Given
        StringCommandParser parser = new StringCommandParser("R");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof RotateRightCommand);
    }

    @Test
    public void stringMMapsToMoveCommand() {
        //Given
        StringCommandParser parser = new StringCommandParser("M");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveCommand);
    }


    @Test
    public void emptyStringResultsInEmptyCommandList() {
        //Given
        StringCommandParser parser = new StringCommandParser("");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertEquals(0, commands.size());
    }


    @Test
    public void nullStringResultsInEmptyCommandList() {
        //Given
        StringCommandParser parser = new StringCommandParser(null);

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertEquals(0, commands.size());
    }

    @Test
    public void stringToCommandMappingIsCaseInsensitive() {
        //Given
        StringCommandParser parser = new StringCommandParser("mM");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveCommand);
        Assert.assertTrue(commands.get(1) instanceof MoveCommand);
    }

    @Test
    public void multiCommandStringIsMappedToCommandsInSameOrder() {
        //Given
        StringCommandParser parser = new StringCommandParser("MRL");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof MoveCommand);
        Assert.assertTrue(commands.get(1) instanceof RotateRightCommand);
        Assert.assertTrue(commands.get(2) instanceof RotateLeftCommand);
    }

}
