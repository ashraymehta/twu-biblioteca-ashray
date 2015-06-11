package com.thoughtworks.pathashala;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> listOfBooks;

    public Books(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public String getBooksWithSerialsAsString() {
        String listOfBooksAsString = "";
        for (int i=0; i<listOfBooks.size(); i++)
            listOfBooksAsString += (i+1) + ". " + listOfBooks.get(i).toString() + System.lineSeparator();
        return listOfBooksAsString;
    }

    @Override
    public String toString() {
        String listOfBooksAsString = "";
        for (Book book : listOfBooks)
            listOfBooksAsString += book + System.lineSeparator();
        return listOfBooksAsString;
    }
}