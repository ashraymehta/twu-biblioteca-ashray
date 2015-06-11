package com.thoughtworks.pathashala.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookDataRepository {

    private BufferedReader bufferedReader;
    private File file;

    public BookDataRepository(File file, BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
        this.file = file;
    }

    public ArrayList<String> getListOfBooks() {
        ArrayList<String> listOfBooks = new ArrayList<>();
        if (file.exists()) {
            readBookDataFromFile(listOfBooks);

        }
        return listOfBooks;
    }

    private void readBookDataFromFile(ArrayList<String> listOfBooks) {
        try {
            String readLine;
            while ((readLine = bufferedReader.readLine()) != null) {
                listOfBooks.add(readLine.trim());
            }
        } catch (IOException e) {
            return;
        }
    }
}
