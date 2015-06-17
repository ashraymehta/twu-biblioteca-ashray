package com.twu.user;

import com.twu.Messages;

public class Customer extends AbstractUser {
    public Customer(String libraryNumber, String password) {
        super(libraryNumber, password);
    }

    @Override
    public String getLoginStatusMessage() {
        return Messages.SUCCESSFUL_LOGIN;
    }
}