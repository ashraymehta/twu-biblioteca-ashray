package com.twu.movies;

import com.twu.Messages;
import com.twu.user.Customer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

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

    @Test
    public void shouldReturnItselfWhenCheckingOut() throws Exception {
        Movie actualMovie = nullMovie.checkout(mock(Customer.class));

        assertEquals(nullMovie, actualMovie);
    }

    @Test
    public void shouldReturnItselfWhenReturningToLibrary() throws Exception {
        Movie actualMovie = nullMovie.returnMovie();

        assertEquals(nullMovie, actualMovie);
    }

    @Test
    public void shouldReturnUnsuccessfulCheckoutMessage() throws Exception {
        String actualMessage = nullMovie.getAppropriateCheckoutMessage();

        assertEquals(Messages.UNSUCCESSFUL_MOVIE_CHECKOUT_MESSAGE, actualMessage);
    }

    @Test
    public void shouldReturnUnsuccessfulReturnMessage() throws Exception {
        String actualMessage = nullMovie.getAppropriateReturnMessage();

        assertEquals(Messages.UNSUCCESSFUL_MOVIE_RETURN_MESSAGE, actualMessage);
    }

    @Test
    public void shouldHaveNoMovieFoundAsStringRepresentation() throws Exception {
        String actualString = nullMovie.toString();

        assertEquals(Messages.NO_MOVIE_FOUND, actualString);
    }
}