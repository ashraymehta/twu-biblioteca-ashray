package com.twu.user;

import java.util.List;

// Represents an abstract class common to all types of users; provides apis to compare users
public abstract class AbstractUser {
    protected String libraryNumber;
    protected String password;

    public AbstractUser(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public void addToListIfCredentialsMatch(String libraryNumber, String password, List<AbstractUser> matchedList) {
        if (this.libraryNumber.equals(libraryNumber) && this.password.equals(password))
            matchedList.add(this);
    }

    public abstract String getLoginStatusMessage();

    @Override
    public String toString() {
        return String.format("%-20s", libraryNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        AbstractUser that = (AbstractUser) o;

        if (!libraryNumber.equals(that.libraryNumber)) return false;
        return password.equals(that.password);

    }

    @Override
    public int hashCode() {
        int result = libraryNumber.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
