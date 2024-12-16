package app.movieList.mappers;

import app.movieList.model.MovieType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieTypeRowMapper implements RowMapper<MovieType> {
    @Override
    public MovieType mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new MovieType(
                rs.getInt("mt_id"),
                rs.getString("mt_name")
        );
    }
}
