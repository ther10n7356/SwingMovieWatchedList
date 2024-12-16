package app.movieList.io;

import app.movieList.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieSearchRequestBuilder {
    private String url;
    private String version;
    private int pages;
    private int limitValues;
    private String query;

    public MovieSearchRequestBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public MovieSearchRequestBuilder setVersion(String version) {
        this.version = version;
        return this;
    }

    public MovieSearchRequestBuilder setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public MovieSearchRequestBuilder setLimit(int limitValues) {
        this.limitValues = limitValues;
        return this;
    }

    public MovieSearchRequestBuilder setQuery(String query) {
        this.query = RequestUtil.getUrlEncode(query);
        return this;
    }

    public String build() {
        return String.format(
                "%s/v%s/movie/search?page=%s&limit=%s&query=%s",
                url,
                version,
                pages,
                limitValues,
                query
                );
    }
}
