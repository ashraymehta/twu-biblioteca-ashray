package com.twu;

import com.twu.book.AvailableBook;
import com.twu.book.Book;
import com.twu.book.NullBook;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class SearcherTest {
    private NullBook nullBook;

    @Before
    public void setUp() throws Exception {
        nullBook = new NullBook();
    }

    @Test
    public void shouldSearchForTitleInListOfBooksAndGetTheBookWhenFound() throws Exception {
        List<Book> books = new ArrayList<>();
        AvailableBook bookOne = new AvailableBook("Title 1", "Author 1", 1000, 1);
        AvailableBook bookTwo = new AvailableBook("Title 2", "Author 2", 500, 2);
        books.add(bookOne);
        books.add(bookTwo);
        Searcher searcher = new Searcher(nullBook);

        Book actualResult = searcher.search(books, "Title 1");
        Book expectedResult = bookOne;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldSearchForTitleInListOfBooksAndReturnNullBookWhenBookIsNotFound() throws Exception {
        List<Book> books = new ArrayList<>();
        AvailableBook bookOne = new AvailableBook("Title 1", "Author 1", 1000, 1);
        AvailableBook bookTwo = new AvailableBook("Title 2", "Author 2", 500, 2);
        books.add(bookOne);
        books.add(bookTwo);
        Searcher searcher = new Searcher(nullBook);

        Book actualResult = searcher.search(books, "Title 3");

        assertEquals(nullBook, actualResult);
    }
}