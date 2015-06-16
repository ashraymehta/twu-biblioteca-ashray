package com.twu;

import com.twu.book.Book;
import com.twu.book.NullBook;

import java.util.ArrayList;
import java.util.List;

public class Searcher {

    private NullBook nullBook;

    public Searcher(NullBook nullBook) {
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