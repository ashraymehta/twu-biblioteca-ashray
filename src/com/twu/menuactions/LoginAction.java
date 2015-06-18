package com.twu.menuactions;

import com.twu.CustomerController;
import com.twu.LibrarianController;
import com.twu.LoginController;
import com.twu.user.AbstractUser;
import com.twu.user.Librarian;

public class LoginAction implements MenuAction {
    private LoginController loginController;
    private LibrarianController librarianController;
    private CustomerController customerController;
    private QuitAction quitAction;

    public LoginAction(LoginController loginController, LibrarianController librarianController,
                       CustomerController customerController, QuitAction quitAction) {
        this.loginController = loginController;
        this.librarianController = librarianController;
        this.customerController = customerController;
        this.quitAction = quitAction;
    }

    @Override
    public void perform(AbstractUser user) {
        MenuAction lastActionTaken;
        do {
            user = loginController.login();
            if (user instanceof Librarian)
                lastActionTaken = librarianController.execute(user);
            else
                lastActionTaken = customerController.execute(user);
        } while (!lastActionTaken.equals(quitAction));
    }
}
