package com.twu.book;

import java.util.List;

public class AvailableBook extends Book {
    public AvailableBook(String title, String author, int yearPublished, int id) {
        super(title, author, yearPublished, id);
    }

    @Override
    public void addToListIfAvailable(List<AvailableBook> availableList) {
        availableList.add(this);
    }
}
