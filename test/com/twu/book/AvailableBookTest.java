package com.twu.book;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        CheckedOutBook book = new CheckedOutBook(title, author, yearPublished, 1);
        List<Book> availableList = new ArrayList<>();
        book.addToListIfAvailable(availableList);

        assertFalse(availableList.contains(book));
    }
}