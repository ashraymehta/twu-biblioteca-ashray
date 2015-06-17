package com.twu.user;

public abstract class AbstractUser {
    protected String libraryNumber;
    protected String password;

    public AbstractUser(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%-10s", libraryNumber);
    }
}
