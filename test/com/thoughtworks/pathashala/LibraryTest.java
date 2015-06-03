package com.thoughtworks.pathashala;

import org.junit.Test;

import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    @Test
    public void testThatLibraryHasAListOfBooks() {
        Library library = new Library();
        assertThat(library.availableBooks, notNullValue());
        assertThat(library.availableBooks, empty());
    }
}
