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
        // This command is only available at Gameplay
        if (game.isStartScreen()) {
            System.out.println("!!! Only avalable during Gameplay !!!");
            return;
        }
        // Print Player info
        if (game.getPlayer() != null) {
            game.getPlayer().printCurrentStatus();
        }
        // Print Room content
        if (game.getGameMap() != null) {
            game.getGameMap().printContentAtRoom(game.getPlayer().getpRow(), game.getPlayer().getpCol());
        }
    }
}
