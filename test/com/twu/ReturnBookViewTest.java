package com.twu;

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
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookViewTest {
    @Mock
    Books books;

    private ByteArrayOutputStream outputStream;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
    }

    @Test
    public void shouldGetIntegerFromConsole() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("5".getBytes());
        Scanner scanner = new Scanner(byteArrayInputStream);
        ReturnBookView returnBookView = new ReturnBookView(books, scanner, printStream);

        int actualInput = returnBookView.getSelection();
        int expectedInput = 5;

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void shouldReturnMinusOneForInvalidInputConsole() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("hi!".getBytes());
        Scanner scanner = new Scanner(byteArrayInputStream);
        ReturnBookView returnBookView = new ReturnBookView(books, scanner, printStream);

        int actualInput = returnBookView.getSelection();
        int expectedInput = -1;

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void shouldDisplayListOfBooksWithSerialNumbers() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("5".getBytes());
        when(books.getBooksWithSerialsAsString()).thenReturn("1. Title Author Year");
        Scanner scanner = new Scanner(byteArrayInputStream);
        ReturnBookView returnBookView = new ReturnBookView(books, scanner, printStream);
        returnBookView.printListOfBooks();

        String actualOutput = outputStream.toString();
        String expectedOutput = "1. Title Author Year" + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }


}