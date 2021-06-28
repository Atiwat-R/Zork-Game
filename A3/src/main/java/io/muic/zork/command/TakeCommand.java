package io.muic.zork.command;

import io.muic.zork.Game;
import io.muic.zork.Room;
import io.muic.zork.item.Item;

import java.io.IOException;
import java.util.List;

public class TakeCommand implements Command {
    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommandString() {
        return "take";
    }

    @Override
    public void execute(Game game, List<String> args) throws IOException {
        // This command is only available at Gameplay
        if (game.isStartScreen()) {
            System.out.println("!!! Only avalable during Gameplay !!!");
            return;
        }
        int pRow = game.getPlayer().getpRow();
        int pCol = game.getPlayer().getpCol();
        Room currentRoom = game.getGameMap().getRoomAt(pRow, pCol); // Get current room the player is in
        Item roomItem = currentRoom.getItem(); // Get item that's in this room

        if (roomItem == null) { // In case there's no item
            System.out.println("!!! No item to take !!!");
            return;
        }

        // Add item into inventory.
        if (!game.getPlayer().getInventory().addItem(roomItem)) {
            return;  //If failed (return false) exit this function.
        }
        else {
            // If succeeded, remove that item from the room
            currentRoom.setItem(null);
        }

    }


}
