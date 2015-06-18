package com.twu.views;

import com.twu.Messages;
import com.twu.movies.Movie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckedOutMovieDetailsViewTest {
    @Mock
    PrintStream printStream;
    @Mock
    Movie movie;

    private CheckedOutMovieDetailsView checkedOutMovieDetailsView;

    @Before
    public void setUp() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Title".getBytes());
        Scanner scanner = new Scanner(byteArrayInputStream);
        checkedOutMovieDetailsView = new CheckedOutMovieDetailsView(scanner, printStream);
    }

    @Test
    public void shouldBeAbleToTakeUserInput() throws Exception {
        String actualInput = checkedOutMovieDetailsView.getUserInput();
        String expectedInput = "Title";

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void shouldBeAbleToPrintMovieDetails() throws Exception {
        checkedOutMovieDetailsView.printMovieDetails(movie);

        verify(printStream).println(movie);
    }

    @Test
    public void shouldBeAbleToPrintNoMovieFoundMessage() throws Exception {
        checkedOutMovieDetailsView.printNoMovieFoundMessage();

        verify(printStream).println(Messages.NO_MOVIE_FOUND);
    }
}