package com.thoughtworks.pathashala;

import com.thoughtworks.pathashala.helper.BookDataReader;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

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
        Library library = new Library();
        library.initialize(listOfBooksRead);

        assertThat(library.getAvailableBooks(), is(notNullValue()));
        assertThat(library.getAvailableBooks(), is(not(empty())));
    }
}
