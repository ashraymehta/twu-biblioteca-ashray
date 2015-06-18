package com.twu;

import com.twu.books.AvailableBook;
import com.twu.books.Book;
import com.twu.books.CheckedOutBook;
import com.twu.books.NullBook;
import com.twu.menuactions.*;
import com.twu.movies.AvailableMovie;
import com.twu.movies.CheckedOutMovie;
import com.twu.movies.Movie;
import com.twu.movies.NullMovie;
import com.twu.user.AbstractUser;
import com.twu.user.Customer;
import com.twu.user.Librarian;
import com.twu.user.NullUser;
import com.twu.views.*;

import java.io.PrintStream;
import java.util.*;

// Entry point for the application
public class EntryPoint {

    private static Scanner scanner;
    private static ArrayList<Book> listOfAvailableBooks;
    private static Books availableBooks;
    private static PrintStream printStream;
    private static ArrayList<Book> listOfCheckedOutBooks;
    private static BooksView availableBooksView;
    private static ReturnBookView returnBookView;
    private static CheckoutBookView checkoutBookView;
    private static ArrayList<Book> allBooks;
    private static Library library;
    private static HashMap<Integer, String> customerMenuItemsMappedToSerials;
    private static HashMap<Integer, MenuAction> customerMenuItemsMappedToMenuAction;
    private static Set<Movie> allMovies;
    private static MoviesView moviesView;
    private static CheckoutMovieView checkoutMovieView;
    private static List<Movie> availableMovies;
    private static ReturnMovieView returnMovieView;
    private static QuitAction quitAction;
    private static ArrayList<Movie> listOfCheckedOutMovies;
    private static MenuView librarianMenuView;
    private static HashMap<Integer, String> librarianMenuItemsMappedToSerials;
    private static HashMap<Integer, MenuAction> librarianMenuItemsMappedToMenuAction;
    private static BooksView checkedOutBooksView;
    private static MoviesView checkedOutMoviesView;
    private static Movies checkedOutMovies;
    private static Customer checkedOutTo;
    private static CustomerDetailsView customerDetailsView;
    private static CheckedOutBookDetailsView checkedOutBookDetailsView;
    private static HashSet<AbstractUser> allUsers;

    public static void main(String[] args) {
        allUsers = initializeAllUsers();
        initializeStreams();
        initializeListOfBooks();
        initializeListOfMovies();
        initializeViews();
        NullBook nullBook = new NullBook();
        NullUser nullUser = new NullUser();
        BookSearcher bookSearcher = new BookSearcher(nullBook);
        Movie nullMovie = new NullMovie();
        MovieSearcher movieSearcher = new MovieSearcher(nullMovie);
        library = new Library(listOfAvailableBooks, availableMovies, allBooks, allMovies, bookSearcher, movieSearcher, listOfCheckedOutBooks, listOfCheckedOutMovies, nullBook);
        populateHashMaps();

        Menu customerMenu = new Menu(customerMenuItemsMappedToMenuAction, customerMenuItemsMappedToSerials);
        Menu librarianMenu = new Menu(librarianMenuItemsMappedToMenuAction, librarianMenuItemsMappedToSerials);
        MenuView customerMenuView = new MenuView(customerMenu, scanner, printStream);
        librarianMenuView = new MenuView(librarianMenu, scanner, printStream);
        ConsoleOut consoleOut = new ConsoleOut(printStream);

        Authenticator authenticator = new Authenticator(allUsers, nullUser);
        LoginView loginView = new LoginView(printStream, scanner);
        LoginController loginController = new LoginController(loginView, authenticator, nullUser);

        LogoutAction logoutAction = new LogoutAction();

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleOut, customerMenuView, librarianMenuView, quitAction, loginController, logoutAction);
        bibliotecaApp.start();
    }

    private static HashSet<AbstractUser> initializeAllUsers() {
        HashSet<AbstractUser> allUsers = new HashSet<>();
        checkedOutTo = new Customer("123-4567", "Password", "Name", "name@gmail.com", "98789098");
        allUsers.add(checkedOutTo);
        allUsers.add(new Customer("111-1111", "11111", "AnotherName", "11111@gmail.com", "9564347"));
        allUsers.add(new Librarian("000-0000", "0000"));
        return allUsers;
    }

    private static void initializeListOfBooks() {
        listOfAvailableBooks = getAvailableBooks();
        availableBooks = new Books(listOfAvailableBooks);
        listOfCheckedOutBooks = new ArrayList<>();
        listOfCheckedOutBooks.add(new CheckedOutBook("The Silkworm", "Robert Galbraith", 2014, checkedOutTo));
        allBooks = new ArrayList<>();
        allBooks.addAll(listOfAvailableBooks);
        allBooks.addAll(listOfCheckedOutBooks);
    }

    private static void initializeListOfMovies() {
        allMovies = new HashSet<>();
        availableMovies = new ArrayList<>();
        listOfCheckedOutMovies = new ArrayList<>();
        AvailableMovie availableMovieOne = new AvailableMovie("Batman Begins", "Christopher Nolan", 2005, 9);
        AvailableMovie availableMovieTwo = new AvailableMovie("The Dark Knight", "Christopher Nolan", 2008, 9);
        CheckedOutMovie checkedOutMovie = new CheckedOutMovie("The Dark Knight Returns",
                "Christopher Nolan", 2011, 9, checkedOutTo);
        listOfCheckedOutMovies.add(checkedOutMovie);
        availableMovies.add(availableMovieOne);
        availableMovies.add(availableMovieTwo);
        allMovies.addAll(availableMovies);
        allMovies.addAll(listOfCheckedOutMovies);
    }

    private static void initializeViews() {
        Books checkedOutBooks = new Books(listOfCheckedOutBooks);
        checkedOutMovies = new Movies(listOfCheckedOutMovies);
        availableBooksView = new BooksView(availableBooks, printStream);
        checkedOutBooksView = new BooksView(checkedOutBooks, printStream);
        checkedOutMoviesView = new MoviesView(checkedOutMovies, printStream);
        returnBookView = new ReturnBookView(checkedOutBooks, scanner, printStream);
        returnMovieView = new ReturnMovieView(scanner, printStream);
        checkoutBookView = new CheckoutBookView(availableBooks, scanner, printStream);
        checkoutMovieView = new CheckoutMovieView(scanner, printStream);
        moviesView = new MoviesView(new Movies(availableMovies), printStream);
        customerDetailsView = new CustomerDetailsView(printStream);
        checkedOutBookDetailsView = new CheckedOutBookDetailsView(scanner, printStream);
    }

    private static void populateHashMaps() {
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);
        MenuAction returnBookAction = new ReturnBookAction(returnBookView, library);
        quitAction = new QuitAction();
        customerMenuItemsMappedToSerials = new HashMap<>();
        customerMenuItemsMappedToMenuAction = new HashMap<>();
        customerMenuItemsMappedToSerials.put(1, "List Books");
        customerMenuItemsMappedToMenuAction.put(1, new ListAvailableBooksAction(availableBooksView, library));
        customerMenuItemsMappedToSerials.put(2, "Checkout Book");
        customerMenuItemsMappedToMenuAction.put(2, checkoutBookAction);
        customerMenuItemsMappedToSerials.put(3, "Return Book");
        customerMenuItemsMappedToMenuAction.put(3, returnBookAction);
        customerMenuItemsMappedToSerials.put(4, "List movies");
        customerMenuItemsMappedToMenuAction.put(4, new ListMoviesAction(moviesView, library));
        customerMenuItemsMappedToSerials.put(5, "Checkout Movie");
        customerMenuItemsMappedToMenuAction.put(5, new CheckoutMovieAction(checkoutMovieView, library));
        customerMenuItemsMappedToSerials.put(6, "Return Movie");
        customerMenuItemsMappedToMenuAction.put(6, new ReturnMovieAction(returnMovieView, library));
        customerMenuItemsMappedToSerials.put(7, "View Account Details");
        customerMenuItemsMappedToMenuAction.put(7, new CustomerDetailsAction(customerDetailsView));
        customerMenuItemsMappedToSerials.put(8, "Logout");
        customerMenuItemsMappedToMenuAction.put(8, new LogoutAction());
        customerMenuItemsMappedToSerials.put(9, "Quit");
        customerMenuItemsMappedToMenuAction.put(9, quitAction);

        librarianMenuItemsMappedToSerials = new HashMap<>();
        librarianMenuItemsMappedToMenuAction = new HashMap<>();
        librarianMenuItemsMappedToSerials.put(1, "View checked out book details");
        librarianMenuItemsMappedToMenuAction.put(1, new CheckedOutBookDetailsAction(checkedOutBookDetailsView, library));
        librarianMenuItemsMappedToSerials.put(2, "View checked out movie details");
        librarianMenuItemsMappedToMenuAction.put(2, new CheckedOutMovieDetailsAction(checkedOutMoviesView, library));
        librarianMenuItemsMappedToSerials.put(3, "Logout");
        librarianMenuItemsMappedToMenuAction.put(3, new LogoutAction());
        librarianMenuItemsMappedToSerials.put(4, "Quit");
        librarianMenuItemsMappedToMenuAction.put(4, new QuitAction());
    }

    private static void initializeStreams() {
        scanner = new Scanner(System.in);
        printStream = new PrintStream(System.out);
    }

    private static ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> listOfAvailableBooks = new ArrayList<>();
        listOfAvailableBooks.add(new AvailableBook("Harry Potter and the Philosopher's Stone", "JK Rowling", 1997));
        listOfAvailableBooks.add(new AvailableBook("Harry Potter and the Chamber of Secrets", "JK Rowling", 1998));
        return listOfAvailableBooks;
    }
}
