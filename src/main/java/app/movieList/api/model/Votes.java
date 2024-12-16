package app.movieList.api.model;

public class Votes extends Rating {

    public Votes(int kp, int imdb, int tmdb, int filmCritics, int russianFilmCritics, int await) {
        super(kp, imdb, tmdb, filmCritics, russianFilmCritics, await);
    }

    @Override
    public String toString() {
        return "Votes{" +
                "kp=" + getKp() +
                ", imdb=" + getImdb() +
                ", tmdb=" + getTmdb() +
                ", filmCritics=" + getFilmCritics() +
                ", russianFilmCritics=" + getRussianFilmCritics() +
                ", await=" + getAwait() +
                '}';
    }
}
