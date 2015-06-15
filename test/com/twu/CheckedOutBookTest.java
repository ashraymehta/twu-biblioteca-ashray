package com.twu;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

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
}