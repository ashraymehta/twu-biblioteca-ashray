package com.twu;

import com.twu.book.AvailableBook;
import com.twu.book.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    private ArrayList<Book> bookArrayList;
    private ArrayList<Book> checkedOutBooks;
    private Book bookOne;
    private Book bookTwo;
    private Book checkoutOutBookOne;
    private Library library;

    @Before
    public void setUp() throws Exception {
        bookArrayList = new ArrayList<>();
        bookOne = new AvailableBook("Title 1", "Author 1", 1000, 1);
        bookArrayList.add(bookOne);
        bookTwo = new AvailableBook("Title 2", "Author 2", 1500, 2);
        bookArrayList.add(bookTwo);
        checkedOutBooks = new ArrayList<>();
        checkoutOutBookOne = new AvailableBook("Title 3", "Author 3", 2000, 3);
        checkedOutBooks.add(checkoutOutBookOne);
        library = new Library(bookArrayList, checkedOutBooks);
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

    @Test
    public void shouldReturnFalseWhenBookIsNotAvailableAtTheIndex() throws Exception {
        boolean actualResult = library.checkoutBook(-5);

        assertFalse(actualResult);
    }

    @Test
    public void shouldBeAbleToTakeBackBook() throws Exception {
        library.returnBook(0);

        assertFalse(checkedOutBooks.contains(checkoutOutBookOne));
    }

    @Test
    public void shouldAddReturnedBookToListOfAvailableBooks() throws Exception {
        library.returnBook(0);

        assertTrue(bookArrayList.contains(checkoutOutBookOne));
    }

    @Test
    public void shouldReturnFalseWhenCheckedOutBookIsNotAvailableAtTheIndex() throws Exception {
        boolean actualResult = library.returnBook(-5);

        assertFalse(actualResult);
    }
}