package io.muic.zork;

import io.muic.zork.command.Command;
import io.muic.zork.command.CommandFactory;

import java.util.*;
import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();
    private Player player = Player.getInstance();





    public void run() {
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("> ");
            String input = scan.nextLine();
            List<String> allwords = commandParser.parse(input);
            if (allwords == null) continue; // Parsing unsuccessful

            // From allwords, get the Command and execute them
            Command command = CommandFactory.get(allwords.get(0));
            command.execute(this, allwords.subList(1, allwords.size()));

            System.out.println(allwords);
//            output.println(input);
        }

    }


    public void exit() {
        System.exit(0);
    }




    // Getters

    public GameOutput getOutput() {
        return output;
    }


    // Setters

}
