package com.twu.movie;

import com.twu.Messages;

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
        return Messages.SUCCESSFUL_BOOK_CHECKOUT_MESSAGE;
    }

    public static CheckedOutMovie create(AvailableMovie availableMovie) {
        return new CheckedOutMovie(availableMovie.name, availableMovie.director, availableMovie.year,
                availableMovie.movieRating);
    }
}
