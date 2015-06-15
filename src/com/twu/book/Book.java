package com.twu.book;

import java.util.List;

public abstract class Book {
    private String title, author;
    private int yearPublished;
    private int id;

    public Book(String title, String author, int yearPublished, int id) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%-5d", id) + String.format("%-50s", title) + String.format("%-30s", author)
                + String.format("%-10s", yearPublished);
    }

    public abstract void addToListIfAvailable(List<Book> availableList);
}
