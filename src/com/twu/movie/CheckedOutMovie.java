package com.twu.movie;

import com.twu.Messages;

import java.util.List;

public class CheckedOutMovie extends Movie {
    public CheckedOutMovie(String name, String director, int year, int movieRating) {
        super(name, director, year, movieRating);
    }

    @Override
    public Movie checkout() {
        return null;
    }

    @Override
    public String getAppropriateCheckoutMessage() {
        return Messages.SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE;
    }

    @Override
    public void addToListIfAvailable(List<Movie> availableMovies) {

    }

    @Override
    public Movie returnMovie() {
        return AvailableMovie.create(this);
    }

    @Override
    public String getAppropriateReturnMessage() {
        return Messages.UNSUCCESSFUL_MOVIE_RETURN_MESSAGE;
    }

    public static CheckedOutMovie create(AvailableMovie availableMovie) {
        return new CheckedOutMovie(availableMovie.name, availableMovie.director, availableMovie.year,
                availableMovie.movieRating);
    }
}
