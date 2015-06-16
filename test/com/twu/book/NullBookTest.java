package com.twu.book;

import com.twu.Messages;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

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
}