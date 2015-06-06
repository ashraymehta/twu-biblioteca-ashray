package com.thoughtworks.pathashala;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BookTest {

    @Test
    public void testThatBookDetailsAreBeingRepresentedByToString() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        Book book = new Book(title, author, yearPublished);

        String actualString = book.toString();
        String expectedString = "Harry Potter and the Philosopher's Stone          " +
                "JK Rowling                    " + "1997      ";

        assertEquals(actualString, expectedString);
    }
}