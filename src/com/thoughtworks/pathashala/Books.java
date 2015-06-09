package com.thoughtworks.pathashala;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> listOfBooks;

    public Books(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    @Override
    public String toString() {
        String listOfBooksAsString = "";
        for (Book book : listOfBooks)
            listOfBooksAsString += book + System.lineSeparator();
        return listOfBooksAsString;
    }
}