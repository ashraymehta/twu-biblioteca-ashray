package com.twu.menuactions;

import com.twu.Library;
import com.twu.user.AbstractUser;
import com.twu.views.MoviesView;

// Invokes the printing of list of movies
public class ListAvailableMoviesAction implements MenuAction {

    private final MoviesView moviesView;
    private final Library library;

    public ListAvailableMoviesAction(MoviesView moviesView, Library library) {
        this.moviesView = moviesView;
        this.library = library;
    }

    @Override
    public MenuAction perform(AbstractUser user) {
        library.getAvailableMovies();
        moviesView.printListOfMovies();
        return this;
    }
}
