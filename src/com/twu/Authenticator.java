package com.twu;

import com.twu.user.AbstractUser;
import com.twu.user.NullUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Authenticator {
    private Set<AbstractUser> allUsers;
    private NullUser nullUser;

    public Authenticator(Set<AbstractUser> allUsers, NullUser nullUser) {
        this.allUsers = allUsers;
        this.nullUser = nullUser;
    }

    public AbstractUser login(String libraryNumber, String password) {
        List<AbstractUser> matchingUsers = new ArrayList<>();
        for (AbstractUser user : allUsers) {
            user.addToListIfCredentialsMatch(libraryNumber, password, matchingUsers);
        }
        if (matchingUsers.size() > 0)
            return matchingUsers.get(0);
        else
            return nullUser;
    }
}
