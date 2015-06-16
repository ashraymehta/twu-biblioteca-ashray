package com.twu.view;

import com.twu.Movies;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutMovieViewTest {
    @Mock
    Movies movies;

    private CheckoutMovieView checkoutMovieView;

    @Before
    public void setUp() throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Title 1".getBytes());
        Scanner scanner = new Scanner(byteArrayInputStream);
        checkoutMovieView = new CheckoutMovieView(movies, scanner, printStream);
    }

    @Test
    public void shouldGetMovieNameFromConsole() throws Exception {
        String actualInput = checkoutMovieView.getMovieName();
        String expectedInput = "Title 1";

        assertEquals(expectedInput, actualInput);
    }
}