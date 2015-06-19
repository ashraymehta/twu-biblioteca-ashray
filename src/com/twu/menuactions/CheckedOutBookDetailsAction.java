package com.twu.menuactions;

import com.twu.Library;
import com.twu.books.Book;
import com.twu.user.AbstractUser;
import com.twu.views.CheckedOutBookDetailsView;

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
