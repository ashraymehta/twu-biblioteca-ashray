package com.twu.books;

import com.twu.Messages;
import com.twu.user.Customer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.mockito.Mockito.mock;

public class NullBookTest {

    private NullBook nullBook;

    @Before
    public void setUp() throws Exception {
        nullBook = new NullBook();
    }

    @Test
    public void shouldReturnUnsuccessfulCheckoutMessage() throws Exception {
        String actualMessage = nullBook.getAppropriateCheckoutMessage();

        assertEquals(actualMessage, Messages.UNSUCCESSFUL_BOOK_CHECKOUT_MESSAGE);
    }

    @Test
    public void shouldReturnUnsuccessfulReturnMessage() throws Exception {
        String actualMessage = nullBook.getAppropriateReturnMessage();

        assertEquals(actualMessage, Messages.UNSUCCESSFUL_BOOK_RETURN_MESSAGE);
    }

    @Test
    public void shouldNotAddItselfToCheckedOutList() throws Exception {
        NullBook book = new NullBook();
        List<Book> checkedOutList = new ArrayList<>();
        book.addToListIfCheckedOut(checkedOutList);

        assertFalse(checkedOutList.contains(book));
    }

    @Test
    public void shouldNotAddItselfToAvailableList() throws Exception {
        NullBook book = new NullBook();
        List<Book> availableList = new ArrayList<>();
        book.addToListIfAvailable(availableList);

        assertFalse(availableList.contains(book));
    }

    @Test
    public void shouldReturnItselfWhenCheckingOut() throws Exception {
        NullBook nullBook = new NullBook();
        Book actualBook = nullBook.checkoutBook(mock(Customer.class));

        assertEquals(nullBook, actualBook);
    }

    @Test
    public void shouldReturnItselfWhenReturningToLibrary() throws Exception {
        NullBook nullBook = new NullBook();
        Book actualBook = nullBook.returnBook();

        assertEquals(nullBook, actualBook);
    }

    @Test
    public void shouldHaveEmptyStringAsStringRepresentation() throws Exception {
        NullBook nullBook = new NullBook();
        String actualString = nullBook.toString();

        assertEquals("", actualString);
    }
}