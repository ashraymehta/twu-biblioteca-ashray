package com.twu.user;

import com.twu.Messages;

// Represents null user
public class NullUser extends AbstractUser {
    public NullUser() {
        super("", "");
    }

    @Override
    public String getLoginStatusMessage() {
        return Messages.UNSUCCESSFUL_LOGIN;
    }

    @Override
    public boolean equals(Object o) {
        return o != null && getClass() == o.getClass();
    }
}
