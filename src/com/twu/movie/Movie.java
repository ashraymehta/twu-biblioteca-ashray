package com.twu.movie;

// Represents a Movie with comparison checks for the object as well as some properties
public abstract class Movie {
    protected String name;
    protected String director;
    protected int year;
    protected int movieRating;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        Movie movie = (Movie) o;

        if (year != movie.year) return false;
        if (movieRating != movie.movieRating) return false;
        if (!name.equals(movie.name)) return false;
        return director.equals(movie.director);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + year;
        result = 31 * result + director.hashCode();
        result = 31 * result + movieRating;
        return result;
    }

    public abstract Movie checkout();

    public abstract String getAppropriateCheckoutMessage();
}
