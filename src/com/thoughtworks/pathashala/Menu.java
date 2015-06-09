package com.thoughtworks.pathashala;

import java.util.HashMap;

public class Menu {

    private HashMap<Integer, MenuAction> menuItemsMappedToMenuAction;
    private HashMap<Integer, String> menuItemsMappedToSerials;

    public Menu(BooksView booksView) {
        menuItemsMappedToSerials = new HashMap<>();
        menuItemsMappedToMenuAction = new HashMap<>();
        menuItemsMappedToSerials.put(1, "List books");
        menuItemsMappedToMenuAction.put(1, new ListBooksAction(booksView));
    }

    public void performActionForInput(int userInput) {
        menuItemsMappedToMenuAction.get(userInput).perform();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= menuItemsMappedToSerials.size(); i++) {
            stringBuilder.append(i).append(". ");
            stringBuilder.append(menuItemsMappedToSerials.get(i));
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
