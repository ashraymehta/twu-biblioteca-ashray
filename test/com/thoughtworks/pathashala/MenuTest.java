package com.thoughtworks.pathashala;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuTest {
    @Test
    public void shouldHaveProperStringRepresentation() throws Exception {
        BooksView booksView = mock(BooksView.class);
        Menu menu = new Menu(booksView);

        String actualString = menu.toString();
        String expectedString = "1. List books" + System.lineSeparator();

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldPrintListOfBooksOnOneInput() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BooksView booksView = mock(BooksView.class);
        Menu menu = new Menu(booksView);
        menu.performActionForInput(1);

        Mockito.verify(booksView).printListOfBooks();
    }
}