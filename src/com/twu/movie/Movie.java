package com.twu.movie;

public class Movie {
    private String name;
    private int year;
    private String director;
    private int movieRating;

    public Movie(String name, String director, int year, int movieRating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
    }

    @Override
    public String toString() {
        return String.format("%-50s", name) + String.format("%-30s", director)
                + String.format("%-10s", year) + String.format("%-5s", movieRating);
    }
}
