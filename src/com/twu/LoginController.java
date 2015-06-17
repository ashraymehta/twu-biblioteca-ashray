package com.twu;

import com.twu.user.AbstractUser;

import static com.twu.Messages.ENTER_LIBRARY_NUMBER;
import static com.twu.Messages.ENTER_PASSWORD;

public class LoginController {

    private LoginView loginView;
    private Authenticator authenticator;

    public LoginController(LoginView loginView, Authenticator authenticator) {
        this.loginView = loginView;
        this.authenticator = authenticator;
    }

    public AbstractUser login() {
        loginView.printMessage(ENTER_LIBRARY_NUMBER);
        String libraryNumber = loginView.getUserInput();
        loginView.printMessage(ENTER_PASSWORD);
        String password = loginView.getUserInput();
        authenticator.login(libraryNumber, password);
        return null;
    }
}
