package com.twu.movie;

import com.twu.Messages;

import java.util.ArrayList;

public class NullMovie extends Movie {
    public NullMovie() {
        super("", "", 0, 0);
    }

    @Override
    public Movie checkout() {
        return this;
    }

    @Override
    public String getAppropriateCheckoutMessage() {
        return Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE;
    }

    @Override
    public void addToListIfNameMatches(ArrayList<Movie> matchingList, String nameToMatch) {

    }
}
