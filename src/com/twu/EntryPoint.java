package com.twu;

import com.twu.book.AvailableBook;
import com.twu.book.Book;
import com.twu.book.NullBook;
import com.twu.menuaction.*;
import com.twu.view.BooksView;
import com.twu.view.CheckoutBookView;
import com.twu.view.MenuView;
import com.twu.view.ReturnBookView;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

    public static void main(String[] args) {
        initializeStreams();
        initializeListOfBooks();
        initializeViews();
        NullBook nullBook = new NullBook();
        BookSearcher bookSearcher = new BookSearcher(nullBook);
        library = new Library(listOfAvailableBooks, allBooks, bookSearcher);
        populateHashMaps();

        Menu menu = new Menu(menuItemsMappedToMenuAction, menuItemsMappedToSerials);
        MenuView menuView = new MenuView(menu, scanner, consoleOutStream);
        ConsoleOut consoleOut = new ConsoleOut(consoleOutStream);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleOut, menuView);
        bibliotecaApp.start();
    }

    private static void initializeViews() {
        Books checkedOutBooks = new Books(listOfCheckedOutBooks);
        booksView = new BooksView(availableBooks, consoleOutStream);
        returnBookView = new ReturnBookView(checkedOutBooks, scanner, consoleOutStream);
        checkoutBookView = new CheckoutBookView(availableBooks, scanner, consoleOutStream);
    }

    private static void populateHashMaps() {
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);

        menuItemsMappedToSerials = new HashMap<>();
        menuItemsMappedToMenuAction = new HashMap<>();
        menuItemsMappedToSerials.put(1, "List books");
        menuItemsMappedToMenuAction.put(1, new ListBooksAction(booksView, library));
        menuItemsMappedToSerials.put(2, "Checkout Book");
        menuItemsMappedToMenuAction.put(2, checkoutBookAction);
        menuItemsMappedToSerials.put(3, "Return Book");
        MenuAction returnBookAction = new ReturnBookAction(returnBookView, library);
        menuItemsMappedToMenuAction.put(3, returnBookAction);
        menuItemsMappedToSerials.put(4, "Quit");
        menuItemsMappedToMenuAction.put(4, new QuitAction());
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
