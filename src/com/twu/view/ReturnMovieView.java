package com.twu.view;

import com.twu.Movies;

import java.io.PrintStream;
import java.util.Scanner;

// Prints list of books that are checked out, gets user selection and feedback of successful or unsuccessful return
public class ReturnMovieView {
    private Movies movies;
    private Scanner scanner;
    private PrintStream printStream;

    public ReturnMovieView(Movies movies, Scanner scanner, PrintStream printStream) {
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