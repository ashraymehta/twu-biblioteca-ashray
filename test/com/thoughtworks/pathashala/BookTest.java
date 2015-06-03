package com.thoughtworks.pathashala;

import org.junit.Test;

import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class BookTest {

    @Test
    public void testAuthorIsNotNullOrEmpty() {
        String title = "Big Book of Books";
        int yearPublication = 1990;
        String author = "Author";
        Book book = new Book(title, author, yearPublication);

        assertThat(book.author, not(isEmptyOrNullString()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTitleIsNotNullOrEmpty() {
        String title = "";
        int yearPublication = 1990;
        String author = "Author";
        Book book = new Book(title, author, yearPublication);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testYearPublishedIsPositive() {
        String title = "Big Book of Books";
        int yearPublished = -100;
        String author = "Author";
        Book book = new Book(title, author, yearPublished);
    }
}
