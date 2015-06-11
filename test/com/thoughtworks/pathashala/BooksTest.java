package com.thoughtworks.pathashala;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class BooksTest {

    @Test
    public void shouldPresentDetailsOfAllBooksAsString() throws Exception {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        bookArrayList.add(new Book("Title 1", "Author 1", 1000));
        bookArrayList.add(new Book("Title 2", "Author 2", 1500));
        Books books = new Books(bookArrayList);

        String actualString = books.toString();
        String expectedString = "Title 1                                           " +
                "Author 1                      " + "1000      " + System.lineSeparator() +
                "Title 2                                           " +
                "Author 2                      " + "1500      " + System.lineSeparator();

        assertEquals(expectedString, actualString);
    }
}