package io.muic.zork.command;

import io.muic.zork.Game;

import java.io.IOException;
import java.util.*;

public interface Command {

    /**
     * Return the number of arguments
     */
    int numArgs();

    /**
     * Return the String representation of the Command
     */
    String getCommandString();

    /**
     * Executes the command
     */
    void execute(Game game, List<String> args) throws IOException;

}
