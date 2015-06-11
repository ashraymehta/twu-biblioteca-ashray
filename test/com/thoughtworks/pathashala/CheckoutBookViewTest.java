package com.thoughtworks.pathashala;

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
public class CheckoutBookViewTest {

    private ByteArrayOutputStream outputStream;

    @Mock
    Books books;

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
        CheckoutBookView checkoutBookView = new CheckoutBookView(books, scanner, printStream);

        int actualInput = checkoutBookView.getSelection();
        int expectedInput = 5;

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void shouldDisplayListOfBooksWithSerialNumbers() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("5".getBytes());
        when(books.getBooksWithSerialsAsString()).thenReturn("1. Title Author Year");
        Scanner scanner = new Scanner(byteArrayInputStream);
        CheckoutBookView checkoutBookView = new CheckoutBookView(books, scanner, printStream);
        checkoutBookView.printListOfBooks();

        String actualOutput = outputStream.toString();
        String expectedOutput = "1. Title Author Year" + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldDisplaySuccessfulMessage() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("5".getBytes());
        Scanner scanner = new Scanner(byteArrayInputStream);
        CheckoutBookView checkoutBookView = new CheckoutBookView(books, scanner, printStream);
        checkoutBookView.printSuccessfulCheckoutMessage();

        String actualOutput = outputStream.toString();
        String expectedOutput = "Thank you! Enjoy the book" + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldDisplayUnsuccessfulMessage() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("5".getBytes());
        Scanner scanner = new Scanner(byteArrayInputStream);
        CheckoutBookView checkoutBookView = new CheckoutBookView(books, scanner, printStream);
        checkoutBookView.printUnsuccessfulCheckoutMessage();

        String actualOutput = outputStream.toString();
        String expectedOutput = "That book is not available." + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }
}