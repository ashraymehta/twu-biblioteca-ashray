package com.twu;

import com.twu.books.Book;
import com.twu.movies.Movie;
import com.twu.user.AbstractUser;
import com.twu.user.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

// Holds the available and the checked out books; provides APIs to checkoutBook and return a books
public class Library {
    private final ArrayList<Book> allBooks;
    private final ArrayList<Book> availableBooks;
    private final Set<Movie> allMovies;
    private final BookSearcher bookSearcher;
    private final MovieSearcher movieSearcher;
    private final List<Movie> availableMovies;
    private ArrayList<Book> checkedOutBooks;
    private ArrayList<Movie> checkedOutMovies;
    private Book nullBook;
    private Movie nullMovie;

    public Library(ArrayList<Book> availableBooks, List<Movie> availableMovies, ArrayList<Book> allBooks,
                   Set<Movie> allMovies, BookSearcher bookSearcher, MovieSearcher movieSearcher,
                   ArrayList<Book> checkedOutBooks, ArrayList<Movie> checkedOutMovies, Book nullBook, Movie nullMovie) {
        this.availableBooks = availableBooks;
        this.allBooks = allBooks;
        this.allMovies = allMovies;
        this.bookSearcher = bookSearcher;
        this.movieSearcher = movieSearcher;
        this.availableMovies = availableMovies;
        this.checkedOutBooks = checkedOutBooks;
        this.checkedOutMovies = checkedOutMovies;
        this.nullBook = nullBook;
        this.nullMovie = nullMovie;
    }

    public List<Book> getAvailableBooks() {
        availableBooks.clear();
        for (Book book : allBooks) {
            book.addToListIfAvailable(availableBooks);
        }
        return Collections.unmodifiableList(availableBooks);
    }

    public List<Movie> getAvailableMovies() {
        availableMovies.clear();
        for (Movie movie : allMovies) {
            movie.addToListIfAvailable(availableMovies);
        }
        return Collections.unmodifiableList(availableMovies);
    }

    public List<Book> getCheckedOutBooks() {
        checkedOutBooks.clear();
        for (Book book : allBooks) {
            book.addToListIfCheckedOut(checkedOutBooks);
        }
        return Collections.unmodifiableList(checkedOutBooks);
    }

    public List<Movie> getCheckedOutMovies() {
        checkedOutMovies.clear();
        for (Movie movie : allMovies) {
            movie.addToListIfCheckedOut(checkedOutMovies);
        }
        return Collections.unmodifiableList(checkedOutMovies);
    }

    public Book checkoutBook(Book toBeCheckedOut, Customer customer) {
        allBooks.remove(toBeCheckedOut);
        toBeCheckedOut = toBeCheckedOut.checkoutBook(customer);
        allBooks.add(toBeCheckedOut);
        return toBeCheckedOut;
    }

    public Book returnBook(Book toBeReturned) {
        allBooks.remove(toBeReturned);
        toBeReturned = toBeReturned.returnBook();
        allBooks.add(toBeReturned);
        return toBeReturned;
    }

    public Movie checkoutMovie(Movie movie, AbstractUser customer) {
        allMovies.remove(movie);
        movie = movie.checkout(customer);
        allMovies.add(movie);
        return movie;
    }

    public Movie returnMovie(Movie movie) {
        allMovies.remove(movie);
        movie = movie.returnMovie();
        allMovies.add(movie);
        return movie;
    }

    public Book searchBook(String title) {
        return bookSearcher.search(allBooks, title);
    }

    public Book searchCheckedOutBook(String title) {
        checkedOutBooks.clear();
        Book found = searchBook(title);
        found.addToListIfCheckedOut(checkedOutBooks);
        if (checkedOutBooks.size() > 0)
            return checkedOutBooks.get(0);
        else
            return nullBook;
    }

    public Movie searchCheckedOutMovie(String name) {
        checkedOutMovies.clear();
        Movie found = searchMovie(name);
        found.addToListIfCheckedOut(checkedOutMovies);
        if (checkedOutMovies.size() > 0)
            return checkedOutMovies.get(0);
        else
            return nullMovie;
    }

    public Movie searchMovie(String movieName) {
        return movieSearcher.search(allMovies, movieName);
    }
}
