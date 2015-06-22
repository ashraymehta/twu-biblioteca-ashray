package com.twu;

import com.twu.books.Book;

import java.util.ArrayList;
import java.util.List;

// Holds a collection of books and provide a string representation for that collection
public class Books {
    private List<Book> listOfBooks;

    public Books(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public String getBooksWithSerialsAsString() {
        String listOfBooksAsString = "";
        for (int i = 0; i < listOfBooks.size(); i++)
            listOfBooksAsString += (i + 1) + ". " + listOfBooks.get(i).toString() + System.lineSeparator();
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