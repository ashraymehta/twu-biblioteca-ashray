package com.twu;

import com.twu.movie.AvailableMovie;
import com.twu.movie.Movie;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class MoviesTest {
    @Test
    public void shouldPresentDetailsOfAllMoviesAsString() throws Exception {
        ArrayList<Movie> movieArrayList = new ArrayList<>();
        movieArrayList.add(new AvailableMovie("Name", "Director", 2000, 5));
        movieArrayList.add(new AvailableMovie("Name", "Director", 2005, 10));
        Movies movies = new Movies(movieArrayList);

        String actualString = movies.toString();
        String expectedString = "Name                                              " +
                "Director                      " + "2000      " + "5    " + System.lineSeparator() +
                "Name                                              " +
                "Director                      " + "2005      " + "10   " + System.lineSeparator();

        assertEquals(expectedString, actualString);
    }

}