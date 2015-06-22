package com.twu.views;

import com.twu.Messages;
import com.twu.user.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDetailsViewTest {
    @Mock
    PrintStream printStream;
    @Mock
    Customer customer;

    private CustomerDetailsView customerDetailsView;

    @Before
    public void setUp() throws Exception {
        customerDetailsView = new CustomerDetailsView(printStream);
    }

    @Test
    public void shouldBeAbleToPrintCustomerDetails() throws Exception {
        customerDetailsView.printCustomerDetails(customer);

        verify(printStream).println(customer);
    }

    @Test
    public void shouldBeAbleToPrintHeaders() throws Exception {
        customerDetailsView.printHeaders();

        verify(printStream).println(Messages.ACCOUNT_HEADERS);
    }
}