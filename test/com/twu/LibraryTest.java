package com.twu;

import com.twu.books.AvailableBook;
import com.twu.books.Book;
import com.twu.books.CheckedOutBook;
import com.twu.movies.AvailableMovie;
import com.twu.movies.CheckedOutMovie;
import com.twu.movies.Movie;
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

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    private ArrayList<Book> availableBookArrayList;
    private List<Movie> availableMovies;
    private Customer customer;
    private ArrayList<Book> checkedOutBooks;


    @Before
    public void setUp() throws Exception {
        availableBookOne = new AvailableBook("Title 1", "Author 1", 1000);
        availableBookTwo = new AvailableBook("Title 2", "Author 2", 1500);
        checkedOutOutBookOne = new CheckedOutBook("Title 3", "Author 3", 2000, customer);

        availableBookArrayList = new ArrayList<>();
        checkedOutBooks = new ArrayList<>();
        availableBookArrayList.add(availableBookOne);
        availableBookArrayList.add(availableBookTwo);
        checkedOutBooks.add(checkedOutOutBookOne);

        allBooks = new ArrayList<>();
        allMovies = new HashSet<>();

        availableMovieOne = new AvailableMovie("Batman Begins", "Christopher Nolan", 2005, 9);
        availableMovieTwo = new AvailableMovie("The Dark Knight", "Christopher Nolan", 2008, 9);
        checkedOutOutMovieOne = new CheckedOutMovie("The Dark Knight Rises", "Christopher Nolan", 2012, 9, customer);

        availableMovies = new ArrayList<>();

        allBooks.addAll(availableBookArrayList);
        allBooks.addAll(checkedOutBooks);
        allMovies.add(availableMovieOne);
        allMovies.add(availableMovieTwo);
        allMovies.add(checkedOutOutMovieOne);

        library = new Library(availableBookArrayList, availableMovies, allBooks, allMovies, bookSearcher,
                movieSearcher, checkedOutBooks);
    }

    @Test
    public void shouldReturnAvailableBooks() throws Exception {
        List<Book> actualResult = library.getAvailableBooks();
        List<AvailableBook> availableBooks = new ArrayList<>();
        availableBooks.add(availableBookOne);
        availableBooks.add(availableBookTwo);

        assertTrue(actualResult.equals(availableBooks));
    }

    @Test
    public void shouldReturnCheckedOutBooks() throws Exception {
        List<Book> actualResult = library.getCheckedOutBooks();
        List<CheckedOutBook> checkedOutBooks = new ArrayList<>();
        checkedOutBooks.add(checkedOutOutBookOne);

        assertTrue(actualResult.equals(checkedOutBooks));
    }

    @Test
    public void shouldReturnAvailableMovies() throws Exception {
        List<Movie> actualResult = library.getAvailableMovies();
        List<AvailableMovie> availableMovies = new ArrayList<>();
        availableMovies.add(availableMovieOne);
        availableMovies.add(availableMovieTwo);

        assertTrue(actualResult.containsAll(availableMovies));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldReturnUnmodifiableCollectionOfAvailableBooks() throws Exception {
        List<Book> actualResult = library.getAvailableBooks();
        actualResult.add(new AvailableBook("Title 4", "Author", 1000));
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
        library = new Library(availableBookArrayList, availableMovies, allBooks, allMovies, bookSearcher,
                movieSearcher, checkedOutBooks);
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
}