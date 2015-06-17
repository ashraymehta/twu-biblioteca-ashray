package com.twu;

import com.twu.user.AbstractUser;

public class LoginController {

    private LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
    }

    public AbstractUser login() {
        String libraryNumber = loginView.getUserInput();
        String password = loginView.getUserInput();
        return null;
    }
}
