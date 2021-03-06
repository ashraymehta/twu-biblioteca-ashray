package com.twu.menuactions;

import com.twu.Library;
import com.twu.Messages;
import com.twu.movies.Movie;
import com.twu.user.AbstractUser;
import com.twu.views.ReturnMovieView;

// Invokes printing of movies, return of movies and print successful or unsuccessful messages
public class ReturnMovieAction implements MenuAction {
    private ReturnMovieView returnBookView;
    private Library library;

    public ReturnMovieAction(ReturnMovieView returnMovieView, Library library) {
        this.returnBookView = returnMovieView;
        this.library = library;
    }

    @Override
    public MenuAction perform(AbstractUser user) {
        returnBookView.printMessage(Messages.ENTER_MOVIE_NAME);
        String movieName = returnBookView.getMovieName();
        Movie toBeReturned = library.searchMovie(movieName);
        Movie returnedMovie = library.returnMovie(toBeReturned);
        String appropriateCheckoutMessage = returnedMovie.getAppropriateReturnMessage();
        returnBookView.printMessage(appropriateCheckoutMessage);
        return this;
    }
}
