package com.twu.menuactions;

import com.twu.user.AbstractUser;

// Defined behaviour for all Menu actions
public interface MenuAction {
    void perform(AbstractUser user);
}
