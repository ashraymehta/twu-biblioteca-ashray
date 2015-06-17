package com.twu.views;

import com.twu.Books;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BooksViewTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream console;

    @Before
    public void setUp() throws Exception {
        console = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldPrintListOfBooks() throws Exception {
        Books booksStub = mock(Books.class);
        when(booksStub.toString()).thenReturn("First books   Author 1   1000" + System.lineSeparator()
                + "Second books   Author 2   1500");
        BooksView booksView = new BooksView(booksStub, new PrintStream(outputStream));
        booksView.printListOfBooks();

        String actualOutput = outputStream.toString();
        String expectedOutput = "First books   Author 1   1000" + System.lineSeparator()
                + "Second books   Author 2   1500" + System.lineSeparator();

        assertEquals(actualOutput, expectedOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }
}
