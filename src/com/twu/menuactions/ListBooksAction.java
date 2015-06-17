package com.twu.menuactions;


import com.twu.Library;
import com.twu.views.BooksView;

// Invokes the printing of list of books
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