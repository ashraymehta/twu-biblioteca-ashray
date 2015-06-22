package com.twu.user;

import com.twu.Messages;

// Represents user of type customer; provides a string to represent this type of user
public class Customer extends AbstractUser {
    private String name;
    private String email_address;
    private String phone_number;

    public Customer(String libraryNumber, String password, String name, String email_address, String phone_number) {
        super(libraryNumber, password);
        this.name = name;
        this.email_address = email_address;
        this.phone_number = phone_number;
    }

    @Override
    public String getLoginStatusMessage() {
        return Messages.SUCCESSFUL_LOGIN;

    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-30s", name) + String.format("%-30s", email_address) +
                String.format("%-15s", phone_number);
    }
}