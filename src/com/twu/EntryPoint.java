package com.twu;

import com.twu.menuaction.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EntryPoint {

    private static List<Book> checkedOutBooks;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> listOfAvailableBooks = getAvailableBooks();
        Books availableBooks = new Books(listOfAvailableBooks);
        PrintStream consoleOutStream = new PrintStream(System.out);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Books checkedOutBooks = new Books(listOfCheckedOutBooks);
        BooksView booksView = new BooksView(availableBooks, consoleOutStream);
        ReturnBookView returnBookView = new ReturnBookView(checkedOutBooks, scanner, consoleOutStream);
        CheckoutBookView checkoutBookView = new CheckoutBookView(availableBooks, scanner, consoleOutStream);
        Library library = new Library(listOfAvailableBooks, listOfCheckedOutBooks);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);

        HashMap<Integer, String> menuItemsMappedToSerials = new HashMap<>();
        HashMap<Integer, MenuAction> menuItemsMappedToMenuAction = new HashMap<>();
        populateHashMaps(booksView, returnBookView, library, checkoutBookAction, menuItemsMappedToSerials, menuItemsMappedToMenuAction);

        Menu menu = new Menu(menuItemsMappedToMenuAction, menuItemsMappedToSerials);
        MenuView menuView = new MenuView(menu, scanner, consoleOutStream);
        ConsoleOut consoleOut = new ConsoleOut(consoleOutStream);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleOut, menuView);
        bibliotecaApp.start();
    }

    private static void populateHashMaps(BooksView booksView, ReturnBookView returnBookView,
                                         Library library, CheckoutBookAction checkoutBookAction,
                                         HashMap<Integer, String> menuItemsMappedToSerials,
                                         HashMap<Integer, MenuAction> menuItemsMappedToMenuAction) {
        menuItemsMappedToSerials.put(1, "List books");
        menuItemsMappedToMenuAction.put(1, new ListBooksAction(booksView));
        menuItemsMappedToSerials.put(2, "Checkout Book");
        menuItemsMappedToMenuAction.put(2, checkoutBookAction);
        menuItemsMappedToSerials.put(3, "Return Book");
        MenuAction returnBookAction = new ReturnBookAction(returnBookView, library);
        menuItemsMappedToMenuAction.put(3, returnBookAction);
        menuItemsMappedToSerials.put(4, "Quit");
        menuItemsMappedToMenuAction.put(4, new QuitAction());
    }

    private static ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> listOfAvailableBooks = new ArrayList<>();
        listOfAvailableBooks.add(new Book("Harry Potter and the Philosopher's Stone", "JK Rowling", 1997, 1));
        listOfAvailableBooks.add(new Book("Harry Potter and the Chamber of Secrets", "JK Rowling", 1998, 2));
        return listOfAvailableBooks;
    }
}
