package com.twu.user;

import com.twu.Messages;

public class NullUser extends AbstractUser {
    public NullUser() {
        super("", "");
    }

    @Override
    public String getLoginStatusMessage() {
        return Messages.UNSUCCESSFUL_LOGIN;
    }
}
