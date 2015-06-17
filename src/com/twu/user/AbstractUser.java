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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

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
