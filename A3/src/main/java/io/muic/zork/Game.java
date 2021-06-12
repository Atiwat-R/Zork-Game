package io.muic.zork;

import java.util.*;
import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();

    public void run() {

        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("> ");
            String input = scan.nextLine();
            List<String> allwords = commandParser.parse(input);

            if (allwords == null) continue; // Parsing unsuccessful

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
