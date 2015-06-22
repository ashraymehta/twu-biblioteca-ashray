package com.twu.menuactions;

import com.twu.Library;
import com.twu.Messages;
import com.twu.books.Book;
import com.twu.user.AbstractUser;
import com.twu.views.ReturnBookView;

// Invokes printing of books, return of books and print successful or unsuccessful messages
public class ReturnBookAction implements MenuAction {
    private ReturnBookView returnBookView;
    private Library library;

    public ReturnBookAction(ReturnBookView returnBookView, Library library) {
        this.returnBookView = returnBookView;
        this.library = library;
    }

    @Override
    public MenuAction perform(AbstractUser user) {
        returnBookView.printMessage(Messages.ENTER_BOOK_TITLE);
        String bookTitle = returnBookView.getBookTitle();
        Book toBeReturned = library.searchBook(bookTitle);
        Book returnedBook = library.returnBook(toBeReturned);
        String appropriateCheckoutMessage = returnedBook.getAppropriateReturnMessage();
        returnBookView.printMessage(appropriateCheckoutMessage);
        return this;
    }
}
