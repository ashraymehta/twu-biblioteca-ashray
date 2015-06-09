package com.thoughtworks.pathashala;

public class QuitAction implements MenuAction {
    @Override
    public void perform() {
        System.exit(0);
    }
}
