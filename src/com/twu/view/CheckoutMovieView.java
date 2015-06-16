package com.twu.view;

import com.twu.Movies;

import java.io.PrintStream;
import java.util.Scanner;

// Prints list of available books, gets user selection and feedback on successful or unsuccessful checkoutBook
public class CheckoutMovieView {

    private Movies movies;
    private final Scanner scanner;
    private final PrintStream printStream;

    public CheckoutMovieView(Movies movies, Scanner scanner, PrintStream printStream) {
        this.movies = movies;
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