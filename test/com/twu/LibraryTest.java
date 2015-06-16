package com.twu;

import com.twu.book.AvailableBook;
import com.twu.book.Book;
import com.twu.book.CheckedOutBook;
import com.twu.movie.AvailableMovie;
import com.twu.movie.CheckedOutMovie;
import com.twu.movie.Movie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {
    @Mock
    BookSearcher bookSearcher;

    private Set<Movie> allMovies;
    private ArrayList<Book> allBooks;
    private Library library;
    private AvailableBook availableBookOne;
    private AvailableBook availableBookTwo;
    private CheckedOutBook checkedOutOutBookOne;

    private AvailableMovie availableMovieOne;
    private AvailableMovie availableMovieTwo;
    private CheckedOutMovie checkedOutOutMovieOne;


    @Before
    public void setUp() throws Exception {
        availableBookOne = new AvailableBook("Title 1", "Author 1", 1000);
        availableBookTwo = new AvailableBook("Title 2", "Author 2", 1500);
        checkedOutOutBookOne = new CheckedOutBook("Title 3", "Author 3", 2000);

        ArrayList<Book> availableBookArrayList = new ArrayList<>();
        ArrayList<Book> checkedOutBooks = new ArrayList<>();
        availableBookArrayList.add(availableBookOne);
        availableBookArrayList.add(availableBookTwo);
        checkedOutBooks.add(checkedOutOutBookOne);

        allBooks = new ArrayList<>();
        allMovies = new HashSet<>();

        availableMovieOne = new AvailableMovie("Batman Begins", "Christopher Nolan", 2005, 9);
        availableMovieTwo = new AvailableMovie("The Dark Knight", "Christopher Nolan", 2008, 9);
        checkedOutOutMovieOne = new CheckedOutMovie("The Dark Knight Rises", "Christopher Nolan", 2012, 9);

        allBooks.addAll(availableBookArrayList);
        allBooks.addAll(checkedOutBooks);
        allMovies.add(availableMovieOne);
        allMovies.add(availableMovieTwo);
        allMovies.add(checkedOutOutMovieOne);

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

    @Test
    public void shouldBeAbleToCheckoutAMovie() throws Exception {
        availableMovieOne = mock(AvailableMovie.class);
        library.checkoutMovie(availableMovieOne);

        verify(availableMovieOne).checkout();
    }
}