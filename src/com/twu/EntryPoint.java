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
    private static HashMap<Integer, String> librarianMenuItemsMappedToSerials;
    private static HashMap<Integer, MenuAction> librarianMenuItemsMappedToMenuAction;
    private static Customer checkedOutTo;
    private static CustomerDetailsView customerDetailsView;
    private static CheckedOutBookDetailsView checkedOutBookDetailsView;
    private static CheckedOutMovieDetailsView checkedOutMovieDetailsView;
    private static LogoutAction logoutAction;
    private static Menu customerMenu;
    private static Menu librarianMenu;
    private static NullAction nullAction;
    private static NullBook nullBook;
    private static NullUser nullUser;
    private static NullMovie nullMovie;
    private static List<MenuAction> stopLoopActions;

    public static void main(String[] args) {
        HashSet<AbstractUser> allUsers = initializeAllUsers();
        initializeIndependentActions();
        initializeStreams();
        initializeListOfBooks();
        initializeListOfMovies();
        initializeNullObjects();
        initializeLibrary();
        initializeViews();
        populateHashMaps();
        initializeMenu();
        LoginController loginController = getLoginController(allUsers);

        MenuView customerMenuView = new MenuView(customerMenu, scanner, printStream, nullAction);
        MenuView librarianMenuView = new MenuView(librarianMenu, scanner, printStream, nullAction);

        LibrarianController librarianController = new LibrarianController(librarianMenuView, quitAction, logoutAction, nullAction);
        CustomerController customerController = new CustomerController(customerMenuView, quitAction, logoutAction, nullAction);

        stopLoopActions = new ArrayList<>();
        stopLoopActions.add(quitAction);
        stopLoopActions.add(logoutAction);

        MenuView initialMenuView = getInitialMenuView(loginController, librarianController, customerController);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(new ConsoleOut(printStream),
                quitAction, initialMenuView, nullUser);
        bibliotecaApp.start();
    }

    private static LoginController getLoginController(HashSet<AbstractUser> allUsers) {
        Authenticator authenticator = new Authenticator(allUsers, nullUser);
        LoginView loginView = new LoginView(printStream, scanner);


        return new LoginController(loginView, authenticator, nullUser);
    }

    private static void initializeLibrary() {
        library = new Library(listOfAvailableBooks, availableMovies, allBooks, allMovies,
                new BookSearcher(nullBook), new MovieSearcher(nullMovie), listOfCheckedOutBooks,
                listOfCheckedOutMovies, nullBook, nullMovie);
    }

    private static MenuView getInitialMenuView(LoginController loginController, LibrarianController librarianController, CustomerController customerController) {
        HashMap<Integer, String> initialMenuItemsMappedToSerials = new HashMap<>();
        HashMap<Integer, MenuAction> initialMenuItemsMappedToMenuAction = new HashMap<>();
        initialMenuItemsMappedToSerials.put(1, "List Books");
        initialMenuItemsMappedToMenuAction.put(1, new ListAvailableBooksAction(availableBooksView, library));
        initialMenuItemsMappedToSerials.put(2, "List movies");
        initialMenuItemsMappedToMenuAction.put(2, new ListMoviesAction(moviesView, library));
        initialMenuItemsMappedToSerials.put(3, "Login");
        initialMenuItemsMappedToMenuAction.put(3, new LoginAction(loginController, librarianController,
                customerController, stopLoopActions));

        Menu initialMenu = new Menu(initialMenuItemsMappedToMenuAction, initialMenuItemsMappedToSerials);

        return new MenuView(initialMenu, scanner, printStream, nullAction);
    }

    private static void initializeNullObjects() {
        nullBook = new NullBook();
        nullUser = new NullUser();
        nullMovie = new NullMovie();
    }

    private static void initializeIndependentActions() {
        logoutAction = new LogoutAction();
        nullAction = new NullAction();
        quitAction = new QuitAction();
    }

    private static void initializeMenu() {
        customerMenu = new Menu(customerMenuItemsMappedToMenuAction, customerMenuItemsMappedToSerials);
        librarianMenu = new Menu(librarianMenuItemsMappedToMenuAction, librarianMenuItemsMappedToSerials);
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
        listOfCheckedOutBooks = new ArrayList<>();
        listOfAvailableBooks = getAvailableBooks();
        listOfCheckedOutBooks.add(new CheckedOutBook("The Silkworm", "Robert Galbraith", 2014, checkedOutTo));
        availableBooks = new Books(listOfAvailableBooks);
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
        Movies checkedOutMovies = new Movies(listOfCheckedOutMovies);
        availableBooksView = new BooksView(availableBooks, printStream);
        new BooksView(checkedOutBooks, printStream);
        new MoviesView(checkedOutMovies, printStream);
        returnBookView = new ReturnBookView(checkedOutBooks, scanner, printStream);
        returnMovieView = new ReturnMovieView(scanner, printStream);
        checkoutBookView = new CheckoutBookView(availableBooks, scanner, printStream);
        checkoutMovieView = new CheckoutMovieView(scanner, printStream);
        moviesView = new MoviesView(new Movies(availableMovies), printStream);
        customerDetailsView = new CustomerDetailsView(printStream);
        checkedOutBookDetailsView = new CheckedOutBookDetailsView(scanner, printStream);
        checkedOutMovieDetailsView = new CheckedOutMovieDetailsView(scanner, printStream);
    }

    private static void populateHashMaps() {
        populateCustomerHashMap();
        populateLibrarianHashMap();
    }

    private static void populateLibrarianHashMap() {
        librarianMenuItemsMappedToSerials = new HashMap<>();
        librarianMenuItemsMappedToMenuAction = new HashMap<>();
        librarianMenuItemsMappedToSerials.putAll(customerMenuItemsMappedToSerials);
        librarianMenuItemsMappedToMenuAction.putAll(customerMenuItemsMappedToMenuAction);
        librarianMenuItemsMappedToSerials.put(9, "View checked out book details");
        librarianMenuItemsMappedToMenuAction.put(9, new CheckedOutBookDetailsAction(checkedOutBookDetailsView, library));
        librarianMenuItemsMappedToSerials.put(10, "View checked out movie details");
        librarianMenuItemsMappedToMenuAction.put(10, new CheckedOutMovieDetailsAction(checkedOutMovieDetailsView, library));
        librarianMenuItemsMappedToSerials.put(11, "Logout");
        librarianMenuItemsMappedToMenuAction.put(11, new LogoutAction());
        librarianMenuItemsMappedToSerials.put(12, "Quit");
        librarianMenuItemsMappedToMenuAction.put(12, new QuitAction());
    }

    private static void populateCustomerHashMap() {
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);
        ReturnBookAction returnBookAction = new ReturnBookAction(returnBookView, library);
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
