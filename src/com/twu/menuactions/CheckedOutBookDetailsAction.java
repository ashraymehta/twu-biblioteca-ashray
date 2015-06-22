package com.twu.menuactions;

import com.twu.Library;
import com.twu.books.Book;
import com.twu.user.AbstractUser;
import com.twu.views.CheckedOutBookDetailsView;

// Accepts a book title from user and invokes search for a corresponding checked out book
public class CheckedOutBookDetailsAction implements MenuAction {

    private CheckedOutBookDetailsView checkedOutBookDetailsView;
    private Library library;

    public CheckedOutBookDetailsAction(CheckedOutBookDetailsView checkedOutBookDetailsView, Library library) {
        this.checkedOutBookDetailsView = checkedOutBookDetailsView;
        this.library = library;
    }

    @Override
    public MenuAction perform(AbstractUser user) {
        String title = checkedOutBookDetailsView.getUserInput();
        Book book = library.searchCheckedOutBook(title);
        checkedOutBookDetailsView.printBookDetails(book);
        return this;
    }
}
