package com.twu.menuaction;

import com.twu.view.MoviesView;

// Invokes the printing of list of movies
public class ListMoviesAction implements MenuAction {

    private final MoviesView moviesView;

    public ListMoviesAction(MoviesView moviesView) {
        this.moviesView = moviesView;
    }

    @Override
    public void perform() {
        moviesView.printListOfMovies();
    }
}
