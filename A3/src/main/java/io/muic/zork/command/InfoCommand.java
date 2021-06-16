package io.muic.zork.command;

import io.muic.zork.Game;

import java.util.List;

public class InfoCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommandString() {
        return "info";
    }

    @Override
    public void execute(Game game, List<String> args) {
        game.getOutput().println("Game Stats");
    }
}
