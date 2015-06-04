package com.thoughtworks.pathashala.helper;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class BookDataReaderTest {

    private final String PROJECT_ROOT = System.getProperty("user.dir");
    private final String FILE_PATH = PROJECT_ROOT + File.separator + "BookList.txt";

    @Test
    public void testListOfBooksReadIsNotNullOrEmpty() throws Exception {
        BookDataReader bookDataReader = new BookDataReader(FILE_PATH);

        ArrayList<String> actualListOfBooks = bookDataReader.getListOfBooks();

        assertThat(actualListOfBooks, is(notNullValue()));
        assertThat(actualListOfBooks, is(not(empty())));
    }

    @Test
    public void testListOfBooksReadContainsTheSameBooksAsTheFile() throws Exception {
        BookDataReader bookDataReader = new BookDataReader(FILE_PATH);

        ArrayList<String> actualListOfBooks = bookDataReader.getListOfBooks();
        ArrayList<String> expectedListOfBooks = new ArrayList<>();
        expectedListOfBooks.add("Introduction to Programming");
        expectedListOfBooks.add("The Pragmatic Programmer");
        expectedListOfBooks.add("Harry Potter and the Philosopher's Stone");


        assertThat(actualListOfBooks, is(expectedListOfBooks));
        assertThat(actualListOfBooks.size(), is(3));
    }
}
