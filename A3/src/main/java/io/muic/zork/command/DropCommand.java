package io.muic.zork.command;

import io.muic.zork.Game;

import java.io.IOException;
import java.util.List;

public class DropCommand implements Command{
    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommandString() {
        return "drop";
    }

    @Override
    public void execute(Game game, List<String> args) throws IOException {
        // This command is only available at Gameplay
        if (game.isStartScreen()) {
            System.out.println("!!! Only avalable during Gameplay !!!");
            return;
        }
        // Drop the item. This will effectively destroy the item.
        game.getPlayer().getInventory().removeItem(args.get(0));

    }
}
