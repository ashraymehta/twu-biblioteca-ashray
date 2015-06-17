package com.twu.books;

import com.twu.Messages;
import com.twu.user.Customer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class AvailableBookTest {
    @Test
    public void shouldPresentDetailsOfBookAsString() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        AvailableBook book = new AvailableBook(title, author, yearPublished);

        String actualString = book.toString();
        String expectedString = "Harry Potter and the Philosopher's Stone          " +
                "JK Rowling                    " + "1997      ";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldAddItselfToAvailableList() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        AvailableBook book = new AvailableBook(title, author, yearPublished);
        List<Book> availableList = new ArrayList<>();
        book.addToListIfAvailable(availableList);

        assertTrue(availableList.contains(book));
    }

    @Test
    public void shouldNotAddItselfToCheckedOutList() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        AvailableBook book = new AvailableBook(title, author, yearPublished);
        List<Book> checkedOutList = new ArrayList<>();
        book.addToListIfCheckedOut(checkedOutList);

        assertFalse(checkedOutList.contains(book));
    }

    @Test
    public void shouldBeAbleToCheckItselfOut() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        AvailableBook book = new AvailableBook(title, author, yearPublished);
        Book newBook = book.checkoutBook(mock(Customer.class));

        assertTrue(newBook instanceof CheckedOutBook);
    }

    @Test
    public void shouldAddItselfIfTitleMatchesGivenString() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        AvailableBook book = new AvailableBook(title, author, yearPublished);
        List<Book> matchingList = new ArrayList<>();
        book.addToListIfTitleMatches(matchingList, "Harry Potter and the Philosopher's Stone");

        assertTrue(matchingList.contains(book));
    }

    @Test
    public void shouldReturnFailedCheckoutMessage() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        AvailableBook book = new AvailableBook(title, author, yearPublished);
        String actualMessage = book.getAppropriateCheckoutMessage();

        assertEquals(actualMessage, Messages.UNSUCCESSFUL_BOOK_CHECKOUT_MESSAGE);
    }
}