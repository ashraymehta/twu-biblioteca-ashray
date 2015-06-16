package com.twu.book;

import com.twu.Messages;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckedOutBookTest {
    @Test
    public void shouldPresentDetailsOfBookAsString() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        CheckedOutBook book = new CheckedOutBook(title, author, yearPublished, 1);

        String actualString = book.toString();
        String expectedString = "1    Harry Potter and the Philosopher's Stone          " +
                "JK Rowling                    " + "1997      ";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldNotAddItselfToAvailableList() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        AvailableBook book = new AvailableBook(title, author, yearPublished, 1);
        List<Book> availableList = new ArrayList<>();
        book.addToListIfAvailable(availableList);

        assertTrue(availableList.contains(book));
    }

    @Test
    public void shouldReturnSuccessfulCheckoutMessage() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        CheckedOutBook book = new CheckedOutBook(title, author, yearPublished, 1);
        String actualMessage = book.getAppropriateCheckoutMessage();

        assertEquals(actualMessage, Messages.SUCCESSFUL_CHECKOUT_MESSAGE);
    }
}