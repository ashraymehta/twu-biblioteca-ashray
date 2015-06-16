package com.twu.view;

import java.io.PrintStream;

public class MoviesView {
    private Movies movies;
    private PrintStream printStream;

    public MoviesView(Movies movies, PrintStream printStream) {
        this.movies = movies;
        this.printStream = printStream;
    }

    public void printListOfMovies() {
        printStream.println(movies);
    }
}
