package com.thoughtworks.pathashala;

import java.util.ArrayList;

public class ListBooksAction implements MenuAction{

    private final ConsoleOut consoleOut;
    private final Books books;

    public ListBooksAction() {
        ArrayList<Book> arrayList = new ArrayList<>();
        arrayList.add(new Book("Harry Potter and the Philosopher's Stone", "JK Rowling", 1997));
        arrayList.add(new Book("Harry Potter and the Chamber of Secrets", "JK Rowling", 1998));
        this.books = new Books(arrayList);
        this.consoleOut = new ConsoleOut();
    }

    @Override
    public void perform() {
        consoleOut.printListOfBooks(books);
    }
}
