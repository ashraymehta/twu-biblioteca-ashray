package com.thoughtworks.pathashala;

public class Book {
    private String title, author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        final String SPACE = " ";
        return title + SPACE + author + SPACE + yearPublished;
    }
}
