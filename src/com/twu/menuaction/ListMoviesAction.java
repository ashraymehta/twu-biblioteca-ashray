package com.twu.menuaction;

import com.twu.view.MoviesView;

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
