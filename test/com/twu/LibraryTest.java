package com.twu;

import com.twu.book.AvailableBook;
import com.twu.book.Book;
import com.twu.book.CheckedOutBook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {
    @Mock
    Searcher searcher;

    private ArrayList<Book> availableBookArrayList;
    private ArrayList<Book> checkedOutBooks;
    private ArrayList<Book> allBooks;
    private AvailableBook availableBookOne;
    private AvailableBook availableBookTwo;
    private CheckedOutBook checkedOutOutBookOne;
    private Library library;

    @Before
    public void setUp() throws Exception {
        availableBookArrayList = new ArrayList<>();
        availableBookOne = new AvailableBook("Title 1", "Author 1", 1000);
        availableBookArrayList.add(availableBookOne);
        availableBookTwo = new AvailableBook("Title 2", "Author 2", 1500);
        availableBookArrayList.add(availableBookTwo);
        checkedOutBooks = new ArrayList<>();
        checkedOutOutBookOne = new CheckedOutBook("Title 3", "Author 3", 2000);
        checkedOutBooks.add(checkedOutOutBookOne);
        allBooks = new ArrayList<>();
        allBooks.addAll(availableBookArrayList);
        allBooks.addAll(checkedOutBooks);
        library = new Library(availableBookArrayList, checkedOutBooks, allBooks, searcher);
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

        assertFalse(checkedOutBooks.contains(checkedOutOutBookOne));
    }

    @Test
    public void shouldAddReturnedBookToListOfAvailableBooks() throws Exception {
        library.returnBook(0);

        assertTrue(availableBookArrayList.contains(checkedOutOutBookOne));
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

    @Test(expected = UnsupportedOperationException.class)
    public void shouldReturnUnmodifiableCollectionOfAvailableBooks() throws Exception {
        List<Book> actualResult = library.getAvailableBooks();
        actualResult.add(new AvailableBook("Title 4", "Author", 1000));
    }

    @Test
    public void shouldBeAbleToCheckoutBookWhenBookIsPassed() throws Exception {
        availableBookOne = mock(AvailableBook.class);
        library.checkoutBook(availableBookOne);

        verify(availableBookOne).checkoutBook(allBooks);
    }

    @Test
    public void shouldBeAbleToReturnBookWhenBookIsPassed() throws Exception {
        checkedOutOutBookOne = mock(CheckedOutBook.class);
        library.checkoutBook(checkedOutOutBookOne);

        verify(checkedOutOutBookOne).checkoutBook(allBooks);
    }

    @Test
    public void shouldBeAbleToSearchForABookByTitle() throws Exception {
        String title = "Title 1";
        library.searchBook(title);

        verify(searcher).search(allBooks, title);
    }
}