package com.twu.menuactions;

import com.twu.user.AbstractUser;

public class QuitAction implements MenuAction {
    @Override
    public void perform(AbstractUser user) {
        return;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getClass() == obj.getClass();
    }
}