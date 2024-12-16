package app.movieList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MovieListMain {

    public static void main(String[] args) {
//        SpringApplication.run(MovieListMain.class);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(MovieListMain.class);
        builder.headless(false);

        builder.run(args);
    }
}
