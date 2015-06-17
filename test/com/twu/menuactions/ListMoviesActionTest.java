package com.twu.menuactions;

import com.twu.Library;
import com.twu.user.Customer;
import com.twu.views.MoviesView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListMoviesActionTest {
    @Mock
    MoviesView moviesView;
    @Mock
    Library library;
    @Mock
    Customer customer;

    @Test
    public void shouldBeAbleToDisplayList() throws Exception {
        ListMoviesAction listMoviesAction = new ListMoviesAction(moviesView, library);
        listMoviesAction.perform(customer);

        verify(moviesView).printListOfMovies();
    }

    @Test
    public void shouldGetListOfMoviesFromLibrary() throws Exception {
        ListMoviesAction listMoviesAction = new ListMoviesAction(moviesView, library);
        listMoviesAction.perform(customer);

        verify(library).getAvailableMovies();
    }
}