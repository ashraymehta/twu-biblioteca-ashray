package com.thoughtworks.pathashala;

// Handles all I/O to and from console
public class Console {

    public void printWelcomeMessage() {
        System.out.println("Welcome");
    }

    public void printListOfBooks(Books books) {
        System.out.println(books);
    }
}