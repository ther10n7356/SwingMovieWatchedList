package app.movieList.api.model;

public class Rating {
    private final double kp;
    private final double imdb;
    private final double tmdb;
    private final double filmCritics;
    private final double russianFilmCritics;
    private final double await;

    public Rating(double kp, double imdb, double tmdb, double filmCritics, double russianFilmCritics, double await) {
        this.kp = kp;
        this.imdb = imdb;
        this.tmdb = tmdb;
        this.filmCritics = filmCritics;
        this.russianFilmCritics = russianFilmCritics;
        this.await = await;
    }

    public double getKp() {
        return kp;
    }

    public double getImdb() {
        return imdb;
    }

    public double getTmdb() {
        return tmdb;
    }

    public double getFilmCritics() {
        return filmCritics;
    }

    public double getRussianFilmCritics() {
        return russianFilmCritics;
    }

    public double getAwait() {
        return await;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "kp=" + kp +
                ", imdb=" + imdb +
                ", tmdb=" + tmdb +
                ", filmCritics=" + filmCritics +
                ", russianFilmCritics=" + russianFilmCritics +
                ", await=" + await +
                '}';
    }
}
