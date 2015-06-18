package com.twu.menuactions;

import com.twu.user.Customer;
import com.twu.views.CustomerDetailsView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDetailsActionTest {
    @Mock
    CustomerDetailsView customerDetailsView;
    @Mock
    Customer customer;

    private CustomerDetailsAction customerDetailsAction;

    @Before
    public void setUp() throws Exception {
        customerDetailsAction = new CustomerDetailsAction(customerDetailsView);
    }

    @Test
    public void shouldInvokePrintingOfCustomerDetails() throws Exception {
        customerDetailsAction.perform(customer);

        verify(customerDetailsView).printCustomerDetails(customer);
    }
}