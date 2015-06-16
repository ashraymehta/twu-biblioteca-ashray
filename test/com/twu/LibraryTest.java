package com.twu;

import com.twu.book.AvailableBook;
import com.twu.book.Book;
import com.twu.book.CheckedOutBook;
import com.twu.movie.Movie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {
    @Mock
    BookSearcher bookSearcher;

    private ArrayList<Book> availableBookArrayList;
    private ArrayList<Book> checkedOutBooks;
    private ArrayList<Book> allBooks;
    private AvailableBook availableBookOne;
    private AvailableBook availableBookTwo;
    private CheckedOutBook checkedOutOutBookOne;
    private Library library;
    private ArrayList<Movie> allMovies;

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
        allMovies = new ArrayList<>();
        allMovies = new ArrayList<>();
        allMovies.add(new Movie("Batman Begins", "Christopher Nolan", 2005, 9));
        allMovies.add(new Movie("The Dark Knight", "Christopher Nolan", 2008, 9));
        library = new Library(availableBookArrayList, allBooks, allMovies, bookSearcher);
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

        verify(bookSearcher).search(allBooks, title);
    }
}