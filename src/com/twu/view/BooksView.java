package com.twu.view;

import com.twu.Books;

import java.io.PrintStream;

// Prints list of books
public class BooksView {
    private Books books;
    private PrintStream printStream;

    public BooksView(Books books, PrintStream printStream) {
        this.books = books;
        this.printStream = printStream;
    }

    public void printListOfBooks() {
        printStream.println(books);
    }
}