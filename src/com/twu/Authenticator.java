package com.twu;

import com.twu.user.AbstractUser;
import com.twu.user.NullUser;

import java.util.Set;

public class Authenticator {
    private Set<AbstractUser> allUsers;
    private NullUser nullUser;

    public Authenticator(Set<AbstractUser> allUsers, NullUser nullUser) {
        this.allUsers = allUsers;
        this.nullUser = nullUser;
    }


    public AbstractUser login(AbstractUser toBeLoggedIn) {
        if(allUsers.contains(toBeLoggedIn))
            return toBeLoggedIn;
        else
            return null;

    }
}
