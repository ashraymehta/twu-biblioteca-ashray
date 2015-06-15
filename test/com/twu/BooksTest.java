package com.twu;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class BooksTest {

    @Test
    public void shouldPresentDetailsOfAllBooksAsString() throws Exception {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        bookArrayList.add(new Book("Title 1", "Author 1", 1000, 1));
        bookArrayList.add(new Book("Title 2", "Author 2", 1500, 2));
        Books books = new Books(bookArrayList);

        String actualString = books.toString();
        String expectedString = "1    Title 1                                           " +
                "Author 1                      " + "1000      " + System.lineSeparator() +
                "2    Title 2                                           " +
                "Author 2                      " + "1500      " + System.lineSeparator();

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldPresentDetailsOfBooksWithSerialsAsString() throws Exception {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        bookArrayList.add(new Book("Title 1", "Author 1", 1000, 1));
        bookArrayList.add(new Book("Title 2", "Author 2", 1500, 2));
        Books books = new Books(bookArrayList);

        String actualString = books.getBooksWithSerialsAsString();
        String expectedString = "1. 1    Title 1                                           " +
                "Author 1                      " + "1000      " + System.lineSeparator() +
                "2. 2    Title 2                                           " +
                "Author 2                      " + "1500      " + System.lineSeparator();

        assertEquals(expectedString, actualString);
    }
}