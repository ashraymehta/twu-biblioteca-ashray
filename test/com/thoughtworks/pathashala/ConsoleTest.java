package com.thoughtworks.pathashala;

import com.thoughtworks.pathashala.helper.BookDataReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.print.Book;
import java.io.*;
import java.util.ArrayList;

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
    public void testPrintListOfBooks() throws Exception {
        String projectRoot = System.getProperty("user.dir");
        String filePath = projectRoot + File.separator + "BookList.txt";
        BookDataReader bookDataReader = new BookDataReader(filePath);
        Library library = new Library();
        library.initialize(bookDataReader.getListOfBooks());
        Console console = new Console();
        console.printListOfBooks(library.getAvailableBooks());

        String actualOutput = outputStream.toString();
        String expectedOutput = "Introduction to Programming" + System.lineSeparator() +
                "The Pragmatic Programmer" + System.lineSeparator() +
                "Harry Potter and the Philosopher's Stone" + System.lineSeparator();

        assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void testPrintListOfBooksUsingStubs() throws Exception {
        BookDataReader bookDataReaderStub = mock(BookDataReader.class);
        ArrayList<String> bookList = new ArrayList<>();
        bookList.add("First book");
        bookList.add("Second book");
        bookList.add("Third book");
        when(bookDataReaderStub.getListOfBooks()).
                thenReturn(bookList);
        Library library = new Library();
        library.initialize(bookDataReaderStub.getListOfBooks());
        Console console = new Console();
        console.printListOfBooks(library.getAvailableBooks());

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