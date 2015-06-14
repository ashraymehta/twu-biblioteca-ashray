package com.twu;

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
        return String.format("%-50s", title) + String.format("%-30s", author)
                + String.format("%-10s", yearPublished);
    }
}
