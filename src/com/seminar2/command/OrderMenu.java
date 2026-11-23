package com.seminar2.command;

import java.util.HashMap;
import java.util.Map;

// Command: the INVOKER. Every menu key holds a command, like the buttons of a remote.
// The menu runs the command without knowing what it does.
public class OrderMenu {

    private Map<String, OrderCommand> options = new HashMap<>();

    public void addOption(String key, OrderCommand command) {
        options.put(key, command);
    }

    public void select(String key) {
        OrderCommand command = options.get(key);
        if (command == null) {
            System.out.println("Unknown choice: " + key);
        } else {
            command.execute();
            System.out.println("Done: " + command.getDescription());
        }
    }
}
