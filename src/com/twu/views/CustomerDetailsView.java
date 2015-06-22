package com.twu.views;

import com.twu.Messages;
import com.twu.user.AbstractUser;

import java.io.PrintStream;

// Displays customer details
public class CustomerDetailsView {
    private PrintStream printStream;

    public CustomerDetailsView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printCustomerDetails(AbstractUser user) {
        printStream.println(user);
    }


    public void printHeaders() {
        printStream.println(Messages.ACCOUNT_HEADERS);
    }
}
