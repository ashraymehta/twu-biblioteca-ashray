package com.thoughtworks.pathashala;

public class Book {

    public final String author;
    public final int yearOfPublication;


    public Book(String author, int yearOfPublication) {
        if(yearOfPublication < 1)
            throw new IllegalArgumentException("Year of publication cannot be negative");

        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }
}
