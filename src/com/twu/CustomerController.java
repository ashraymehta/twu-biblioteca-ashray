package com.twu;

import com.twu.menuactions.MenuAction;
import com.twu.menuactions.NullAction;
import com.twu.user.AbstractUser;
import com.twu.views.MenuView;

// Takes over control from BibliotecaApp once the user has been determined to be a customer
public class CustomerController {
    private MenuView customerMenuView;
    private MenuAction quitAction;
    private MenuAction logoutAction;
    private NullAction nullAction;

    public CustomerController(MenuView customerMenuView, MenuAction quitAction, MenuAction logoutAction, NullAction nullAction) {
        this.customerMenuView = customerMenuView;
        this.quitAction = quitAction;
        this.logoutAction = logoutAction;
        this.nullAction = nullAction;
    }

    public MenuAction execute(AbstractUser user) {
        MenuAction actionTaken;
        do {
            customerMenuView.printMainMenu();
            actionTaken = customerMenuView.getSelectionAndPerformAction(user);
        } while (!quitAction.equals(actionTaken) && !logoutAction.equals(actionTaken) &&
                !nullAction.equals(actionTaken));
        return actionTaken;
    }
}
