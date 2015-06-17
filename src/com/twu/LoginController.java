package com.twu;

import com.twu.user.AbstractUser;
import com.twu.user.NullUser;

import static com.twu.Messages.ENTER_LIBRARY_NUMBER;
import static com.twu.Messages.ENTER_PASSWORD;

public class LoginController {
    private LoginView loginView;
    private Authenticator authenticator;
    private NullUser nullUser;

    public LoginController(LoginView loginView, Authenticator authenticator, NullUser nullUser) {
        this.loginView = loginView;
        this.authenticator = authenticator;
        this.nullUser = nullUser;
    }

    public AbstractUser login() {
        AbstractUser user;
        do {
            loginView.printMessage(ENTER_LIBRARY_NUMBER);
            String libraryNumber = loginView.getUserInput();
            loginView.printMessage(ENTER_PASSWORD);
            String password = loginView.getUserInput();
            user = authenticator.login(libraryNumber, password);
            loginView.printMessage(user.getLoginStatusMessage());
        } while (user.equals(nullUser));
        return user;
    }
}
