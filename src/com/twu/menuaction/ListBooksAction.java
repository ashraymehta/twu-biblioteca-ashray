package com.twu.menuaction;


import com.twu.BooksView;

public class ListBooksAction implements MenuAction {

    private final BooksView booksView;

    public ListBooksAction(BooksView booksView) {
        this.booksView = booksView;
    }

    @Override
    public void perform() {
        booksView.printListOfBooks();
    }
}