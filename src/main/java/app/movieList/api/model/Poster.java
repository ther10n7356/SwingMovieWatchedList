package app.movieList.api.model;

public class Poster extends Logo {

    private final String previewUrl;

    public Poster(String url, String previewUrl) {
        super(url);
        this.previewUrl = previewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    @Override
    public String toString() {
        return "Poster{" +
                "previewUrl='" + previewUrl + '\'' +
                '}';
    }
}
