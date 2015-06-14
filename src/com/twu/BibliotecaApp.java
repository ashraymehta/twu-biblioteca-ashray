package com.twu;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaApp {

    private ConsoleOut consoleOut;
    private MenuView menuView;

    public BibliotecaApp(ConsoleOut consoleOut, MenuView menuView) {
        this.consoleOut = consoleOut;
        this.menuView = menuView;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> listOfAvailableBooks = new ArrayList<>();
        listOfAvailableBooks.add(new Book("Harry Potter and the Philosopher's Stone", "JK Rowling", 1997));
        listOfAvailableBooks.add(new Book("Harry Potter and the Chamber of Secrets", "JK Rowling", 1998));
        PrintStream consoleOutStream = new PrintStream(System.out);
        Books availableBooks = new Books(listOfAvailableBooks);
        ArrayList<Book> listOfCheckedOutBooks = new ArrayList<>();
        Books checkedOutBooks = new Books(listOfCheckedOutBooks);
        BooksView booksView = new BooksView(availableBooks, consoleOutStream);
        ReturnBookView returnBookView = new ReturnBookView(checkedOutBooks, scanner, consoleOutStream);
        CheckoutBookView checkoutBookView = new CheckoutBookView(availableBooks, scanner, consoleOutStream);
        Library library = new Library(listOfAvailableBooks, listOfCheckedOutBooks);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);

        HashMap<Integer, String> menuItemsMappedToSerials = new HashMap<>();
        HashMap<Integer, MenuAction> menuItemsMappedToMenuAction = new HashMap<>();
        menuItemsMappedToSerials.put(1, "List books");
        menuItemsMappedToMenuAction.put(1, new ListBooksAction(booksView));
        menuItemsMappedToSerials.put(2, "Checkout Book");
        menuItemsMappedToMenuAction.put(2, checkoutBookAction);
        menuItemsMappedToSerials.put(3, "Return Book");
        MenuAction returnBookAction = new ReturnBookAction(returnBookView, library);
        menuItemsMappedToMenuAction.put(3, returnBookAction);
        menuItemsMappedToSerials.put(4, "Quit");
        menuItemsMappedToMenuAction.put(4, new QuitAction());

        Menu menu = new Menu(menuItemsMappedToMenuAction, menuItemsMappedToSerials);
        MenuView menuView = new MenuView(menu, scanner, consoleOutStream);
        ConsoleOut consoleOut = new ConsoleOut(consoleOutStream);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleOut, menuView);
        bibliotecaApp.start();
    }

    void start() {
        consoleOut.printWelcomeMessage();
        MenuAction actionTaken = null;
        while (!(actionTaken instanceof QuitAction)) {
            menuView.printMainMenu();
            actionTaken = menuView.performActionUponSelection();
        }
    }
}