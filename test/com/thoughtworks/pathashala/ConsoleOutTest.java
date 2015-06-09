package com.thoughtworks.pathashala;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ConsoleOutTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldPrintWelcomeMessage() throws Exception {
        ConsoleOut consoleOut = new ConsoleOut();
        consoleOut.printWelcomeMessage();

        String actualOutput = outputStream.toString();

        assertThat(actualOutput, is("Welcome" + System.lineSeparator()));
    }

    @Test
    public void shouldPrintListOfBooks() throws Exception {
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("First book", "Author 1", 1000));
        bookList.add(new Book("Second book", "Author 2", 1500));
        bookList.add(new Book("Third book", "Author 3", 2000));
        Books books = new Books(bookList);
        ConsoleOut consoleOut = new ConsoleOut();
        consoleOut.printListOfBooks(books);

        String actualOutput = outputStream.toString();
        String expectedOutput = "First book                                        " +
                "Author 1                      1000      " + System.lineSeparator() +
                "Second book                                       " +
                "Author 2                      1500      " + System.lineSeparator() +
                "Third book                                        " +
                "Author 3                      2000      " + System.lineSeparator() + System.lineSeparator();

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldPrintMainMenu() throws Exception {
        ConsoleOut consoleOut = new ConsoleOut();
        consoleOut.printMainMenu();

        String actualOutput = outputStream.toString();
        String expectedOutput = "1. List books" + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}