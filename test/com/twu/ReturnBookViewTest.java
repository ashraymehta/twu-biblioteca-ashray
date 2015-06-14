package com.twu;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;

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

}