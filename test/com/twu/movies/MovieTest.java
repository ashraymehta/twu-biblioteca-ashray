package com.twu.movies;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieTest {

    private Movie firstMovie;
    private Movie secondMovie;
    private Movie thirdMovie;

    @Before
    public void setUp() throws Exception {
        firstMovie = new AvailableMovie("Batman Begins", "Christopher Nolan", 2005, 9);
        secondMovie = new AvailableMovie("Batman Begins", "Christopher Nolan", 2005, 9);
        thirdMovie = new AvailableMovie("Batman Begins", "Christopher Nolan", 2005, 9);
    }

    @Test
    public void shouldPresentDetailsOfBookAsString() throws Exception {
        String name = "Batman Begins";
        String director = "Christopher Nolan";
        int year = 2005;
        int movieRating = 9;
        Movie movie = new AvailableMovie(name, director, year, movieRating);

        String actualString = movie.toString();
        String expectedString = "Batman Begins                                     " +
                "Christopher Nolan             " + "2005      " + "9    ";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldAddToItselfToListIfNameMatches() throws Exception {
        String name = "Batman Begins";
        String director = "Christopher Nolan";
        int year = 2005;
        int movieRating = 9;
        Movie movie = new AvailableMovie(name, director, year, movieRating);
        ArrayList<Movie> matchingList = new ArrayList<>();
        movie.addToListIfNameMatches(matchingList, "Batman Begins");

        assertTrue(matchingList.contains(movie));
    }

    @Test
    public void shouldBeEqualToItself() {

        boolean actual = firstMovie.equals(firstMovie);

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowSymmetricProperty() {

        boolean actual = (firstMovie.equals(secondMovie) == secondMovie.equals(firstMovie));

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        boolean actual = firstMovie.equals(secondMovie) &&
                secondMovie.equals(thirdMovie) &&
                firstMovie.equals(thirdMovie);

        assertEquals(true, actual);
    }

    @Test
    public void shouldHaveSameHashCodeIfMoviesAreEqual() {
        boolean actual = firstMovie.equals(secondMovie) && (firstMovie.hashCode() == secondMovie.hashCode());

        assertEquals(true, actual);
    }
}