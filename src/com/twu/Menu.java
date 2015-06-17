package com.twu;

import com.twu.menuactions.MenuAction;
import com.twu.user.AbstractUser;

import java.util.HashMap;

// Performs different actions based on user input on the main menu
public class Menu {

    private HashMap<Integer, MenuAction> menuItemsMappedToMenuAction;
    private HashMap<Integer, String> menuItemsMappedToSerials;

    public Menu(HashMap<Integer, MenuAction> menuItemsMappedToMenuAction, HashMap<Integer, String> menuItemsMappedToSerials) {
        this.menuItemsMappedToMenuAction = menuItemsMappedToMenuAction;
        this.menuItemsMappedToSerials = menuItemsMappedToSerials;
    }

    public MenuAction performActionForInput(AbstractUser user, int userInput) {
        MenuAction menuAction = menuItemsMappedToMenuAction.get(userInput);
        menuAction.perform(user);
        return menuAction;
    }

    public boolean hasActionAtPosition(int position) {
        return position > 0 && position <= menuItemsMappedToSerials.size();
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