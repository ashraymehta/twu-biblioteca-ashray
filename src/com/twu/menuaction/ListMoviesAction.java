package com.twu.menuaction;

import com.twu.Library;
import com.twu.view.MoviesView;

// Invokes the printing of list of movies
public class ListMoviesAction implements MenuAction {

    private final MoviesView moviesView;
    private final Library library;

    public ListMoviesAction(MoviesView moviesView, Library library) {
        this.moviesView = moviesView;
        this.library = library;
    }

    @Override
    public void perform() {
        library.getAvailableMovies();
        moviesView.printListOfMovies();
    }
}
