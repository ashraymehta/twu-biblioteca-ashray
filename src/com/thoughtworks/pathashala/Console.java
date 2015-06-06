package com.thoughtworks.pathashala;

import java.util.List;

// Handles all I/O to and from console
public class Console {

    public void printWelcomeMessage() {
        System.out.println("Welcome");
    }

    public void printListOfBooks(List<Book> bookList) {
        for(Book book : bookList) {
            System.out.println(book);
        }
    }
}
