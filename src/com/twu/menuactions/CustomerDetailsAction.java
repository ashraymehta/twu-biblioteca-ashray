package com.twu.menuactions;

import com.twu.user.AbstractUser;
import com.twu.user.Customer;
import com.twu.views.CustomerDetailsView;

// Invokes display of current user's account details
public class CustomerDetailsAction implements MenuAction {
    private CustomerDetailsView customerDetailsView;

    public CustomerDetailsAction(CustomerDetailsView customerDetailsView) {
        this.customerDetailsView = customerDetailsView;
    }

    @Override
    public MenuAction perform(AbstractUser user) {
        customerDetailsView.printCustomerDetails((Customer) user);
        return this;
    }
}
