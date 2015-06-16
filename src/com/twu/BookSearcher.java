package com.twu;

import com.twu.book.Book;
import com.twu.book.NullBook;

import java.util.ArrayList;
import java.util.List;

// Searches a book title when a list of books is provided
public class BookSearcher {

    private NullBook nullBook;

    public BookSearcher(NullBook nullBook) {
        this.nullBook = nullBook;
    }

    public Book search(List<Book> books, String title) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            book.addToListIfTitleMatches(matchingBooks, title);
        }
        if (matchingBooks.size() > 0)
            return matchingBooks.get(0);
        else
            return nullBook;
    }
}