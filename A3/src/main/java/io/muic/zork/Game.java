package io.muic.zork;

import io.muic.zork.command.Command;
import io.muic.zork.command.CommandFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
//import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();
    private Player player;
    private GameMap gameMap;
    private boolean startScreen = true;



    public void run() throws IOException {
        while(true) {
            // Take user's input
            Scanner scan = new Scanner(System.in);
            System.out.print("> ");
            String input = scan.nextLine();
            List<String> allwords = commandParser.parse(input);
            if (allwords == null) continue; // Parsing unsuccessful

            // From allwords, get the Command and execute them
            Command command = CommandFactory.get(allwords.get(0));
            command.execute(this, allwords.subList(1, allwords.size()));


//            System.out.println(allwords);
//            output.println(input);
        }

    }


    // Other utilities
    public void switchStartScreen() {
        startScreen = !startScreen;
    }




    // Command methods
    public void exit() {
        System.exit(0);
    }



    // Getters
    public boolean isStartScreen() {
        return startScreen;
    }
    public GameOutput getOutput() {
        return output;
    }
    public Player getPlayer() {
        return player;
    }
    public GameMap getGameMap() {
        return gameMap;
    }

    // Setters
    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
}
