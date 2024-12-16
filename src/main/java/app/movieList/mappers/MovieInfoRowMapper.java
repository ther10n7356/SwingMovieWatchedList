package app.movieList.mappers;

import app.movieList.model.MovieInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieInfoRowMapper implements RowMapper<MovieInfo> {
    @Override
    public MovieInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new MovieInfo(
                rs.getInt("movie_id"),
                rs.getString("movie_name"),
                rs.getString("movie_type"),
                rs.getString("other_name"),
                rs.getInt("movie_year"),
                rs.getString("description"),
                rs.getString("poster_url"),
                rs.getInt("movie_length"),
                rs.getDouble("kp_raiting"),
                rs.getString("genres"),
                rs.getInt("is_watched") == 1
        );
    }
}
