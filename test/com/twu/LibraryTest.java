package com.twu;

import com.twu.books.AvailableBook;
import com.twu.books.Book;
import com.twu.books.CheckedOutBook;
import com.twu.books.NullBook;
import com.twu.movies.AvailableMovie;
import com.twu.movies.CheckedOutMovie;
import com.twu.movies.Movie;
import com.twu.movies.NullMovie;
import com.twu.user.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {
    @Mock
    BookSearcher bookSearcher;
    @Mock
    MovieSearcher movieSearcher;

    private Set<Movie> allMovies;
    private ArrayList<Book> allBooks;
    private Library library;
    private AvailableBook availableBookOne;
    private AvailableBook availableBookTwo;
    private CheckedOutBook checkedOutOutBookOne;

    private AvailableMovie availableMovieOne;
    private AvailableMovie availableMovieTwo;
    private CheckedOutMovie checkedOutOutMovieOne;
    private ArrayList<Book> availableBooks;
    private List<Movie> availableMovies;
    private Customer customer;
    private ArrayList<Book> checkedOutBooks;
    private ArrayList<Movie> checkedOutMovies;


    @Before
    public void setUp() throws Exception {
        availableBookOne = new AvailableBook("Title 1", "Author 1", 1000);
        availableBookTwo = new AvailableBook("Title 2", "Author 2", 1500);
        checkedOutOutBookOne = new CheckedOutBook("Title 3", "Author 3", 2000, customer);

        availableBooks = new ArrayList<>();
        checkedOutBooks = new ArrayList<>();
        availableBooks.add(availableBookOne);
        availableBooks.add(availableBookTwo);
        checkedOutBooks.add(checkedOutOutBookOne);

        allBooks = new ArrayList<>();
        allMovies = new HashSet<>();

        availableMovieOne = new AvailableMovie("Batman Begins", "Christopher Nolan", 2005, 9);
        availableMovieTwo = new AvailableMovie("The Dark Knight", "Christopher Nolan", 2008, 9);
        checkedOutOutMovieOne = new CheckedOutMovie("The Dark Knight Rises", "Christopher Nolan", 2012, 9, customer);

        availableMovies = new ArrayList<>();
        checkedOutMovies = new ArrayList<>();
        checkedOutMovies.add(checkedOutOutMovieOne);

        allBooks.addAll(availableBooks);
        allBooks.addAll(checkedOutBooks);
        allMovies.addAll(checkedOutMovies);
        allMovies.add(availableMovieOne);
        allMovies.add(availableMovieTwo);

        customer = new Customer("111-1111", "1111", "Name", "Email", "Phone");

        when(bookSearcher.search(allBooks, "Title 3")).thenReturn(checkedOutOutBookOne);
        when(bookSearcher.search(allBooks, "Title 1")).thenReturn(new NullBook());
        when(movieSearcher.search(allMovies, "Title 3")).thenReturn(checkedOutOutMovieOne);
        when(movieSearcher.search(allMovies, "Title 1")).thenReturn(new NullMovie());

        library = new Library(availableBooks, availableMovies, allBooks, allMovies, bookSearcher,
                movieSearcher, checkedOutBooks, checkedOutMovies, new NullBook(), new NullMovie());
    }

    @Test
    public void shouldRefreshAvailableBooks() throws Exception {
        this.availableBooks.clear();
        library.refreshAvailableBooks();
        List<AvailableBook> availableBooks = new ArrayList<>();
        availableBooks.add(availableBookOne);
        availableBooks.add(availableBookTwo);

        assertTrue(this.availableBooks.equals(availableBooks));
    }

    @Test
    public void shouldRefreshCheckedOutBooks() throws Exception {
        this.availableMovies.clear();
        library.refreshCheckedOutBooks();
        List<CheckedOutBook> checkedOutBooks = new ArrayList<>();
        checkedOutBooks.add(checkedOutOutBookOne);

        assertTrue(this.checkedOutBooks.equals(checkedOutBooks));
    }

    @Test
    public void shouldRefreshAvailableMovies() throws Exception {
        this.availableMovies.clear();
        library.refreshAvailableMovies();
        List<AvailableMovie> availableMovies = new ArrayList<>();
        availableMovies.add(availableMovieOne);
        availableMovies.add(availableMovieTwo);

        assertTrue(this.availableMovies.containsAll(availableMovies));
    }

    @Test
    public void shouldRefreshCheckedOutMovies() throws Exception {
        this.checkedOutMovies.clear();
        library.refreshCheckedOutMovies();
        List<CheckedOutMovie> checkedOutMovies = new ArrayList<>();
        checkedOutMovies.add(checkedOutOutMovieOne);

        assertTrue(this.checkedOutMovies.equals(checkedOutMovies));
    }

    @Test
    public void shouldBeAbleToCheckoutBookWhenBookIsPassed() throws Exception {
        availableBookOne = mock(AvailableBook.class);
        library.checkoutBook(availableBookOne, customer);

        verify(availableBookOne).checkoutBook(customer);
    }

    @Test
    public void shouldBeAbleToReturnBookWhenBookIsPassed() throws Exception {
        checkedOutOutBookOne = mock(CheckedOutBook.class);
        library.checkoutBook(checkedOutOutBookOne, customer);

        verify(checkedOutOutBookOne).checkoutBook(customer);
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
        library.checkoutMovie(availableMovieOne, customer);

        verify(availableMovieOne).checkout(customer);
    }

    @Test
    public void shouldAddCheckedOutMovieToMovies() throws Exception {
        library = new Library(availableBooks, availableMovies, allBooks, allMovies, bookSearcher,
                movieSearcher, checkedOutBooks, checkedOutMovies, new NullBook(), new NullMovie());
        Movie movie = library.checkoutMovie(availableMovieOne, customer);

        assertTrue(movie instanceof CheckedOutMovie);
    }

    @Test
    public void shouldBeAbleToSearchForAMovieByName() throws Exception {
        String name = "Name 1";
        library.searchMovie(name);

        verify(movieSearcher).search(allMovies, name);
    }

    @Test
    public void shouldBeAbleToReturnAMovie() throws Exception {
        Movie returnedMovie = library.returnMovie(checkedOutOutMovieOne);

        assertTrue(returnedMovie instanceof AvailableMovie);
    }

    @Test
    public void shouldBeAbleToReturnABook() throws Exception {
        Book returnedBook = library.returnBook(checkedOutOutBookOne);

        assertTrue(returnedBook instanceof AvailableBook);
    }

    @Test
    public void shouldBeAbleToSearchCheckedOutBooks() throws Exception {
        Book actualResult = library.searchCheckedOutBook("Title 3");

        assertEquals(checkedOutOutBookOne, actualResult);
    }

    @Test
    public void shouldBeAbleToSearchCheckedOutMovies() throws Exception {
        Movie actualResult = library.searchCheckedOutMovie("Title 3");

        assertEquals(checkedOutOutMovieOne, actualResult);
    }

    @Test
    public void shouldReturnNullBooksWhenCheckedOutBookNotFound() throws Exception {
        Book actualResult = library.searchCheckedOutBook("Title 1");

        assertEquals(new NullBook(), actualResult);
    }

    @Test
    public void shouldReturnNullMoviesWhenCheckedOutMovieNotFound() throws Exception {
        Movie actualResult = library.searchCheckedOutMovie("Title 1");

        assertEquals(new NullMovie(), actualResult);
    }
}