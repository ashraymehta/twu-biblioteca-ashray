package com.twu.menuactions;

import com.twu.user.AbstractUser;
import com.twu.views.CheckedOutBookDetailsView;

public class CheckedOutBookDetailsAction implements MenuAction {

    private CheckedOutBookDetailsView checkedOutBookDetailsView;

    public CheckedOutBookDetailsAction(CheckedOutBookDetailsView checkedOutBookDetailsView) {
        this.checkedOutBookDetailsView = checkedOutBookDetailsView;
    }

    @Override
    public void perform(AbstractUser user) {
        checkedOutBookDetailsView.getUserInput();
    }
}
