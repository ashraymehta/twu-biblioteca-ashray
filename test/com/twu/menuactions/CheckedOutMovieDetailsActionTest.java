package com.twu.menuactions;

import com.twu.Library;
import com.twu.movies.Movie;
import com.twu.user.AbstractUser;
import com.twu.user.Librarian;
import com.twu.views.CheckedOutMovieDetailsView;
import com.twu.views.MoviesView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckedOutMovieDetailsActionTest {
    @Mock
    MoviesView moviesView;
    @Mock
    Library library;
    @Mock
    Librarian librarian;
    @Mock
    AbstractUser user;
    @Mock
    Movie movie;
    @Mock
    CheckedOutMovieDetailsView checkedOutMovieDetailsView;

    private CheckedOutMovieDetailsAction checkedOutMovieDetailsAction;

    @Before
    public void setUp() throws Exception {
        checkedOutMovieDetailsAction = new CheckedOutMovieDetailsAction(checkedOutMovieDetailsView, library);
        when(checkedOutMovieDetailsView.getUserInput()).thenReturn("Title");
        when(library.searchCheckedOutMovie("Title")).thenReturn(movie);
    }

    @Test
    public void shouldGetBookTitleFromUser() throws Exception {
        checkedOutMovieDetailsAction.perform(user);

        verify(checkedOutMovieDetailsView).getUserInput();
    }

    @Test
    public void shouldSearchForCheckedOutMovie() {
        checkedOutMovieDetailsAction.perform(user);

        verify(library).searchCheckedOutMovie("Title");
    }

    @Test
    public void shouldPrintMovieDetails() {
        checkedOutMovieDetailsAction.perform(user);

        verify(checkedOutMovieDetailsView).printMovieDetails(movie);
    }
}