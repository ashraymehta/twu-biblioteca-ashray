package com.twu.movies;

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
        customer = new Customer("123-4567", "Password");
        checkedOutMovie = new CheckedOutMovie("Batman Begins", "Christopher Nolan", 2005, 9, customer);
    }

    @Test
    public void shouldPresentMovieDetailsAsString() throws Exception {
        String actualString = checkedOutMovie.toString();
        String expectedString = "Batman Begins                                     " +
                "Christopher Nolan             " + "2005      " + "9    " + "123-4567  ";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldAddItselfToCheckedOutList() throws Exception {
        checkedOutMovie.addToListIfCheckedOut(checkedOutMovies);

        assertTrue(checkedOutMovies.contains(checkedOutMovie));
    }
}