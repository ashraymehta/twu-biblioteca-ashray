package com.twu.views;

import com.twu.books.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckedOutBookDetailsViewTest {
    @Mock
    PrintStream printStream;
    @Mock
    Book book;

    private CheckedOutBookDetailsView checkedOutBookDetailsView;

    @Before
    public void setUp() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Title".getBytes());
        Scanner scanner = new Scanner(byteArrayInputStream);
        checkedOutBookDetailsView = new CheckedOutBookDetailsView(scanner, printStream);
    }

    @Test
    public void shouldBeAbleToTakeUserInput() throws Exception {
        String actualInput = checkedOutBookDetailsView.getUserInput();
        String expectedInput = "Title";

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void shouldBeAbleToPrintBookDetails() throws Exception {
        checkedOutBookDetailsView.printBookDetails(book);

        verify(printStream).println(book);
    }

    @Test
    public void shouldBeAbleToPrintAProvidedMessage() throws Exception {
        String message = "Message";
        checkedOutBookDetailsView.printMessage(message);

        verify(printStream).println(message);
    }
}