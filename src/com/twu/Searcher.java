package com.twu;

import com.twu.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Searcher {

    private List<Book> books;

    public Searcher(List<Book> books) {
        this.books = books;
    }

    public Book search(String title) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            book.addToListIfTitleMatches(matchingBooks, title);
        }
        if (matchingBooks.size() > 0)
            return matchingBooks.get(0);
        else
            return null;
    }
}