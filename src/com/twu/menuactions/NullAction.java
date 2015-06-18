package com.twu.menuactions;

import com.twu.user.AbstractUser;

public class NullAction implements MenuAction{
    @Override
    public void perform(AbstractUser user) {

    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }
}
