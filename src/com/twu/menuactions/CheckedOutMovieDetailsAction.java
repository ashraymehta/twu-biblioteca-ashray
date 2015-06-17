package com.twu.menuactions;

import com.twu.Library;
import com.twu.user.AbstractUser;
import com.twu.views.MoviesView;

public class CheckedOutMovieDetailsAction implements MenuAction {
    private final MoviesView moviesView;
    private final Library library;

    public CheckedOutMovieDetailsAction(MoviesView moviesView, Library library) {
        this.moviesView = moviesView;
        this.library = library;
    }

    @Override
    public void perform(AbstractUser user) {
        library.getCheckedOutMovies();
        moviesView.printListOfMovies();
    }
}
