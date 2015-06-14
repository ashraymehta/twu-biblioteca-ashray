package com.twu;

import java.io.PrintStream;

// Handles all output to console
public class ConsoleOut {

    private PrintStream printStream;

    public ConsoleOut(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printWelcomeMessage() {
        printStream.println("Welcome");
    }
}