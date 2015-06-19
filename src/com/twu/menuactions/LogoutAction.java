package com.twu.menuactions;

import com.twu.user.AbstractUser;

public class LogoutAction implements MenuAction {
    @Override
    public MenuAction perform(AbstractUser user) {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }
}
