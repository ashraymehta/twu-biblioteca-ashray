package com.thoughtworks.pathashala.helper;

import java.util.ArrayList;

public class BookDataReader {

    private String filePath;

    public BookDataReader(String file_path) {
        this.filePath = file_path;
    }

    public ArrayList<String> getListOfBooks() {
        ArrayList<String> listOfBooks = new ArrayList<>();
        listOfBooks.add("Hello");
        return listOfBooks;
    }
}
