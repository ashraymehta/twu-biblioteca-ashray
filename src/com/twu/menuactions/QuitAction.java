package com.twu.menuactions;

import com.twu.user.AbstractUser;

// Represents a quit action
public class QuitAction implements MenuAction {
    @Override
    public MenuAction perform(AbstractUser user) {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getClass() == obj.getClass();
    }
}