package app.movieList.io;

public class MovieRequest{
    private String url;
    private String version;
    private int movieId;

    public MovieRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public MovieRequest setVersion(String version) {
        this.version = version;
        return this;
    }

    public MovieRequest setMovieId(int movieId) {
        this.movieId = movieId;
        return this;
    }

    public String build() {
        return String.format(
                "%s/v%s/movie/%s",
                url,
                version,
                movieId
        );
    }
}
