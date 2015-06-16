package com.twu;

import com.twu.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class Movies {
    private List<Movie> listOfMovies;

    public Movies(ArrayList<Movie> listOfMovies) {
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
