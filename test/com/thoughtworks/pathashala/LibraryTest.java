package com.thoughtworks.pathashala;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    private ArrayList<Book> bookArrayList;
    private Book bookOne;
    private Library library;

    @Before
    public void setUp() throws Exception {
        bookArrayList = new ArrayList<>();
        bookOne = new Book("Title 1", "Author 1", 1000);
        bookArrayList.add(bookOne);
        bookArrayList.add(new Book("Title 2", "Author 2", 1500));
        library = new Library(bookArrayList, new ArrayList<Book>());
    }

    @Test
    public void shouldBeAbleToGetListOfAvailableBooksAsString() throws Exception {
        String actualString = library.getListOfAvailableBooksAsString();
        String expectedString = "Title 1                                           " +
                "Author 1                      " + "1000      " + System.lineSeparator() +
                "Title 2                                           " +
                "Author 2                      " + "1500      " + System.lineSeparator();

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldBeAbleToCheckoutBook() throws Exception {
        library.checkoutBook(0);

        assertFalse(bookArrayList.contains(bookOne));
    }
}