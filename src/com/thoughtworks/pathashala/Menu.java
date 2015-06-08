package com.thoughtworks.pathashala;

import java.util.ArrayList;

public class Menu {

    private ArrayList<String> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();
        menuItems.add("List books");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < menuItems.size(); i++) {
            int menuSerialNumber = i + 1;
            stringBuilder.append(menuSerialNumber).append(". ");
            stringBuilder.append(menuItems.get(i));
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
