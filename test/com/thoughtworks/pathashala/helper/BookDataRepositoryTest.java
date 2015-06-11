package com.thoughtworks.pathashala.helper;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class BookDataRepositoryTest {

    private BufferedReader bufferedReader;
    private File file;

    @Before
    public void setUp() throws Exception {
        String PROJECT_ROOT = System.getProperty("user.dir");
        String FILE_PATH = PROJECT_ROOT + File.separator + "BookList.txt";

        FileReader fileReader = new FileReader(FILE_PATH);
        bufferedReader = new BufferedReader(fileReader);
        file = new File(FILE_PATH);
    }

    @Test
    public void testListOfBooksReadIsNotNullOrEmpty() throws Exception {
        BookDataRepository bookDataRepository = new BookDataRepository(file, bufferedReader);

        ArrayList<String> actualListOfBooks = bookDataRepository.getListOfBooks();

        assertThat(actualListOfBooks, is(notNullValue()));
        assertThat(actualListOfBooks, is(not(empty())));
    }

    @Test
    public void testListOfBooksReadContainsTheSameBooksAsTheFile() throws Exception {
        BookDataRepository bookDataRepository = new BookDataRepository(file, bufferedReader);

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
        File file = new File("random.txt");
        BookDataRepository bookDataRepository = new BookDataRepository(file, bufferedReader);

        ArrayList<String> actualListOfBooks = bookDataRepository.getListOfBooks();

        assertThat(actualListOfBooks, is(empty()));
    }
}
