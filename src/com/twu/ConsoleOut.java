package com.twu;

import java.io.PrintStream;

import static com.twu.Messages.WELCOME_MESSAGE;

// Handles output to console
public class ConsoleOut {

    private PrintStream printStream;

    public ConsoleOut(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printWelcomeMessage() {
        printStream.println(WELCOME_MESSAGE);
    }
}