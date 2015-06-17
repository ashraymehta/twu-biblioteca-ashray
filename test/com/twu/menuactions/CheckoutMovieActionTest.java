package com.twu.menuactions;

import com.twu.Library;
import com.twu.movies.AvailableMovie;
import com.twu.movies.CheckedOutMovie;
import com.twu.views.CheckoutMovieView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutMovieActionTest {
    @Mock
    CheckoutMovieView checkoutMovieView;
    @Mock
    AvailableMovie availableMovie;
    @Mock
    CheckedOutMovie checkedOutMovie;

    private Library library;
    private CheckoutMovieAction checkoutMovieAction;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        when(library.searchMovie("Title")).thenReturn(availableMovie);
        when(library.checkoutMovie(availableMovie)).thenReturn(checkedOutMovie);
        when(checkedOutMovie.getAppropriateCheckoutMessage()).thenReturn("Success!");
        when(checkoutMovieView.getMovieName()).thenReturn("Title");
        checkoutMovieAction = new CheckoutMovieAction(checkoutMovieView, library);
    }

    @Test
    public void shouldTakeInput() throws Exception {
        checkoutMovieAction.perform();

        verify(checkoutMovieView).getMovieName();
    }

    @Test
    public void shouldSearchForMovieInTheLibrary() throws Exception {
        checkoutMovieAction.perform();

        verify(library).searchMovie("Title");
    }

    @Test
    public void shouldCheckoutMovieFromLibrary() throws Exception {
        checkoutMovieAction.perform();

        verify(library).checkoutMovie(availableMovie);
    }

    @Test
    public void shouldDisplayAppropriateMessage() throws Exception {
        checkoutMovieAction.perform();

        verify(checkoutMovieView).printMessage("Success!");
    }
}