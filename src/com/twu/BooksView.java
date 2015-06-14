package com.twu;

import java.io.PrintStream;

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