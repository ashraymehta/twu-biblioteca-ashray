package com.twu;

import com.twu.movies.Movie;

import java.util.List;

public class Movies {
    private List<Movie> movieSet;

    public Movies(List<Movie> movieSet) {
        this.movieSet = movieSet;
    }

    @Override
    public String toString() {
        String listOfBooksAsString = "";
        for (Movie movie : movieSet)
            listOfBooksAsString += movie + System.lineSeparator();
        return listOfBooksAsString;
    }
}
