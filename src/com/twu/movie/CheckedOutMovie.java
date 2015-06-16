package com.twu.movie;

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
        return null;
    }

    public static CheckedOutMovie create(AvailableMovie availableMovie) {
        return new CheckedOutMovie(availableMovie.name, availableMovie.director, availableMovie.year,
                availableMovie.movieRating);
    }
}
