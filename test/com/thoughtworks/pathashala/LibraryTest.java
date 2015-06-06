package com.thoughtworks.pathashala;

import com.thoughtworks.pathashala.helper.BookDataReader;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    @Test
    public void testLibraryHasBooksAvailableAfterInitialization() throws Exception {
        String projectRoot = System.getProperty("user.dir");
        String filePath = projectRoot + File.separator + "BookList.txt";
        BookDataReader bookDataReader = new BookDataReader(filePath);
        ArrayList<String> listOfBooksRead = bookDataReader.getListOfBooks();
        Library library = new Library(listOfBooksRead);

        assertThat(library.getAvailableBooks(), is(notNullValue()));
        assertThat(library.getAvailableBooks(), is(not(empty())));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAvailableLibraryBooksAreNotModifiable() {
        String projectRoot = System.getProperty("user.dir");
        String filePath = projectRoot + File.separator + "BookList.txt";
        BookDataReader bookDataReader = new BookDataReader(filePath);
        ArrayList<String> listOfBooksRead = bookDataReader.getListOfBooks();
        Library library = new Library(listOfBooksRead);

        List<String> listOfBooksInLibrary = library.getAvailableBooks();
        listOfBooksInLibrary.add("Sample Book");
    }
}
