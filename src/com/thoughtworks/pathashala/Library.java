package com.thoughtworks.pathashala;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private ArrayList<String> availableBooks;

    public Library() {
        availableBooks = new ArrayList<>();
    }

    public void initialize(ArrayList<String> listOfBooksRead) {
        availableBooks.clear();
        if (listOfBooksRead != null)
            availableBooks.addAll(listOfBooksRead);
    }

    public List<String> getAvailableBooks() {
        return Collections.unmodifiableList(availableBooks);
    }
}
