package app.movieList.dao;

import app.movieList.api.model.MovieDoc;
import app.movieList.mappers.MovieInfoRowMapper;
import app.movieList.mappers.MovieTypeRowMapper;
import app.movieList.model.MovieInfo;
import app.movieList.model.MovieType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieDaoImpl implements MovieDao {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private final String SQL_GET_MOVIE_LIST = "select\n" +
            "\tml.movie_id,\n" +
            "\ttrim(ml.movie_name) movie_name,\n" +
            "\ttrim(ml.movie_type) movie_type,\n" +
            "\ttrim(mp.other_name) other_name,\n" +
            "\tmp.movie_year,\n" +
            "\tmp.description,\n" +
            "\tmp.poster_url,\n" +
            "\tmp.movie_length,\n" +
            "\tmp.kp_raiting,\n" +
            "\tmp.genres,\n" +
            "\tml.is_watched\n" +
            "from\n" +
            "\tmovie_list ml\n" +
             "join movie_properties mp on\n" +
            "\tmp.movie_id = ml.movie_id\n" +
            "join movie_types mt on\n" +
            "\tmt.mt_name = ml.movie_type\n"+
            "where (:type_id = 0 or mt.mt_id = :type_id)\n" +
            "\t and (:is_watched = 0 or ml.is_watched = :is_watched)";
    private final String SQL_SELECT_MOVIE_TYPES = "select mt_id, mt_name from movie_types";
    private final String SQL_UPDATE_WATCHED_STATE = "update movie_list set is_watched = :is_watched where movie_id = :movie_id";
    private final String WHERE_MOVIE_ID = "\nand ml.movie_id = :movieId";
    private final String WHERE_TYPE_ID = "\nwhere mt_id = :type_id";

    @Autowired
    public MovieDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void add(MovieDoc doc) {
        jdbcTemplate.execute("call movie_add_proc (\n" +
                        "i_movie_id => :movie_id,\n" +
                        "i_movie_name => :movie_name,\n" +
                        "i_movie_type => :movie_type,\n" +
                        "i_other_name => :other_name,\n" +
                        "i_movie_year => :movie_year,\n" +
                        "i_description => cast(:description as text),\n" +
                        "i_movie_length => :movie_length,\n" +
                        "i_poster_url => :poster_url,\n" +
                        "i_kp_raiting => :kp_raiting,\n" +
                        "i_genres => :genres)",
                new HashMap<>(Map.of(
                        "movie_id", doc.getId(),
                        "movie_name", doc.getName(),
                        "movie_type", doc.getType(),
                        "other_name", doc.getAlternativeName(),
                        "movie_year", doc.getYear(),
                        "description", doc.getDescription(),
                        "movie_length", doc.getMovieLength(),
                        "poster_url", doc.getPoster().getUrl(),
                        "kp_raiting", doc.getRating().getKp(),
                        "genres", doc.getGenres().get(0).getName()
                )),
                PreparedStatement::execute);
    }

    @Override
    public List<MovieInfo> getSavedMovies(int index, boolean isShowWatched) {
        return jdbcTemplate.query(
                SQL_GET_MOVIE_LIST,
                Map.of(
                        "type_id", index,
                        "is_watched", (isShowWatched) ? 1:0
                ),
                new MovieInfoRowMapper()
                );
    }

    @Override
    public List<MovieType> getMovieTypes() {
        return jdbcTemplate.query(
                SQL_SELECT_MOVIE_TYPES,
                new HashMap<>(0),
                new MovieTypeRowMapper()
        );
    }

    @Override
    public MovieType getMovieType(int typeId) {
        return jdbcTemplate.queryForObject(
                SQL_SELECT_MOVIE_TYPES + WHERE_TYPE_ID,
                Map.of("type_id", typeId),
                new MovieTypeRowMapper()
        );
    }

    @Override
    public MovieInfo getMovieInfo(int movieId) {
        return jdbcTemplate.queryForObject(
                SQL_GET_MOVIE_LIST + WHERE_MOVIE_ID,
                Map.of(
                        "movieId", movieId,
                        "type_id", 0
                ),
                new MovieInfoRowMapper()
        );
    }

    @Override
    public void updateWatchedState(boolean value, int movieId) {
        jdbcTemplate.update(
                SQL_UPDATE_WATCHED_STATE,
                Map.of(
                        "is_watched", (value) ? 1:0,
                        "movie_id", movieId
                )
        );
    }
}
