package com.twu.menuaction;

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

    @Test
    public void shouldBeAbleToDisplayList() throws Exception {
        ListMoviesAction listMoviesAction = new ListMoviesAction(moviesView);
        listMoviesAction.perform();

        verify(moviesView).printListOfMovies();
    }
}