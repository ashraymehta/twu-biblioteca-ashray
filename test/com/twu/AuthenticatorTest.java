package com.twu;

import com.twu.user.AbstractUser;
import com.twu.user.Customer;
import com.twu.user.NullUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticatorTest {
    private Authenticator authenticator;
    private NullUser nullUser;

    @Before
    public void setUp() throws Exception {
        nullUser = new NullUser();
        Set<AbstractUser> users = new HashSet<>();
        Customer customerOne = new Customer("123-4567", "Password");
        Customer customerTwo = new Customer("987-6543", "Password");
        users.add(customerOne);
        users.add(customerTwo);
        authenticator = new Authenticator(users, nullUser);
    }

    @Test
    public void shouldReturnGivenUserIfAuthenticated() throws Exception {
        Customer toBeLoggedIn = new Customer("123-4567", "Password");

        AbstractUser actualResult = authenticator.login(toBeLoggedIn);
        AbstractUser expectedResult = toBeLoggedIn;

        assertEquals(toBeLoggedIn, actualResult);
    }
}