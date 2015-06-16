package com.twu;

import com.twu.movie.Movie;

import java.util.Set;

public class Movies {
    private Set<Movie> listOfMovies;

    public Movies(Set<Movie> listOfMovies) {
        this.listOfMovies = listOfMovies;
    }

    @Override
    public String toString() {
        String listOfBooksAsString = "";
        for (Movie movie : listOfMovies)
            listOfBooksAsString += movie + System.lineSeparator();
        return listOfBooksAsString;
    }
}
