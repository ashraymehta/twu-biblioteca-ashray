package com.twu;

public class ReturnBookAction implements MenuAction {
    private ReturnBookView returnBookView;
    private Library library;

    public ReturnBookAction(ReturnBookView returnBookView, Library library) {
        this.returnBookView = returnBookView;
        this.library = library;
    }

    @Override
    public void perform() {
        returnBookView.printListOfBooks();
        int selection = returnBookView.getSelection();
        boolean isBookReturned = library.returnBook(selection - 1);
        if(isBookReturned)
            returnBookView.printSuccessfulReturnMessage();
        returnBookView.printUnsuccessfulReturnMessage();
    }
}
