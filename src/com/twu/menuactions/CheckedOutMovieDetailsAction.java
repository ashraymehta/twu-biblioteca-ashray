package com.twu.menuactions;

import com.twu.Library;
import com.twu.movies.Movie;
import com.twu.user.AbstractUser;
import com.twu.views.CheckedOutMovieDetailsView;

public class CheckedOutMovieDetailsAction implements MenuAction {
    private CheckedOutMovieDetailsView checkedOutMovieDetailsView;
    private Library library;

    public CheckedOutMovieDetailsAction(CheckedOutMovieDetailsView checkedOutMovieDetailsView, Library library) {
        this.checkedOutMovieDetailsView = checkedOutMovieDetailsView;
        this.library = library;
    }

    @Override
    public MenuAction perform(AbstractUser user) {
        String title = checkedOutMovieDetailsView.getUserInput();
        Movie movie = library.searchCheckedOutMovie(title);
        checkedOutMovieDetailsView.printMovieDetails(movie);
        return this;
    }
}
