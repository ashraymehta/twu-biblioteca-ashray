package com.twu.views;

import java.io.PrintStream;
import java.util.Scanner;

// Prints list of available movies, gets user selection and feedback on successful or unsuccessful checkoutBook
public class CheckoutMovieView {

    private final Scanner scanner;
    private final PrintStream printStream;

    public CheckoutMovieView(Scanner scanner, PrintStream printStream) {
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