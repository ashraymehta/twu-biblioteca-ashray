package com.twu.views;

import com.twu.Messages;
import com.twu.movies.Movie;

import java.io.PrintStream;
import java.util.Scanner;

// Takes user input and prints details of a book
public class CheckedOutMovieDetailsView {
    private Scanner scanner;
    private PrintStream printStream;

    public CheckedOutMovieDetailsView(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void printMovieDetails(Movie movie) {
        printStream.println(movie);
    }

    public void printNoMovieFoundMessage() {
        printStream.println(Messages.NO_MOVIE_FOUND);
    }
}
