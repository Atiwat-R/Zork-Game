package io.muic.zork.command;

import io.muic.zork.Game;
import io.muic.zork.GameMap;
import io.muic.zork.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class QuitCommand implements Command {
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommandString() {
        return "quit";
    }

    @Override
    public void execute(Game game, List<String> args) throws IOException {

        // If its currently Gameplay screen
        if (!game.isStartScreen()) {
            // Reset everything
            game.setGameMap(null);
            game.setPlayer(null);

            System.out.println("\nReturning to Start Screen...");
            game.switchStartScreen(); // Switch to Start Screen
        }
        else {
            System.out.println("!!! You are currently at Start Screen !!!");
        }

    }
}
