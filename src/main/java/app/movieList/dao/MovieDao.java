package app.movieList.dao;

import app.movieList.api.model.MovieDoc;
import app.movieList.model.MovieInfo;
import app.movieList.model.MovieType;

import java.util.List;

public interface MovieDao {

    void add (MovieDoc doc);

    List<MovieInfo> getSavedMovies(int index, boolean isShowWatched);

    List<MovieType> getMovieTypes();

    MovieType getMovieType(int typeId);

    MovieInfo getMovieInfo(int movieId);

    void updateWatchedState(boolean value, int movieId);
}
