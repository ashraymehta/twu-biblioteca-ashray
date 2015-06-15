package com.twu.book;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

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
}