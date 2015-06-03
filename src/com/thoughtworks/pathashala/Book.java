package com.thoughtworks.pathashala;

public class Book {

    public String title;
    public final String author;
    public final int yearOfPublication;

    public Book(String title, String author, int yearOfPublication) {
        if (title == null || title.length() > 0)
            throw new IllegalArgumentException("Title cannot be null or empty");
        if (author == null || author.length() > 0)
            throw new IllegalArgumentException("Author cannot be null or empty");
        if (yearOfPublication < 1)
            throw new IllegalArgumentException("Year of publication cannot be negative");

        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }
}
