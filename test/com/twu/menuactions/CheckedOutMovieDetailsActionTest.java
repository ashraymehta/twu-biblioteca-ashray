package com.twu.menuactions;

import com.twu.Library;
import com.twu.user.Librarian;
import com.twu.views.MoviesView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckedOutMovieDetailsActionTest {
    @Mock
    MoviesView moviesView;
    @Mock
    Library library;
    @Mock
    Librarian librarian;

    private CheckedOutMovieDetailsAction checkedOutMovieDetailsAction;

    @Before
    public void setUp() throws Exception {
        checkedOutMovieDetailsAction = new CheckedOutMovieDetailsAction(moviesView, library);
    }

    @Test
    public void shouldGetCheckedOutMoviesFromLibrary() throws Exception {
        checkedOutMovieDetailsAction.perform(librarian);

        verify(library).getCheckedOutMovies();
    }

    @Test
    public void shouldBeAbleToDisplayMovies() throws Exception {
        checkedOutMovieDetailsAction.perform(librarian);

        verify(moviesView).printListOfMovies();
    }
}