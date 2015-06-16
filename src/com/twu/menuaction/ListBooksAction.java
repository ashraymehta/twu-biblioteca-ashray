package com.twu.menuaction;


import com.twu.view.BooksView;
import com.twu.Library;

public class ListBooksAction implements MenuAction {

    private final BooksView booksView;
    private final Library library;

    public ListBooksAction(BooksView booksView, Library library) {
        this.booksView = booksView;
        this.library = library;
    }

    @Override
    public void perform() {
        library.getAvailableBooks();
        booksView.printListOfBooks();
    }
}