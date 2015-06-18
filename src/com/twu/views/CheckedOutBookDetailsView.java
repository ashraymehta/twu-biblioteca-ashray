package com.twu.views;

import java.io.PrintStream;
import java.util.Scanner;

public class CheckedOutBookDetailsView {
    private Scanner scanner;
    private PrintStream printStream;

    public CheckedOutBookDetailsView(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public String getUserInput() {
        return scanner.nextLine();
    }
}
