package com.twu.views;

import com.twu.Movies;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class MoviesViewTest {
    @Mock
    Movies movies;
    @Mock
    PrintStream printStream;

    private MoviesView moviesView;

    @Before
    public void setUp() throws Exception {
        moviesView = new MoviesView(movies, printStream);
    }

    @Test
    public void shouldPrintListOfMovies() throws Exception {
        moviesView.printListOfMovies();

        Mockito.verify(printStream).println(movies);
    }
}