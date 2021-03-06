package com.twu.menuactions;

import com.twu.Library;
import com.twu.Messages;
import com.twu.movies.Movie;
import com.twu.user.AbstractUser;
import com.twu.views.CheckedOutMovieDetailsView;

// Accepts a movie name from user and invokes search for a corresponding checked out movie
public class CheckedOutMovieDetailsAction implements MenuAction {
    private CheckedOutMovieDetailsView checkedOutMovieDetailsView;
    private Library library;

    public CheckedOutMovieDetailsAction(CheckedOutMovieDetailsView checkedOutMovieDetailsView, Library library) {
        this.checkedOutMovieDetailsView = checkedOutMovieDetailsView;
        this.library = library;
    }

    @Override
    public MenuAction perform(AbstractUser user) {
        checkedOutMovieDetailsView.printMessage(Messages.ENTER_MOVIE_NAME);
        String title = checkedOutMovieDetailsView.getUserInput();
        Movie movie = library.searchCheckedOutMovie(title);
        checkedOutMovieDetailsView.printMovieDetails(movie);
        return this;
    }
}
