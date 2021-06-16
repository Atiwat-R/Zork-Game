package io.muic.zork;

import io.muic.zork.command.Command;
import io.muic.zork.command.CommandFactory;

import java.util.*;

public class CommandParser {

    private List<String> allCommandsSortedByLength = new ArrayList<>();
    {
        allCommandsSortedByLength.addAll(CommandFactory.getAllCommands());
        allCommandsSortedByLength.sort((o1,o2) -> o2.length() - o1.length());
    }

    // Obtain the input's command part
    private String matchInputCommand(String input) {
        for (String command: allCommandsSortedByLength) {
            if (input.startsWith(command)) return command;
        }
        return null;
    }

    // From a String input, return a list of either [command] or [command, arguments]
    public List<String> parse(String stringInput) {
        String clearedInput = stringInput.trim().toLowerCase();
        String cmd = matchInputCommand(clearedInput);

        // If input command is invalid
        if (cmd == null) {
            System.out.println("!!! Invalid Command !!!");
            return null;
        }

        Command command = CommandFactory.get(cmd);

        // If command is valid but there's too little/too much arguments
//        String[] inputList = stringInput.trim().split(" ");
//        if (inputList.length - 1 != command.numArgs()) {
//            System.out.println("!!! Invalid Number of Argument/s !!!");
//            return null;
//        }

        if (command.numArgs() > 0) {
            String argString = clearedInput.substring(cmd.length()).trim();
            return Arrays.asList(cmd, argString);
        }
        else {
            return Arrays.asList(cmd);
        }
    }



}
