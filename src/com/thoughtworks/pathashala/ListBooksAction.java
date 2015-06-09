package com.thoughtworks.pathashala;

public class ListBooksAction implements MenuAction{

    private final BooksView booksView;

    public ListBooksAction(BooksView booksView) {
        this.booksView = booksView;
    }

    @Override
    public void perform() {
        booksView.printListOfBooks();
    }
}
