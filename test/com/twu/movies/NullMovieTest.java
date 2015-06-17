package com.twu.movies;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class NullMovieTest {

    private NullMovie nullMovie;
    private List<Movie> checkedOutMovies;

    @Before
    public void setUp() throws Exception {
        checkedOutMovies = new ArrayList<>();
        nullMovie = new NullMovie();
    }

    @Test
    public void shouldNotAddToCheckedOutList() throws Exception {
        nullMovie.addToListIfCheckedOut(checkedOutMovies);

        assertFalse(checkedOutMovies.contains(nullMovie));
    }
}