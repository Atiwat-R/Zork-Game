package io.muic.zork.command;

import io.muic.zork.Game;

import java.util.List;

public class ExitCommand implements Command {


    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "exit";
    }

    @Override
    public void execute(Game game) {
        game.getOutput().println("Exited");
        game.exit();
    }
}