package com.twu.menuaction;

import com.twu.CheckoutBookView;
import com.twu.Library;
import com.twu.Searcher;
import com.twu.book.AvailableBook;
import com.twu.book.Book;

// Invokes printing of books, checkout of book and print successful or unsuccessful messages
public class CheckoutBookAction implements MenuAction {

    private CheckoutBookView checkoutBookView;
    private Library library;
    private Searcher searcher;

    public CheckoutBookAction(CheckoutBookView checkoutBookView, Library library, Searcher searcher) {
        this.checkoutBookView = checkoutBookView;
        this.library = library;
        this.searcher = searcher;
    }

    @Override
    public void perform() {
        checkoutBookView.printListOfBooks();
        String bookTitle = checkoutBookView.getBookTitle();
        library.getAvailableBooks();
        Book matchingBook = searcher.search(bookTitle);
        library.checkoutBook((AvailableBook) matchingBook);
        if (matchingBook != null) {
            checkoutBookView.printSuccessfulCheckoutMessage();
        } else {
            checkoutBookView.printUnsuccessfulCheckoutMessage();
        }
    }
}
