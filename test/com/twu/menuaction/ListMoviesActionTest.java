package com.twu.menuaction;

import com.twu.Library;
import com.twu.view.MoviesView;
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

    @Test
    public void shouldBeAbleToDisplayList() throws Exception {
        ListMoviesAction listMoviesAction = new ListMoviesAction(moviesView, library);
        listMoviesAction.perform();

        verify(moviesView).printListOfMovies();
    }

    @Test
    public void shouldGetListOfMoviesFromLibrary() throws Exception {
        ListMoviesAction listMoviesAction = new ListMoviesAction(moviesView, library);
        listMoviesAction.perform();

        verify(library).getAvailableMovies();
    }
}