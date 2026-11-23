package com.seminar2.command;

// Command: one action on an order, turned into an object.
public interface OrderCommand {
    void execute();

    String getDescription();
}
