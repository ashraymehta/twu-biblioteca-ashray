package com.thoughtworks.pathashala;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class BooksTest {

    @Test
    public void testDetailsOfAllBooksAreBeingPresentedByToString() throws Exception {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        bookArrayList.add(new Book("Title 1", "Author 1", 1000));
        bookArrayList.add(new Book("Title 2", "Author 2", 1500));
        bookArrayList.add(new Book("Title 3", "Author 3", 2000));
        Books books = new Books(bookArrayList);

        String actualString = books.toString();
        String expectedString = "Title 1 Author 1 1000" + System.lineSeparator() +
                "Title 2 Author 2 1500" + System.lineSeparator() +
                "Title 3 Author 3 2000" + System.lineSeparator();

        assertEquals(expectedString, actualString);
    }
}
