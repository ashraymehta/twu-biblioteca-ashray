package com.twu;

import com.twu.movies.Movie;

import java.util.ArrayList;
import java.util.Set;

// Searches a movie's name in a collection of movies
public class MovieSearcher {
    private Movie nullMovie;

    public MovieSearcher(Movie nullMovie) {
        this.nullMovie = nullMovie;
    }

    public Movie search(Set<Movie> movies, String name) {
        ArrayList<Movie> matchingList = new ArrayList<>();
        for (Movie movie : movies) {
            movie.addToListIfNameMatches(matchingList, name);
        }
        if (matchingList.size() > 0)
            return matchingList.get(0);
        else
            return nullMovie;
    }
}
