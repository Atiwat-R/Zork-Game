package io.muic.zork.command;

import io.muic.zork.Game;

import java.io.IOException;
import java.util.List;

public class GoCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommandString() {
        return "go";
    }

    @Override
    public void execute(Game game, List<String> args) throws IOException {
        // This command is only available at Gameplay
        if (game.isStartScreen()) {
            System.out.println("!!! Only avalable during Gameplay !!!");
            return;
        }
        String moveTo = args.get(0);
        int newRow = game.getPlayer().getpRow();
        int newCol = game.getPlayer().getpCol();

        // If the direction is open for traversal in such room.
        String allOpenDoors = game.getGameMap().getRoomAt(newRow, newCol).getAllOpenDoors();
        if (allOpenDoors.indexOf(moveTo.charAt(0)) < 0) { // Problem
            System.out.println("!!! That direction is closed off !!!");
            return;
        }

        switch(moveTo)
        {
            case "north": // (0,-1)
                newCol = newCol - 1;
                break;
            case "south": // (0,1)
                newCol = newCol + 1;
                break;
            case "east": // (1,0)
                newRow = newRow + 1;
                break;
            case "west": // (-1,0)
                newRow = newRow - 1;
                break;
            default:
                System.out.println("!!! Pick from: NORTH, SOUTH, EAST, WEST !!!");
                return;
        }
        // Check validity of the new coordinate
        if (game.getGameMap().isValidCoord(newRow, newCol)) {
            System.out.printf("Walking %s...\n\n", moveTo);
            game.getPlayer().setPlayerPosition(newRow, newCol);

            // Print the Room we've arrived in, for convenience
            game.getGameMap().printContentAtRoom(newRow, newCol);
        }
        else {
            System.out.println("!!! Invalid Direction !!!");
        }
        //TODO: print game.getRoomInfo
    }
}


