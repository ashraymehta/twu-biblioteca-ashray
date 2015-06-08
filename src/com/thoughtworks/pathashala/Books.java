package com.thoughtworks.pathashala;

import java.util.List;

public class Books {
    private List<Book> listOfBooks;

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
