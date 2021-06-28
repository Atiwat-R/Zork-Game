package io.muic.zork.command;

import io.muic.zork.Game;

import java.io.IOException;
import java.util.List;

public class HelpCommand implements Command {
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommandString() {
        return "help";
    }

    @Override
    public void execute(Game game, List<String> args) throws IOException {
        List<String> allCommands = CommandFactory.getAllCommands();
        System.out.println("Command List:");
        for (String command: allCommands) {
            System.out.printf("+ %s\n", command);
        }
        System.out.println("-----------------------");
    }

}
