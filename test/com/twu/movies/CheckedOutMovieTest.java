package com.twu.movies;

import com.twu.user.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CheckedOutMovieTest {
    @Mock
    Customer customer;

    private CheckedOutMovie checkedOutMovie;
    private List<Movie> checkedOutMovies;

    @Before
    public void setUp() throws Exception {
        checkedOutMovies = new ArrayList<>();
        checkedOutMovie = new CheckedOutMovie("Name", "Director", 1000, 10, customer);
    }

    @Test
    public void shouldAddItselfToCheckedOutList() throws Exception {
        checkedOutMovie.addToListIfCheckedOut(checkedOutMovies);

        assertTrue(checkedOutMovies.contains(checkedOutMovie));
    }
}