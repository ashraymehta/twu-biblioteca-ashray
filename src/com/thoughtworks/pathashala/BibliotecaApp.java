package com.thoughtworks.pathashala;

import java.util.ArrayList;

public class BibliotecaApp {
    private BooksView booksView;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    private void initialize() {
        ArrayList<Book> arrayList = new ArrayList<>();
        arrayList.add(new Book("Harry Potter and the Philosopher's Stone", "JK Rowling", 1997));
        arrayList.add(new Book("Harry Potter and the Chamber of Secrets", "JK Rowling", 1998));
        booksView = new BooksView(new Books(arrayList));

    }

    private void start() {
        ConsoleOut consoleOut = new ConsoleOut();
        consoleOut.printWelcomeMessage();
        MenuView menuView = new MenuView(new Menu(booksView));
        menuView.printMainMenu();
        menuView.performActionUponSelection();
    }
}