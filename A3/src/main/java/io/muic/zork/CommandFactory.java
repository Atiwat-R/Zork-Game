package io.muic.zork;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

import io.muic.zork.command.Command;
import io.muic.zork.command.ExitCommand;

public class CommandFactory {

    private static final List< Class<? extends Command> > REGISTERED_COMMAND = Arrays.asList(
            ExitCommand.class
    );

    private static final Map<String, Command> COMMAND_MAP = new HashMap<>();

    static {{
        for (Class<? extends Command> commandClass: REGISTERED_COMMAND) {
            try {
                Command command = commandClass.getDeclaredConstructor().newInstance();
                COMMAND_MAP.put(command.getCommand(), command);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }}


    public static Command get(String command) {
        return COMMAND_MAP.get(command);
    }

    public static List<String> getAllCommands() {
        return COMMAND_MAP.keySet().stream().collect(Collectors.toList());
    }


}
