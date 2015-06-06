package com.thoughtworks.pathashala;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private ArrayList<String> availableBooks;

    public Library(ArrayList<String> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public List<String> getAvailableBooks() {
        return Collections.unmodifiableList(availableBooks);
    }
}
