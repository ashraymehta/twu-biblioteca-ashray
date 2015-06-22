package com.twu.movies;

import com.twu.Messages;
import com.twu.user.AbstractUser;

import java.util.List;

// Represents a checked out movie and provides APIs to return the movie
public class CheckedOutMovie extends Movie {
    private AbstractUser checkedOutTo;

    public CheckedOutMovie(String name, String director, int year, int movieRating, AbstractUser customer) {
        super(name, director, year, movieRating);
        checkedOutTo = customer;
    }

    public static CheckedOutMovie create(AvailableMovie availableMovie, AbstractUser customer) {
        return new CheckedOutMovie(availableMovie.name, availableMovie.director, availableMovie.year,
                availableMovie.movieRating, customer);
    }

    @Override
    public Movie checkout(AbstractUser customer) {
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

    @Override
    public void addToListIfCheckedOut(List<Movie> checkedOutMovies) {
        checkedOutMovies.add(this);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s", checkedOutTo);
    }
}
