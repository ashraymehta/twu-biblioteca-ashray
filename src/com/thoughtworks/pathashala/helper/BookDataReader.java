package com.thoughtworks.pathashala.helper;

import java.io.*;
import java.util.ArrayList;

public class BookDataReader {

    private String filePath;

    public BookDataReader(String file_path) {
        this.filePath = file_path;
    }

    public ArrayList<String> getListOfBooks() {
        ArrayList<String> listOfBooks = new ArrayList<>();
        File file = new File(filePath);
        if(file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String readLine;

                while((readLine = bufferedReader.readLine()) != null) {
                    listOfBooks.add(readLine.trim());
                }
            } catch (FileNotFoundException e) {
                return listOfBooks;
            } catch (IOException e) {
                return listOfBooks;
            }

        }
        return listOfBooks;
    }
}
