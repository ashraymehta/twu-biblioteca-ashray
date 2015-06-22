package com.twu.menuactions;

import com.twu.CustomerController;
import com.twu.LibrarianController;
import com.twu.LoginController;
import com.twu.user.AbstractUser;
import com.twu.user.Customer;
import com.twu.user.Librarian;

import java.util.List;

// Logs the user in and delegates job to appropriate controller based on the type of the user
public class LoginAction implements MenuAction {
    private LoginController loginController;
    private LibrarianController librarianController;
    private CustomerController customerController;
    private List<MenuAction> stopLoopActions;
    private NullAction nullAction;

    public LoginAction(LoginController loginController, LibrarianController librarianController,
                       CustomerController customerController, List<MenuAction> stopLoopActions, NullAction nullAction) {
        this.loginController = loginController;
        this.librarianController = librarianController;
        this.customerController = customerController;
        this.stopLoopActions = stopLoopActions;
        this.nullAction = nullAction;
    }

    @Override
    public MenuAction perform(AbstractUser user) {
        MenuAction lastActionTaken;
        do {
            user = loginController.login();
            if (user instanceof Librarian)
                lastActionTaken = librarianController.execute(user);
            else if (user instanceof Customer)
                lastActionTaken = customerController.execute(user);
            else
                lastActionTaken = nullAction;
        } while (!stopLoopActions.contains(lastActionTaken));
        return lastActionTaken;
    }
}
