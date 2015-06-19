package com.twu.books;

import com.twu.Messages;
import com.twu.user.Customer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class AvailableBookTest {
    private String title;
    private String author;
    private int yearPublished;
    private AvailableBook book;

    @Before
    public void setUp() throws Exception {
        title = "Harry Potter and the Philosopher's Stone";
        author = "JK Rowling";
        yearPublished = 1997;
        book = new AvailableBook(title, author, yearPublished);
    }

    @Test
    public void shouldPresentDetailsOfBookAsString() throws Exception {
        String actualString = book.toString();
        String expectedString = "Harry Potter and the Philosopher's Stone          " +
                "JK Rowling                    " + "1997      ";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldAddItselfToAvailableList() throws Exception {
        List<Book> availableList = new ArrayList<>();
        book.addToListIfAvailable(availableList);

        assertTrue(availableList.contains(book));
    }

    @Test
    public void shouldNotAddItselfToCheckedOutList() throws Exception {
        List<Book> checkedOutList = new ArrayList<>();
        book.addToListIfCheckedOut(checkedOutList);

        assertFalse(checkedOutList.contains(book));
    }

    @Test
    public void shouldBeAbleToCheckItselfOut() throws Exception {
        Book newBook = book.checkoutBook(mock(Customer.class));

        assertTrue(newBook instanceof CheckedOutBook);
    }

    @Test
    public void shouldAddItselfIfTitleMatchesGivenString() throws Exception {
        List<Book> matchingList = new ArrayList<>();
        book.addToListIfTitleMatches(matchingList, "Harry Potter and the Philosopher's Stone");

        assertTrue(matchingList.contains(book));
    }

    @Test
    public void shouldReturnFailedCheckoutMessage() throws Exception {
        String actualMessage = book.getAppropriateCheckoutMessage();

        assertEquals(actualMessage, Messages.UNSUCCESSFUL_BOOK_CHECKOUT_MESSAGE);
    }

    @Test
    public void shouldReturnItselfWhenAskedToReturnToLibrary() throws Exception {
        Book actualReturnedBook = book.returnBook();

        assertEquals(book, actualReturnedBook);
    }

    @Test
    public void shouldGetSuccessfulReturnMessage() throws Exception {
        String actualMessage = book.getAppropriateReturnMessage();

        assertEquals(Messages.SUCCESSFUL_BOOK_RETURN_MESSAGE, actualMessage);
    }
}