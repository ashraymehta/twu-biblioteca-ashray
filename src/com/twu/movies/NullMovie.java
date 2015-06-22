package com.twu.movies;

import com.twu.Messages;
import com.twu.user.AbstractUser;

import java.util.List;

// Represents a null movie
public class NullMovie extends Movie {
    public NullMovie() {
        super("", "", 0, 0);
    }

    @Override
    public Movie checkout(AbstractUser customer) {
        return this;
    }

    @Override
    public String getAppropriateCheckoutMessage() {
        return Messages.UNSUCCESSFUL_MOVIE_CHECKOUT_MESSAGE;
    }

    @Override
    public void addToListIfAvailable(List<Movie> availableMovies) {

    }

    @Override
    public Movie returnMovie() {
        return this;
    }

    @Override
    public String getAppropriateReturnMessage() {
        return Messages.UNSUCCESSFUL_MOVIE_RETURN_MESSAGE;
    }

    @Override
    public void addToListIfCheckedOut(List<Movie> checkedOutMovies) {

    }

    @Override
    public String toString() {
        return Messages.NO_MOVIE_FOUND;
    }
}
