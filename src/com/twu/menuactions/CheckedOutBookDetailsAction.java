package com.twu.menuactions;

import com.twu.Library;
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
    public void perform(AbstractUser user) {
        String title = checkedOutBookDetailsView.getUserInput();
        library.searchBook(title);
    }
}
