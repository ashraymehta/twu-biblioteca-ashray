package com.twu.books;

import com.twu.Messages;
import com.twu.user.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CheckedOutBookTest {

    private Customer checkedOutTo;

    @Before
    public void setUp() throws Exception {
        checkedOutTo = new Customer("123-4567", "Password", "Name", "Email", "98901234");
    }

    @Test
    public void shouldPresentDetailsOfBookAsString() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        CheckedOutBook book = new CheckedOutBook(title, author, yearPublished, checkedOutTo);

        String actualString = book.toString();
        String expectedString = "Harry Potter and the Philosopher's Stone          " +
                "JK Rowling                    1997      123-4567            " +
                "Name                          Email                         98901234       ";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldNotAddItselfToAvailableList() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        CheckedOutBook book = new CheckedOutBook(title, author, yearPublished, checkedOutTo);
        List<Book> availableList = new ArrayList<>();
        book.addToListIfAvailable(availableList);

        assertFalse(availableList.contains(book));
    }

    @Test
    public void shouldAddItselfToCheckedOutList() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        CheckedOutBook book = new CheckedOutBook(title, author, yearPublished, checkedOutTo);
        List<Book> checkedOutList = new ArrayList<>();
        book.addToListIfCheckedOut(checkedOutList);

        assertTrue(checkedOutList.contains(book));
    }

    @Test
    public void shouldReturnSuccessfulCheckoutMessage() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        CheckedOutBook book = new CheckedOutBook(title, author, yearPublished, checkedOutTo);
        String actualMessage = book.getAppropriateCheckoutMessage();

        assertEquals(actualMessage, Messages.SUCCESSFUL_BOOK_CHECKOUT_MESSAGE);
    }

    @Test
    public void shouldBeAbleToReturnItselfToTheLibrary() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        CheckedOutBook book = new CheckedOutBook(title, author, yearPublished, checkedOutTo);
        Book newBook = book.returnBook();

        assertTrue(newBook instanceof AvailableBook);
    }

    @Test
    public void shouldReturnItselfWhenCheckingOut() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        CheckedOutBook book = new CheckedOutBook(title, author, yearPublished, checkedOutTo);
        Book actualBook = book.checkoutBook(checkedOutTo);

        assertEquals(book, actualBook);
    }

    @Test
    public void shouldReturnUnsuccessfulBookReturnMessage() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        CheckedOutBook book = new CheckedOutBook(title, author, yearPublished, checkedOutTo);
        String actualMessage = book.getAppropriateReturnMessage();

        assertEquals(Messages.UNSUCCESSFUL_BOOK_RETURN_MESSAGE, actualMessage);
    }
}