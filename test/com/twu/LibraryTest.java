package com.twu;

import com.twu.book.AvailableBook;
import com.twu.book.Book;
import com.twu.book.CheckedOutBook;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    private ArrayList<Book> availableBookArrayList;
    private ArrayList<Book> checkedOutBooks;
    private AvailableBook availableBookOne;
    private AvailableBook availableBookTwo;
    private CheckedOutBook checkoutOutBookOne;
    private Library library;

    @Before
    public void setUp() throws Exception {
        availableBookArrayList = new ArrayList<>();
        availableBookOne = new AvailableBook("Title 1", "Author 1", 1000, 1);
        availableBookArrayList.add(availableBookOne);
        availableBookTwo = new AvailableBook("Title 2", "Author 2", 1500, 2);
        availableBookArrayList.add(availableBookTwo);
        checkedOutBooks = new ArrayList<>();
        checkoutOutBookOne = new CheckedOutBook("Title 3", "Author 3", 2000, 3);
        checkedOutBooks.add(checkoutOutBookOne);
        ArrayList<Book> allBooks = new ArrayList<>();
        allBooks.addAll(availableBookArrayList);
        allBooks.addAll(checkedOutBooks);
        library = new Library(availableBookArrayList, checkedOutBooks, allBooks);
    }

    @Test
    public void shouldCheckoutBook() throws Exception {
        library.checkoutBook(0);

        assertFalse(availableBookArrayList.contains(availableBookOne));
    }

    @Test
    public void shouldAddCheckoutBookToListOfCheckedOutBooks() throws Exception {
        library.checkoutBook(0);

        assertTrue(checkedOutBooks.contains(availableBookOne));
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

        assertTrue(availableBookArrayList.contains(checkoutOutBookOne));
    }

    @Test
    public void shouldReturnFalseWhenCheckedOutBookIsNotAvailableAtTheIndex() throws Exception {
        boolean actualResult = library.returnBook(-5);

        assertFalse(actualResult);
    }

    @Test
    public void shouldReturnAvailableBooks() throws Exception {
        List<Book> actualResult = library.getAvailableBooks();
        List<AvailableBook> availableBooks = new ArrayList<>();
        availableBooks.add(availableBookOne);
        availableBooks.add(availableBookTwo);

        assertTrue(actualResult.equals(availableBooks));
    }
}