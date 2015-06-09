package com.thoughtworks.pathashala;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
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
        BooksView booksViewStub = mock(BooksView.class);
        Menu menu = new Menu(booksViewStub);
        menu.performActionForInput(1);

        Mockito.verify(booksViewStub).printListOfBooks();
    }

    @Test
    public void shouldVerifyThatMenuOptionExistsOnValidInput() throws Exception {
        BooksView booksViewStub = mock(BooksView.class);
        Menu menu = new Menu(booksViewStub);

        boolean actualAction = menu.hasActionAtPosition(1);

        assertTrue(actualAction);
    }

    @Test
    public void shouldVerifyThatMenuOptionExistsOnInvalidInput() throws Exception {
        BooksView booksViewStub = mock(BooksView.class);
        Menu menu = new Menu(booksViewStub);

        boolean actualAction = menu.hasActionAtPosition(-1);

        assertFalse(actualAction);
    }
}