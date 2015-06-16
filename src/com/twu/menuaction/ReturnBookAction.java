package com.twu.menuaction;

import com.twu.Library;
import com.twu.book.Book;
import com.twu.view.ReturnBookView;

// Invokes printing of books, return of book and print successful or unsuccessful messages
public class ReturnBookAction implements MenuAction {
    private ReturnBookView returnBookView;
    private Library library;

    public ReturnBookAction(ReturnBookView returnBookView, Library library) {
        this.returnBookView = returnBookView;
        this.library = library;
    }

    @Override
    public void perform() {
        String bookTitle = returnBookView.getBookTitle();
        Book toBeReturned = library.searchBook(bookTitle);
        Book returnedBook = library.returnBook(toBeReturned);
        String appropriateCheckoutMessage = returnedBook.getAppropriateReturnMessage();
        returnBookView.printMessage(appropriateCheckoutMessage);
    }
}
