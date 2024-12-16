package app.movieList.http;

import app.movieList.api.model.SearchDocs;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class HttpSender {

    @Value("${api.token}")
    private String tokenValue;

    public String send(String url) throws URISyntaxException, IOException, InterruptedException {
//        System.out.println(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("accept", "application/json")
                .header("X-API-KEY", tokenValue)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
