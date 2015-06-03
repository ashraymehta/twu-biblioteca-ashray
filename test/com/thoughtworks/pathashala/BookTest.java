package com.thoughtworks.pathashala;

import org.junit.Test;

import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void testAuthorIsNotNullOrEmpty() {
        int yearPublication = 1990;
        String author = "Author";
        Book book = new Book(author, yearPublication);

        assertThat(book.author, not(isEmptyOrNullString()));
    }
}
