package com.twu.menuactions;


import com.twu.Library;
import com.twu.user.AbstractUser;
import com.twu.views.BooksView;

// Invokes the printing of list of books
public class ListAvailableBooksAction implements MenuAction {
    private final BooksView booksView;
    private final Library library;

    public ListAvailableBooksAction(BooksView booksView, Library library) {
        this.booksView = booksView;
        this.library = library;
    }

    @Override
    public MenuAction perform(AbstractUser user) {
        library.refreshAvailableBooks();
        booksView.printListOfBooks();
        return this;
    }
}