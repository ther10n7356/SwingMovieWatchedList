package app.movieList.model;

public class MovieInfo {

    private final int movieId;
    private final String movieName;
    private final String movieType;
    private final String otherName;
    private final int movieYear;
    private final String description;
    private final String posterUrl;
    private final int movieLength;
    private final Double kpRating;
    private final String genres;
    private final boolean isWatched;

    public MovieInfo(int movieId, String movieName, String movieType, String otherName, int movieYear, String description, String posterUrl, int movieLength, Double kpRating, String genres, boolean isWatched) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieType = movieType;
        this.otherName = otherName;
        this.movieYear = movieYear;
        this.description = description;
        this.posterUrl = posterUrl;
        this.movieLength = movieLength;
        this.kpRating = kpRating;
        this.genres = genres;
        this.isWatched = isWatched;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public String getOtherName() {
        return otherName;
    }

    public String getDescription() {
        return description;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public Double getKpRating() {
        return kpRating;
    }

    public String getGenres() {
        return genres;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public boolean isWatched() {
        return isWatched;
    }
}
