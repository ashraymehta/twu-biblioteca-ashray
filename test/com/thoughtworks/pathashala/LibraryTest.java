package com.thoughtworks.pathashala;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest {

    @Test(expected = UnsupportedOperationException.class)
    public void testAvailableLibraryBooksAreNotModifiable() {
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Book 1", "Author 1", 1000));
        listOfBooks.add(new Book("Book 2", "Author 2", 1500));
        listOfBooks.add(new Book("Book 3", "Author 3", 2000));
        Library library = new Library(listOfBooks);

        List<Book> listOfBooksInLibrary = library.getAvailableBooks();
        listOfBooksInLibrary.add(new Book("Sample Book", "Sample Author", 1800));
    }
}
