package app.movieList.swing;

import app.movieList.swing.windows.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class SwingStarter {

    private final MainWindow window;

    @Autowired
    public SwingStarter(MainWindow window) {
        this.window = window;
    }

    @Bean
    public void run() {
        window.init();
        window.pack();
    }
}
