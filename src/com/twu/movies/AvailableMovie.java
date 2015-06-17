package com.twu.movies;

import com.twu.Messages;

import java.util.List;

public class AvailableMovie extends Movie {
    public AvailableMovie(String name, String director, int year, int movieRating) {
        super(name, director, year, movieRating);
    }

    public static AvailableMovie create(CheckedOutMovie checkedOutMovie) {
        return new AvailableMovie(checkedOutMovie.name, checkedOutMovie.director, checkedOutMovie.year,
                checkedOutMovie.movieRating);
    }

    @Override
    public Movie checkout() {
        return CheckedOutMovie.create(this);
    }

    @Override
    public String getAppropriateCheckoutMessage() {
        return Messages.UNSUCCESSFUL_MOVIE_CHECKOUT_MESSAGE;
    }

    @Override
    public void addToListIfAvailable(List<Movie> availableMovies) {
        availableMovies.add(this);
    }

    @Override
    public Movie returnMovie() {
        return this;
    }

    @Override
    public String getAppropriateReturnMessage() {
        return Messages.SUCCESSFUL_MOVIE_RETURN_MESSAGE;
    }
}