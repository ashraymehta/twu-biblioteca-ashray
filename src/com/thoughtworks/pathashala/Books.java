package com.thoughtworks.pathashala;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> listOfBooks;

    public Books() {
        listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Harry Potter and the Philosopher's Stone", "JK Rowling", 1997));
        listOfBooks.add(new Book("Harry Potter and the Chamber of Secrets", "JK Rowling", 1998));
    }

    public Books(List<Book> bookArrayList) {
        this.listOfBooks = bookArrayList;
    }

    @Override
    public String toString() {
        String listOfBooksAsString = "";
        for (Book book : listOfBooks)
            listOfBooksAsString += book + System.lineSeparator();
        return listOfBooksAsString;
    }
}
