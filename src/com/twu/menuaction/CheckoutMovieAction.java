package com.twu.menuaction;

import com.twu.Library;
import com.twu.movie.Movie;
import com.twu.view.CheckoutMovieView;

// Invokes printing of movies, checkoutMovie of book and print successful or unsuccessful messages
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
        library.checkoutMovie(matchingMovie);
    }
}