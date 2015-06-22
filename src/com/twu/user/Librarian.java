package com.twu.user;

import com.twu.Messages;

// Represents user of type librarian; provides a string to represent this type of user
public class Librarian extends AbstractUser {
    public Librarian(String libraryNumber, String password) {
        super(libraryNumber, password);
    }

    @Override
    public String getLoginStatusMessage() {
        return Messages.SUCCESSFUL_LOGIN;
    }
}
