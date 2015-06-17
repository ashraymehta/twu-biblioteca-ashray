package com.twu;

import com.twu.user.AbstractUser;
import com.twu.user.Customer;
import org.junit.Before;

import java.util.ArrayList;

public class AuthenticatorTest {
    Customer customerStubOne;
    Customer customerStubTwo;

    private Authenticator authenticator;

    @Before
    public void setUp() throws Exception {
        ArrayList<AbstractUser> users = new ArrayList<>();
        users.add(customerStubOne);
        users.add(customerStubTwo);
        authenticator = new Authenticator(users);
    }
}