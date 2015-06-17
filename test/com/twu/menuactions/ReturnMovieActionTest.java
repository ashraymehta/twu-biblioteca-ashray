package com.twu.menuactions;

import com.twu.Library;
import com.twu.movies.AvailableMovie;
import com.twu.movies.CheckedOutMovie;
import com.twu.user.AbstractUser;
import com.twu.views.ReturnMovieView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReturnMovieActionTest {
    @Mock
    AvailableMovie availableMovie;
    @Mock
    CheckedOutMovie checkedOutMovie;
    @Mock
    ReturnMovieView returnMovieView;
    @Mock
    AbstractUser abstractUser;

    private Library library;
    private ReturnMovieAction returnMovieAction;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        when(library.searchMovie("Title")).thenReturn(checkedOutMovie);
        when(library.returnMovie(checkedOutMovie)).thenReturn(availableMovie);
        when(availableMovie.getAppropriateReturnMessage()).thenReturn("Success!");
        when(returnMovieView.getMovieName()).thenReturn("Title");
        returnMovieAction = new ReturnMovieAction(returnMovieView, library);
    }

    @Test
    public void shouldTakeInput() throws Exception {
        returnMovieAction.perform(abstractUser);

        Mockito.verify(returnMovieView).getMovieName();
    }

    @Test
    public void shouldGetMovieAfterGettingSelection() throws Exception {
        returnMovieAction.perform(abstractUser);

        Mockito.verify(library).returnMovie(checkedOutMovie);
    }

    @Test
    public void shouldGetAppropriateMessageFromMovie() throws Exception {
        returnMovieAction.perform(abstractUser);

        verify(availableMovie).getAppropriateReturnMessage();
    }

    @Test
    public void shouldPrintMessageAfterCheckout() throws Exception {
        returnMovieAction.perform(abstractUser);

        verify(returnMovieView).printMessage("Success!");
    }
}