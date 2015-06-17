package com.twu.user;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerTest {
    private Customer customer;
    private Customer firstCustomer;
    private Customer secondCustomer;
    private Customer thirdCustomer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("123-4567", "Password");
        firstCustomer = new Customer("123-4567", "Password");
        secondCustomer = new Customer("123-4567", "Password");
        thirdCustomer = new Customer("123-4567", "Password");
    }

    @Test
    public void shouldRepresentCustomerAsString() throws Exception {
        String actualString = customer.toString();
        String expectedString = "123-4567  ";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldAddToListIfCredentialsMatch() throws Exception {
        List<AbstractUser> list = new ArrayList<AbstractUser>();
        customer.addToListIfCredentialsMatch("123-4567", "Password", list);

        assertTrue(list.contains(customer));
    }

    @Test
    public void shouldBeEqualToItself() {

        boolean actual = firstCustomer.equals(firstCustomer);

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowSymmetricProperty() {

        boolean actual = (firstCustomer.equals(secondCustomer) == secondCustomer.equals(firstCustomer));

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        boolean actual = firstCustomer.equals(secondCustomer) &&
                secondCustomer.equals(thirdCustomer) &&
                firstCustomer.equals(thirdCustomer);

        assertEquals(true, actual);
    }

    @Test
    public void shouldHaveSameHashCodeIfCustomersAreEqual() {
        boolean actual = firstCustomer.equals(secondCustomer) && (firstCustomer.hashCode() == secondCustomer.hashCode());

        assertEquals(true, actual);
    }
}