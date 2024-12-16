package app.movieList.utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class RequestUtil {

    public static String getUrlEncode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }
}
