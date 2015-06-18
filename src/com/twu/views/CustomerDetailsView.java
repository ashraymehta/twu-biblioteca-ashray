package com.twu.views;

import com.twu.user.Customer;

import java.io.PrintStream;

public class CustomerDetailsView {
    private PrintStream printStream;

    public CustomerDetailsView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printCustomerDetails(Customer customer) {
        printStream.println(customer);
    }
}
