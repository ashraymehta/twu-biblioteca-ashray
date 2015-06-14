package com.twu;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    private ArrayList<Book> bookArrayList;
    private ArrayList<Book> checkedOutBooks;
    private Book bookOne;
    private Library library;

    @Before
    public void setUp() throws Exception {
        bookArrayList = new ArrayList<>();
        bookOne = new Book("Title 1", "Author 1", 1000);
        bookArrayList.add(bookOne);
        bookArrayList.add(new Book("Title 2", "Author 2", 1500));
        checkedOutBooks = new ArrayList<>();
        library = new Library(bookArrayList, checkedOutBooks);
    }

    @Test
    public void shouldGetListOfAvailableBooksAsString() throws Exception {
        String actualString = library.getListOfAvailableBooksAsString();
        String expectedString = "Title 1                                           " +
                "Author 1                      " + "1000      " + System.lineSeparator() +
                "Title 2                                           " +
                "Author 2                      " + "1500      " + System.lineSeparator();

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldCheckoutBook() throws Exception {
        library.checkoutBook(0);

        assertFalse(bookArrayList.contains(bookOne));
    }

    @Test
    public void shouldAddCheckoutBookToListOfCheckedOutBooks() throws Exception {
        library.checkoutBook(0);

        assertTrue(checkedOutBooks.contains(bookOne));
    }

    @Test
    public void shouldTellWhenBookWasNotSuccessfullyCheckedOut() throws Exception {
        boolean actualResult = library.checkoutBook(5);

        assertFalse(actualResult);
    }
}