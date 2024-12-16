package app.movieList.api.model;

public class ExternalId {
    private final String kpHD;
    private final String imdb;
    private final String tmdb;

    public ExternalId(String kpHD, String imdb, String tmdb) {
        this.kpHD = kpHD;
        this.imdb = imdb;
        this.tmdb = tmdb;
    }

    public String getKpHD() {
        return kpHD;
    }

    public String getImdb() {
        return imdb;
    }

    public String getTmdb() {
        return tmdb;
    }

    @Override
    public String toString() {
        return "ExternalId{" +
                "kpHD='" + kpHD + '\'' +
                ", imdb='" + imdb + '\'' +
                ", tmdb='" + tmdb + '\'' +
                '}';
    }
}
