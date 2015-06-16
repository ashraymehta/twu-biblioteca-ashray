package com.twu;

import com.twu.movie.AvailableMovie;
import com.twu.movie.Movie;
import com.twu.movie.NullMovie;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

public class MovieSearcherTest {

    private Movie nullMovie;

    @Before
    public void setUp() throws Exception {
        nullMovie = new NullMovie();
    }

    @Test
    public void shouldSearchForNameInListOfBooksAndGetTheMovieWhenFound() throws Exception {
        Set<Movie> movies = new HashSet<>();
        AvailableMovie availableMovieOne = new AvailableMovie("Name 1", "Director 1", 1000, 9);
        AvailableMovie availableMovieTwo = new AvailableMovie("Name 2", "Director 2", 500, 9);
        movies.add(availableMovieOne);
        movies.add(availableMovieTwo);
        MovieSearcher movieSearcher = new MovieSearcher(nullMovie);

        Movie actualResult = movieSearcher.search(movies, "Name 1");
        Movie expectedResult = availableMovieOne;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldSearchForNameInListOfBooksAndGetNullMovieWhenNotFound() throws Exception {
        Set<Movie> movies = new HashSet<>();
        AvailableMovie availableMovieOne = new AvailableMovie("Name 1", "Director 1", 1000, 9);
        AvailableMovie availableMovieTwo = new AvailableMovie("Name 2", "Director 2", 500, 9);
        movies.add(availableMovieOne);
        movies.add(availableMovieTwo);
        MovieSearcher movieSearcher = new MovieSearcher(nullMovie);

        Movie actualResult = movieSearcher.search(movies, "Name 4");
        Movie expectedResult = nullMovie;

        assertEquals(expectedResult, actualResult);
    }
}