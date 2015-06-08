package com.thoughtworks.pathashala.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BookDataRepository {

    private String filePath;

    public BookDataRepository(String file_path) {
        this.filePath = file_path;
    }

    public ArrayList<String> getListOfBooks() {
        ArrayList<String> listOfBooks = new ArrayList<>();
        File file = new File(filePath);
        if (file.exists()) {
            readBookDataFromFile(listOfBooks, file);

        }
        return listOfBooks;
    }

    private void readBookDataFromFile(ArrayList<String> listOfBooks, File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readLine;

            while ((readLine = bufferedReader.readLine()) != null) {
                listOfBooks.add(readLine.trim());
            }
        } catch (IOException e) {
            return;
        }
    }
}
