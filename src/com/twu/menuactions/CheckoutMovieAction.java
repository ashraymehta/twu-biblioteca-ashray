package com.twu.menuactions;

import com.twu.Library;
import com.twu.movies.Movie;
import com.twu.views.CheckoutMovieView;

// Invokes printing of movies, checkoutMovie of books and print successful or unsuccessful messages
public class CheckoutMovieAction implements MenuAction {

    private CheckoutMovieView checkoutMovieView;
    private Library library;

    public CheckoutMovieAction(CheckoutMovieView checkoutMovieView, Library library) {
        this.checkoutMovieView = checkoutMovieView;
        this.library = library;
    }

    @Override
    public void perform() {
        String movieName = checkoutMovieView.getMovieName();
        Movie matchingMovie = library.searchMovie(movieName);
        matchingMovie = library.checkoutMovie(matchingMovie);
        checkoutMovieView.printMessage(matchingMovie.getAppropriateCheckoutMessage());
    }
}