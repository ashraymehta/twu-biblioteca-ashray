package com.thoughtworks.pathashala;

public class BooksView {
    private Books books;

    public BooksView(Books books) {
        this.books = books;
    }

    public void printListOfBooks() {
        System.out.println(books);
    }
}