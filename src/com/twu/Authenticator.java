package com.twu;

import com.twu.user.AbstractUser;

import java.util.List;

public class Authenticator {
    private List<AbstractUser> allUsers;

    public Authenticator(List<AbstractUser> allUsers) {
        this.allUsers = allUsers;
    }
}
