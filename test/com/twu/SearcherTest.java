package com.twu;

import com.twu.book.AvailableBook;
import com.twu.book.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class SearcherTest {
    @Test
    public void shouldSearchForTitleInListOfBooksAndGetTheBookWhenFound() throws Exception {
        List<Book> books = new ArrayList<>();
        AvailableBook bookOne = new AvailableBook("Title 1", "Author 1", 1000, 1);
        AvailableBook bookTwo = new AvailableBook("Title 2", "Author 2", 500, 2);
        books.add(bookOne);
        books.add(bookTwo);
        Searcher searcher = new Searcher(books);

        Book actualResult = searcher.search("Title 1");
        Book expectedResult = bookOne;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldSearchForTitleInListOfBooksAndReturnNullWhenBookIsNotFound() throws Exception {
        List<Book> books = new ArrayList<>();
        AvailableBook bookOne = new AvailableBook("Title 1", "Author 1", 1000, 1);
        AvailableBook bookTwo = new AvailableBook("Title 2", "Author 2", 500, 2);
        books.add(bookOne);
        books.add(bookTwo);
        Searcher searcher = new Searcher(books);

        Book actualResult = searcher.search("Title 3");

        assertEquals(null, actualResult);
    }
}