package com.twu.menuactions;

import com.twu.Library;
import com.twu.user.AbstractUser;
import com.twu.views.BooksView;

public class CheckedOutBookDetailsAction implements MenuAction {
    private final BooksView booksView;
    private final Library library;

    public CheckedOutBookDetailsAction(BooksView booksView, Library library) {
        this.booksView = booksView;
        this.library = library;
    }

    @Override
    public void perform(AbstractUser user) {
        library.getCheckedOutBooks();
        booksView.printListOfBooks();
    }
}
