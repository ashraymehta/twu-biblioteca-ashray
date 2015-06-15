package com.twu;

import com.twu.book.AvailableBook;
import com.twu.book.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BookTest {

    private Book firstBook;
    private Book secondBook;
    private Book thirdBook;

    @Before
    public void setUp() throws Exception {
        firstBook = new AvailableBook("Title", "Author", 1000, 1);
        secondBook = new AvailableBook("Title", "Author", 1000, 1);
        thirdBook = new AvailableBook("Title", "Author", 1000, 1);
    }

    @Test
    public void shouldPresentDetailsOfBookAsString() throws Exception {
        String title = "Harry Potter and the Philosopher's Stone";
        String author = "JK Rowling";
        int yearPublished = 1997;
        AvailableBook book = new AvailableBook(title, author, yearPublished, 1);

        String actualString = book.toString();
        String expectedString = "1    Harry Potter and the Philosopher's Stone          " +
                "JK Rowling                    " + "1997      ";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldBeEqualToItself() {
        boolean actual = firstBook.equals(firstBook);

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowSymmetricProperty() {
        boolean actual = (firstBook.equals(secondBook) == secondBook.equals(firstBook));

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        boolean actual = firstBook.equals(secondBook) &&
                secondBook.equals(thirdBook) &&
                firstBook.equals(thirdBook);

        assertEquals(true, actual);
    }

    @Test
    public void shouldHaveSameHashCodeIfBooksAreEqual() {
        boolean actual = firstBook.equals(secondBook) && (firstBook.hashCode() == secondBook.hashCode());

        Assert.assertEquals(true, actual);
    }
}
