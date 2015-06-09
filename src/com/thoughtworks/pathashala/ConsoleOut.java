package com.thoughtworks.pathashala;

// Handles all output to console
public class ConsoleOut {

    public void printWelcomeMessage() {
        System.out.println("Welcome");
    }

    public void printListOfBooks(Books books) {
        System.out.println(books);
    }
}