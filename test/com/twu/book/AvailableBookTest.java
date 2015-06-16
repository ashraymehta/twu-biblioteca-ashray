package com.twu.book;

import com.twu.Messages;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AvailableBookTest {
    @Test
    public void shouldPresentDetailsOfBookAsString() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        AvailableBook book = new AvailableBook(title, author, yearPublished, 1);

        String actualString = book.toString();
        String expectedString = "1    Harry Potter and the Philosopher's Stone          " +
                "JK Rowling                    " + "1997      ";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldAddItselfToAvailableList() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        AvailableBook book = new AvailableBook(title, author, yearPublished, 1);
        List<Book> availableList = new ArrayList<>();
        book.addToListIfAvailable(availableList);

        assertTrue(availableList.contains(book));
    }

    @Test
    public void shouldBeAbleToCheckItselfOut() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        AvailableBook book = new AvailableBook(title, author, yearPublished, 1);
        List<Book> allBooks = new ArrayList<>();
        book.checkout(allBooks);
        Book newBook = allBooks.get(0);

        assertTrue(newBook instanceof CheckedOutBook);
    }

    @Test
    public void shouldAddItselfIfTitleMatchesGivenString() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        AvailableBook book = new AvailableBook(title, author, yearPublished, 1);
        List<Book> matchingList = new ArrayList<>();
        book.addToListIfTitleMatches(matchingList, "Harry Potter and the Philosopher's Stone");

        assertTrue(matchingList.contains(book));
    }

    @Test
    public void shouldReturnFailedCheckoutMessage() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        AvailableBook book = new AvailableBook(title, author, yearPublished, 1);
        String actualMessage = book.getAppropriateCheckoutMessage();

        assertEquals(actualMessage, Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE);
    }
}