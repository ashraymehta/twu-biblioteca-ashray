package com.twu.menuactions;

import com.twu.Library;
import com.twu.Messages;
import com.twu.movies.Movie;
import com.twu.user.AbstractUser;
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
    public MenuAction perform(AbstractUser user) {
        checkoutMovieView.printMessage(Messages.ENTER_MOVIE_NAME);
        String movieName = checkoutMovieView.getMovieName();
        Movie matchingMovie = library.searchMovie(movieName);
        matchingMovie = library.checkoutMovie(matchingMovie, user);
        checkoutMovieView.printMessage(matchingMovie.getAppropriateCheckoutMessage());
        return this;
    }
}