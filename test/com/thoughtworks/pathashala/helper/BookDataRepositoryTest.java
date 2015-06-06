package com.thoughtworks.pathashala.helper;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class BookDataRepositoryTest {

    private final String PROJECT_ROOT = System.getProperty("user.dir");
    private final String FILE_PATH = PROJECT_ROOT + File.separator + "BookList.txt";

    @Test
    public void testListOfBooksReadIsNotNullOrEmpty() throws Exception {
        BookDataRepository bookDataRepository = new BookDataRepository(FILE_PATH);

        ArrayList<String> actualListOfBooks = bookDataRepository.getListOfBooks();

        assertThat(actualListOfBooks, is(notNullValue()));
        assertThat(actualListOfBooks, is(not(empty())));
    }

    @Test
    public void testListOfBooksReadContainsTheSameBooksAsTheFile() throws Exception {
        BookDataRepository bookDataRepository = new BookDataRepository(FILE_PATH);

        ArrayList<String> actualListOfBooks = bookDataRepository.getListOfBooks();
        ArrayList<String> expectedListOfBooks = new ArrayList<>();
        expectedListOfBooks.add("Introduction to Programming");
        expectedListOfBooks.add("The Pragmatic Programmer");
        expectedListOfBooks.add("Harry Potter and the Philosopher's Stone");


        assertThat(actualListOfBooks, is(expectedListOfBooks));
        assertThat(actualListOfBooks.size(), is(3));
    }

    @Test
    public void testListOfBooksIsEmptyIfFileDoesntExist() {
        BookDataRepository bookDataRepository = new BookDataRepository("Something.txt");

        ArrayList<String> actualListOfBooks = bookDataRepository.getListOfBooks();

        assertThat(actualListOfBooks, is(empty()));
    }
}
