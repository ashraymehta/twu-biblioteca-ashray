package com.twu.views;

import java.io.PrintStream;
import java.util.Scanner;

// Prints list of books that are checked out, gets user selection and feedback of successful or unsuccessful return
public class ReturnMovieView {
    private Scanner scanner;
    private PrintStream printStream;

    public ReturnMovieView(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public String getMovieName() {
        return scanner.nextLine();
    }

    public void printMessage(String message) {
        printStream.println(message);
    }
}