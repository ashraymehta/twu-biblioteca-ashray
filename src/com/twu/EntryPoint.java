package com.twu;

import com.twu.book.AvailableBook;
import com.twu.book.Book;
import com.twu.book.NullBook;
import com.twu.menuaction.*;
import com.twu.movie.AvailableMovie;
import com.twu.movie.Movie;
import com.twu.movie.NullMovie;
import com.twu.view.*;

import java.io.PrintStream;
import java.util.*;

// Entry point for the application
public class EntryPoint {

    private static Scanner scanner;
    private static ArrayList<Book> listOfAvailableBooks;
    private static Books availableBooks;
    private static PrintStream consoleOutStream;
    private static ArrayList<Book> listOfCheckedOutBooks;
    private static BooksView booksView;
    private static ReturnBookView returnBookView;
    private static CheckoutBookView checkoutBookView;
    private static ArrayList<Book> allBooks;
    private static Library library;
    private static HashMap<Integer, String> menuItemsMappedToSerials;
    private static HashMap<Integer, MenuAction> menuItemsMappedToMenuAction;
    private static Set<Movie> allMovies;
    private static MoviesView moviesView;

    public static void main(String[] args) {
        initializeStreams();
        initializeListOfBooks();
        initializeListOfMovies();
        initializeViews();
        NullBook nullBook = new NullBook();
        BookSearcher bookSearcher = new BookSearcher(nullBook);
        Movie nullMovie = new NullMovie();
        MovieSearcher movieSearcher = new MovieSearcher(nullMovie);
        library = new Library(listOfAvailableBooks, allBooks, allMovies, bookSearcher, movieSearcher);
        populateHashMaps();

        Menu menu = new Menu(menuItemsMappedToMenuAction, menuItemsMappedToSerials);
        MenuView menuView = new MenuView(menu, scanner, consoleOutStream);
        ConsoleOut consoleOut = new ConsoleOut(consoleOutStream);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleOut, menuView);
        bibliotecaApp.start();
    }

    private static void initializeListOfMovies() {
        allMovies = new HashSet<>();
        allMovies.add(new AvailableMovie("Batman Begins", "Christopher Nolan", 2005, 9));
        allMovies.add(new AvailableMovie("The Dark Knight", "Christopher Nolan", 2008, 9));
    }

    private static void initializeViews() {
        Books checkedOutBooks = new Books(listOfCheckedOutBooks);
        Movies movies = new Movies(allMovies);
        booksView = new BooksView(availableBooks, consoleOutStream);
        returnBookView = new ReturnBookView(checkedOutBooks, scanner, consoleOutStream);
        checkoutBookView = new CheckoutBookView(availableBooks, scanner, consoleOutStream);
        moviesView = new MoviesView(movies, consoleOutStream);
    }

    private static void populateHashMaps() {
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);
        MenuAction returnBookAction = new ReturnBookAction(returnBookView, library);
        menuItemsMappedToSerials = new HashMap<>();
        menuItemsMappedToMenuAction = new HashMap<>();
        menuItemsMappedToSerials.put(1, "List books");
        menuItemsMappedToMenuAction.put(1, new ListBooksAction(booksView, library));
        menuItemsMappedToSerials.put(2, "Checkout Book");
        menuItemsMappedToMenuAction.put(2, checkoutBookAction);
        menuItemsMappedToSerials.put(3, "Return Book");
        menuItemsMappedToMenuAction.put(3, returnBookAction);
        menuItemsMappedToSerials.put(4, "List movies");
        menuItemsMappedToMenuAction.put(4, new ListMoviesAction(moviesView));
        menuItemsMappedToSerials.put(5, "Quit");
        menuItemsMappedToMenuAction.put(5, new QuitAction());
    }

    private static void initializeStreams() {
        scanner = new Scanner(System.in);
        consoleOutStream = new PrintStream(System.out);
    }

    private static void initializeListOfBooks() {
        listOfAvailableBooks = getAvailableBooks();
        availableBooks = new Books(listOfAvailableBooks);
        listOfCheckedOutBooks = new ArrayList<>();
        allBooks = new ArrayList<>();
        allBooks.addAll(listOfAvailableBooks);
        allBooks.addAll(listOfCheckedOutBooks);
    }


    private static ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> listOfAvailableBooks = new ArrayList<>();
        listOfAvailableBooks.add(new AvailableBook("Harry Potter and the Philosopher's Stone", "JK Rowling", 1997));
        listOfAvailableBooks.add(new AvailableBook("Harry Potter and the Chamber of Secrets", "JK Rowling", 1998));
        return listOfAvailableBooks;
    }
}
