package com.twu.movie;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldPresentDetailsOfBookAsString() throws Exception {
        String name = "Batman Begins";
        String director = "Christopher Nolan";
        int year = 2005;
        int movieRating = 9;
        Movie movie = new Movie(name, director, year, movieRating);

        String actualString = movie.toString();
        String expectedString = "Batman Begins                                     " +
                "Christopher Nolan             " + "2005      " + "9    ";

        assertEquals(expectedString, actualString);
    }
}