package com.twu;

import com.twu.menuactions.MenuAction;
import com.twu.user.AbstractUser;
import com.twu.views.MenuView;

public class LibrarianController {
    private MenuView librarianMenuView;
    private MenuAction quitAction;
    private MenuAction logoutAction;
    private MenuAction nullAction;

    public LibrarianController(MenuView librarianMenuView, MenuAction quitAction, MenuAction logoutAction, MenuAction nullAction) {
        this.librarianMenuView = librarianMenuView;
        this.quitAction = quitAction;
        this.logoutAction = logoutAction;
        this.nullAction = nullAction;
    }

    public MenuAction execute(AbstractUser user) {
        MenuAction actionTaken;
        do {
            librarianMenuView.printMainMenu();
            actionTaken = librarianMenuView.getSelectionAndPerformAction(user);
        } while (!quitAction.equals(actionTaken) && !logoutAction.equals(actionTaken) &&
                !nullAction.equals(actionTaken));
        return actionTaken;
    }
}
