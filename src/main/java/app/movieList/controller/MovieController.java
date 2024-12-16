package app.movieList.controller;

import app.movieList.api.model.MovieDoc;
import app.movieList.api.model.SearchDocs;
import app.movieList.dao.MovieDao;
import app.movieList.http.HttpSender;
import app.movieList.io.CommonRequestInfo;
import app.movieList.io.MovieRequest;
import app.movieList.io.MovieSearchRequestBuilder;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Controller
public class MovieController {

    private final HttpSender sender;
    private final Gson gson;
    private final CommonRequestInfo commonRequest;
    private final MovieDao movieDao;

    @Autowired
    public MovieController(HttpSender sender, MovieDao movieDao, CommonRequestInfo commonRequest, MovieDao movieDao1) {
        this.sender = sender;
        this.commonRequest = commonRequest;
        this.movieDao = movieDao;
        this.gson = new Gson();
    }

    public SearchDocs findAllByName(String movieName, int page) throws InterruptedException, IOException, URISyntaxException {
        String request = new MovieSearchRequestBuilder()
                .setUrl(commonRequest.getRequestUrl())
                .setVersion(commonRequest.getVersion())
                .setPages(page)
                .setLimit(commonRequest.getLimitValues())
                .setQuery(movieName)
                .build();
        String result = sender.send(request);

        return gson.fromJson(result, SearchDocs.class);
    }

    public MovieDoc findById(int movieId) throws Exception {
        String request = new MovieRequest()
                .setUrl(commonRequest.getRequestUrl())
                .setVersion(commonRequest.getVersion())
                .setMovieId(movieId)
                .build();

        String result = sender.send(request);

        return gson.fromJson(result, MovieDoc.class);
    }

    public void addNewMovie(MovieDoc movieDoc) {
        movieDao.add(movieDoc);
    }

    public MovieDoc getMovieDocById(SearchDocs docs, int movieId) throws NoSuchElementException {
        return docs.getDocs().stream()
                .filter(d -> d.getId() == movieId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("Movie ID %s not found in page %s", movieId, docs.getPage())));
    }

    public List<MovieDoc> getMovieByFilter(List<MovieDoc> movies, String movieName, String movieType, int year) {
        return movies.stream()
                .filter(m -> m.getName().equals(movieName) && m.getType().equals(movieType) && m.getYear() == year)
                .collect(Collectors.toList());
    }

    public Object[] getMovieTypes() {
        return movieDao.getMovieTypes().stream().map(t -> t.getTypeName()).collect(Collectors.toList()).toArray();
    }

}
