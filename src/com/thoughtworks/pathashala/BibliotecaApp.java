package com.thoughtworks.pathashala;

import com.sun.java.swing.action.ExitAction;

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
        ArrayList<Book> arrayList = new ArrayList<>();
        arrayList.add(new Book("Harry Potter and the Philosopher's Stone", "JK Rowling", 1997));
        arrayList.add(new Book("Harry Potter and the Chamber of Secrets", "JK Rowling", 1998));
        PrintStream consoleStream = new PrintStream(System.out);
        BooksView booksView = new BooksView(new Books(arrayList), consoleStream);
        HashMap<Integer, String> menuItemsMappedToSerials = new HashMap<>();
        HashMap<Integer, MenuAction> menuItemsMappedToMenuAction = new HashMap<>();
        menuItemsMappedToSerials.put(1, "List books");
        menuItemsMappedToMenuAction.put(1, new ListBooksAction(booksView));
        menuItemsMappedToSerials.put(2, "Quit");
        menuItemsMappedToMenuAction.put(2, new QuitAction());
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(menuItemsMappedToMenuAction, menuItemsMappedToSerials);
        PrintStream consolePrintStream = consoleStream;
        MenuView menuView = new MenuView(menu, scanner, consolePrintStream);
        ConsoleOut consoleOut = new ConsoleOut(consolePrintStream);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleOut, menuView);
        bibliotecaApp.start();
    }

    private void start() {
        consoleOut.printWelcomeMessage();
        promptUntilQuit();
    }

    private void promptUntilQuit() {
        MenuAction actionTaken = null;
        while (!(actionTaken instanceof QuitAction)) {
            menuView.printMainMenu();
            actionTaken = menuView.performActionUponSelection();
        }
    }
}