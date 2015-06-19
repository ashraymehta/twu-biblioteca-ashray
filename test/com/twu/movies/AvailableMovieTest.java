package com.twu.movies;

import com.twu.Messages;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
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

    @Test
    public void shouldReturnUnsuccessfulCheckoutMessage() throws Exception {
        String actualMessage = availableMovie.getAppropriateCheckoutMessage();

        assertEquals(actualMessage, Messages.UNSUCCESSFUL_MOVIE_CHECKOUT_MESSAGE);
    }

    @Test
    public void shouldReturnSuccessfulReturnMessage() throws Exception {
        String actualMessage = availableMovie.getAppropriateReturnMessage();

        assertEquals(actualMessage, Messages.SUCCESSFUL_MOVIE_RETURN_MESSAGE);
    }

    @Test
    public void shouldReturnItselfWhenAskedToReturnToLibrary() throws Exception {
        Movie actualResult = availableMovie.returnMovie();

        assertEquals(availableMovie, actualResult);
    }
}