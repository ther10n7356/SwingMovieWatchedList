package app.movieList.api.model;

public class Logo {

    private final String url;

    public Logo(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Logo{" +
                "url='" + url + '\'' +
                '}';
    }
}
