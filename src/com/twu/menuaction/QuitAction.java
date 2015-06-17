package com.twu.menuaction;

public class QuitAction implements MenuAction {
    @Override
    public void perform() {
        return;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getClass() == obj.getClass();
    }
}