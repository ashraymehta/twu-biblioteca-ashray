package com.twu.movie;

public class AvailableMovie extends Movie {
    public AvailableMovie(String name, String director, int year, int movieRating) {
        super(name, director, year, movieRating);
    }

    @Override
    public Movie checkout() {
        return CheckedOutMovie.create(this);
    }

    public static AvailableMovie create(CheckedOutMovie checkedOutMovie) {
        return new AvailableMovie(checkedOutMovie.name, checkedOutMovie.director, checkedOutMovie.year,
                checkedOutMovie.movieRating);
    }
}