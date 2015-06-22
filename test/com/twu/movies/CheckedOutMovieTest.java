package com.twu.movies;

import com.twu.Messages;
import com.twu.user.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CheckedOutMovieTest {
    private Customer customer;
    private CheckedOutMovie checkedOutMovie;
    private List<Movie> checkedOutMovies;

    @Before
    public void setUp() throws Exception {
        checkedOutMovies = new ArrayList<>();
        customer = new Customer("123-4567", "Password", "Name", "Email", "Phone");
        checkedOutMovie = new CheckedOutMovie("Batman Begins", "Christopher Nolan", 2005, 9, customer);
    }

    @Test
    public void shouldPresentMovieDetailsAsString() throws Exception {
        String actualString = checkedOutMovie.toString();
        String expectedString = "Batman Begins                                     " +
                "Christopher Nolan             2005      9    123-4567            " +
                "Name                          Email                         Phone          ";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldAddItselfToCheckedOutList() throws Exception {
        checkedOutMovie.addToListIfCheckedOut(checkedOutMovies);

        assertTrue(checkedOutMovies.contains(checkedOutMovie));
    }

    @Test
    public void shouldReturnSuccessfulCheckoutMessage() throws Exception {
        String actualMessage = checkedOutMovie.getAppropriateCheckoutMessage();

        assertEquals(actualMessage, Messages.SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE);
    }

    @Test
    public void shouldReturnUnsuccessfulReturnMessage() throws Exception {
        String actualMessage = checkedOutMovie.getAppropriateReturnMessage();

        assertEquals(actualMessage, Messages.UNSUCCESSFUL_MOVIE_RETURN_MESSAGE);
    }

    @Test
    public void shouldReturnItselfWhenAskedToCheckout() throws Exception {
        Movie actualResult = checkedOutMovie.returnMovie();

        assertEquals(checkedOutMovie, actualResult);
    }
}