package com.twu;

import com.twu.book.Book;
import com.twu.movie.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

// Holds the available and the checked out books; provides APIs to checkoutBook and return a book
public class Library {

    private final ArrayList<Book> allBooks;
    private final ArrayList<Book> availableBooks;
    private final Set<Movie> allMovies;
    private final BookSearcher bookSearcher;
    private final MovieSearcher movieSearcher;
    private final List<Movie> availableMovies;

    public Library(ArrayList<Book> availableBooks, ArrayList<Book> allBooks, Set<Movie> allMovies, BookSearcher bookSearcher,
                   MovieSearcher movieSearcher, List<Movie> availableMovies) {
        this.availableBooks = availableBooks;
        this.allBooks = allBooks;
        this.allMovies = allMovies;
        this.bookSearcher = bookSearcher;
        this.movieSearcher = movieSearcher;
        this.availableMovies = availableMovies;
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

    public Book checkoutBook(Book toBeCheckedOut) {
        return toBeCheckedOut.checkoutBook(allBooks);
    }

    public Book returnBook(Book toBeCheckedOut) {
        return toBeCheckedOut.returnBook(allBooks);
    }

    public Book searchBook(String title) {
        return bookSearcher.search(allBooks, title);
    }

    public Movie checkoutMovie(Movie movie) {
        allMovies.remove(movie);
        movie = movie.checkout();
        allMovies.add(movie);
        return movie;
    }

    public Movie searchMovie(String movieName) {
        return movieSearcher.search(allMovies, movieName);
    }
}
