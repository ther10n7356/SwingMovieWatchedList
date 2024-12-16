package app.movieList.io;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@Component
public class CommonRequestInfo {
    @Value("${api.url}")
    private String requestUrl;
    @Value("${api.version}")
    private String version;
    @Value("${api.limit}")
    private int limitValues;

    public String getRequestUrl() {
        return requestUrl;
    }

    public String getVersion() {
        return version;
    }

    public int getLimitValues() {
        return limitValues;
    }
}
