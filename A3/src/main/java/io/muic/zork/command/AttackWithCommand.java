package io.muic.zork.command;

import io.muic.zork.Game;

import java.util.List;

public class AttackWithCommand implements Command{

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommandString() {
        return "attack with";
    }

    @Override
    public void execute(Game game, List<String> args) {
        game.getOutput().println("attack with");
    }

}
