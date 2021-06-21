package io.muic.zork.command;

import io.muic.zork.Game;
import io.muic.zork.GameMap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PlayCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommandString() {
        return "play";
    }

    @Override
    public void execute(Game game, List<String> args) throws IOException {
        String mapName = args.get(0);
        System.out.printf("Entering %s...", mapName);

        // From args, create a path to the map file
        StringBuffer sr = new StringBuffer();
        sr.append("src\\main\\resources\\");
        sr.append(mapName);
        sr.append(".txt");
        String path = sr.toString(); // Finalized path

        // Start map
        if (game.isStartScreen()) {
            try {
                game.setGameMap(new GameMap(path)); // Set the new map using path
                game.switchStartScreen(); // Once map is decided, it is no longer startScreen
            }
            catch (FileNotFoundException e) {
                System.out.println("!!! No such map found !!!");
            }
        }
        else {
            System.out.println("!!! Can only choose another map at Start Screen !!!");
        }
    }

}
