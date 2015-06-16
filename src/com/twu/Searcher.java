package com.twu;

import com.twu.book.Book;
import com.twu.book.NullBook;

import java.util.ArrayList;
import java.util.List;

public class Searcher {

    private List<Book> books;
    private NullBook nullBook;

    public Searcher(List<Book> books, NullBook nullBook) {
        this.books = books;
        this.nullBook = nullBook;
    }

    public Book search(String title) {
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