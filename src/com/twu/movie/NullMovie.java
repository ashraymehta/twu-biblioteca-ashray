package com.twu.movie;

import com.twu.Messages;

import java.util.List;

public class NullMovie extends Movie {
    public NullMovie() {
        super("", "", 0, 0);
    }

    @Override
    public Movie checkout() {
        return this;
    }

    @Override
    public String getAppropriateCheckoutMessage() {
        return Messages.UNSUCCESSFUL_MOVIE_CHECKOUT_MESSAGE;
    }

    @Override
    public void addToListIfAvailable(List<Movie> availableMovies) {

    }
}
