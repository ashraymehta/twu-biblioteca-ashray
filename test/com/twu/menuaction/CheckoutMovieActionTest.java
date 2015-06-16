package com.twu.menuaction;

import com.twu.Library;
import com.twu.movie.AvailableMovie;
import com.twu.movie.CheckedOutMovie;
import com.twu.view.CheckoutMovieView;
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
    private CheckoutMovieAction checkoutBookAction;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        when(library.searchMovie("Title")).thenReturn(availableMovie);
        when(library.checkoutMovie(availableMovie)).thenReturn(checkedOutMovie);
        when(checkedOutMovie.getAppropriateCheckoutMessage()).thenReturn("Success!");
        when(checkoutMovieView.getMovieName()).thenReturn("Title");
        checkoutBookAction = new CheckoutMovieAction(checkoutMovieView, library);
    }

    @Test
    public void shouldTakeInput() throws Exception {
        checkoutBookAction.perform();

        verify(checkoutMovieView).getMovieName();
    }

}