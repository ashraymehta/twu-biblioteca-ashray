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
    private String libraryNumberOne;
    private String passwordOne;
    private Customer customerOne;

    @Before
    public void setUp() throws Exception {
        nullUser = new NullUser();
        Set<AbstractUser> users = new HashSet<>();
        customerOne = new Customer("123-4567", "Password");
        Customer customerTwo = new Customer("987-6543", "Password");
        libraryNumberOne = "123-4567";
        passwordOne = "Password";
        users.add(customerOne);
        users.add(customerTwo);
        authenticator = new Authenticator(users, nullUser);
    }

    @Test
    public void shouldReturnGivenUserIfAuthenticated() throws Exception {
        AbstractUser actualResult = authenticator.login(libraryNumberOne, passwordOne);
        AbstractUser expectedResult = customerOne;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnNullUserWhenUserIsNotAuthenticated() throws Exception {
        String incorrectLibraryNumber = "2314214";
        String incorrectPassword = "Hello!";
        AbstractUser actualResult = authenticator.login(incorrectLibraryNumber, incorrectPassword);
        AbstractUser expectedResult = nullUser;

        assertEquals(expectedResult, actualResult);
    }
}