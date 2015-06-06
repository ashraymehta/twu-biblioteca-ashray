package com.thoughtworks.pathashala;

import com.thoughtworks.pathashala.helper.BookDataReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.print.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.ListResourceBundle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConsoleTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testPrintWelcomeMessage() throws Exception {
        Console console = new Console();
        console.printWelcomeMessage();

        String actualOutput = outputStream.toString();

        assertThat(actualOutput, is("Welcome" + System.lineSeparator()));
    }

    @Test
    public void testPrintListOfBooksUsingStubs() throws Exception {
        Library libraryStub = mock(Library.class);
        ArrayList<String> bookList = new ArrayList<>();
        bookList.add("First book");
        bookList.add("Second book");
        bookList.add("Third book");
        when(libraryStub.getAvailableBooks()).
                thenReturn(bookList);

        Console console = new Console();
        console.printListOfBooks(libraryStub.getAvailableBooks());

        String actualOutput = outputStream.toString();
        String expectedOutput = "First book" + System.lineSeparator() +
                "Second book" + System.lineSeparator() +
                "Third book" + System.lineSeparator();

        assertThat(actualOutput, is(expectedOutput));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}