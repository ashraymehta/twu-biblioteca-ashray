package com.thoughtworks.pathashala;

public class ListBooksAction implements MenuAction{
    @Override
    public void perform() {
        Books books = new Books();
        ConsoleOut consoleOut = new ConsoleOut();
        consoleOut.printListOfBooks(books);
    }
}
