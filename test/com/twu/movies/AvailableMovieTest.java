package com.twu.movies;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class AvailableMovieTest {

    private AvailableMovie availableMovie;
    private List<Movie> checkedOutMovies;

    @Before
    public void setUp() throws Exception {
        checkedOutMovies = new ArrayList<>();
        availableMovie = new AvailableMovie("Name", "Director", 1000, 10);
    }

    @Test
    public void shouldNotAddToCheckedOutList() throws Exception {
        availableMovie.addToListIfCheckedOut(checkedOutMovies);

        assertFalse(checkedOutMovies.contains(availableMovie));
    }
}