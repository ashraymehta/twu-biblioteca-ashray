package com.thoughtworks.pathashala;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private ArrayList<Book> availableBooks;

    public Library(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public List<Book> getAvailableBooks() {
        return Collections.unmodifiableList(availableBooks);
    }
}