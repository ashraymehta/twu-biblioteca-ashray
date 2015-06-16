package com.twu.menuaction;

import com.twu.Library;
import com.twu.movie.AvailableMovie;
import com.twu.movie.CheckedOutMovie;
import com.twu.view.ReturnMovieView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReturnMovieActionTest {
    @Mock
    AvailableMovie availableMovie;
    @Mock
    CheckedOutMovie checkedOutMovie;
    @Mock
    ReturnMovieView returnMovieView;

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
        returnMovieAction.perform();

        Mockito.verify(returnMovieView).getMovieName();
    }

    @Test
    public void shouldGetMovieAfterGettingSelection() throws Exception {
        returnMovieAction.perform();

        Mockito.verify(library).returnMovie(checkedOutMovie);
    }

}