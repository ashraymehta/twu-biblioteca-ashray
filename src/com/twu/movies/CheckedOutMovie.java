package com.twu.movies;

import com.twu.Messages;
import com.twu.user.Customer;

import java.util.List;

public class CheckedOutMovie extends Movie {
    public CheckedOutMovie(String name, String director, int year, int movieRating, Customer customer) {
        super(name, director, year, movieRating);
    }

    public static CheckedOutMovie create(AvailableMovie availableMovie, Customer customer) {
        return new CheckedOutMovie(availableMovie.name, availableMovie.director, availableMovie.year,
                availableMovie.movieRating, customer);
    }

    @Override
    public Movie checkout(Customer customer) {
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
}
