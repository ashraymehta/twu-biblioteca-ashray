package com.twu.user;

import com.twu.Messages;

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
}