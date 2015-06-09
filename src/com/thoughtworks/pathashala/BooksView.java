package com.thoughtworks.pathashala;

import org.junit.Test;

public class BooksView {
    private Books books;

    public BooksView(Books books) {
        this.books = books;
    }

    @Test
    public void printListOfBooks() {
        System.out.println(books);
    }
}
