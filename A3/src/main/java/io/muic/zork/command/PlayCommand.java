package io.muic.zork.command;

import io.muic.zork.Game;
import io.muic.zork.GameMap;
import io.muic.zork.Player;

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

    /**
     * This function basically starts up the whole gameplay.
     * It loads the map from the input and constructs a GameMap for Game.
     * It also initialized new player with position according to the chosen map.
     * @param game
     * @param args
     * @throws IOException
     */
    @Override
    public void execute(Game game, List<String> args) throws IOException {
        String mapName = args.get(0);
        System.out.printf("Entering %s...\n\n", mapName);

        // From args, create a path to the map file
        StringBuffer sr = new StringBuffer();
        sr.append("src\\main\\resources\\");
        sr.append(mapName);
        sr.append(".txt");
        String path = sr.toString(); // Finalized path

        // With the path ready, we now starts the map and other aspects of the game
        if (game.isStartScreen()) {
            try {
                GameMap gameMap = new GameMap(path);
                game.setGameMap(gameMap); // Set the new map using path
                game.switchStartScreen(); // Once map is decided, it is no longer startScreen

                // Create new player and set them on the map's indicated starting position
                Player player = new Player(gameMap.getpStartRow(), gameMap.getpStartCol());
                game.setPlayer(player);
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
