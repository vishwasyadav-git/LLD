package com.scaler.splitwisecli.commands;

public interface Command {
    void execute(String input);
    boolean matches(String input);

}
