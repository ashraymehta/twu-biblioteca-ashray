package com.twu.menuaction;

import com.twu.Library;
import com.twu.view.ReturnMovieView;

// Invokes printing of movies, return of movie and print successful or unsuccessful messages
public class ReturnMovieAction implements MenuAction {
    private ReturnMovieView returnBookView;
    private Library library;

    public ReturnMovieAction(ReturnMovieView returnMovieView, Library library) {
        this.returnBookView = returnMovieView;
        this.library = library;
    }

    @Override
    public void perform() {

    }
}
