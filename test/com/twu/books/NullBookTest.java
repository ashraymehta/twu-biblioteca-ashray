package com.twu.books;

import com.twu.Messages;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class NullBookTest {

    private NullBook nullBook;

    @Before
    public void setUp() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        nullBook = new NullBook();
    }

    @Test
    public void shouldReturnSuccessfulCheckoutMessage() throws Exception {
        String actualMessage = nullBook.getAppropriateCheckoutMessage();

        assertEquals(actualMessage, Messages.UNSUCCESSFUL_BOOK_CHECKOUT_MESSAGE);
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
}