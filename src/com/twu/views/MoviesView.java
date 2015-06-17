package com.twu.views;

import com.twu.Movies;

import java.io.PrintStream;

// Prints list of movies
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
