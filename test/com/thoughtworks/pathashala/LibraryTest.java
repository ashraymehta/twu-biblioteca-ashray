package com.thoughtworks.pathashala;

import com.thoughtworks.pathashala.helper.BookDataReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {

    @Test(expected = UnsupportedOperationException.class)
    public void testAvailableLibraryBooksAreNotModifiable() {
        ArrayList<String> listOfBooks = new ArrayList<>();
        listOfBooks.add("Book 1");
        listOfBooks.add("Book 2");
        listOfBooks.add("Book 3");
        Library library = new Library(listOfBooks);

        List<String> listOfBooksInLibrary = library.getAvailableBooks();
        listOfBooksInLibrary.add("Sample Book");
    }
}
