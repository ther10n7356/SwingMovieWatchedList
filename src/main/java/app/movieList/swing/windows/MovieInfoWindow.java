package app.movieList.swing.windows;

import app.movieList.controller.MovieController;
import app.movieList.dao.MovieDao;
import app.movieList.model.MovieInfo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class MovieInfoWindow extends AbstractFrameWindow {
    private final int movieId;

    public MovieInfoWindow(MovieDao movieDao, String moveName, int movieId) {
        super(movieDao, moveName, 1200, 600);
        this.movieId = movieId;
    }

    @Override
    public void init() {
        super.init();
        super.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    @Override
    public void initFields() {
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
        MovieInfo info = getMovieDao().getMovieInfo(movieId);
        try {
            URL url = new URL(info.getPosterUrl());
            Image image = ImageIO.read(url);
            JLabel label = new JLabel(new ImageIcon(image));
            imagePanel.add(label, BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel infoPanel = new JPanel();
//        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
//        JLabel descLabel = new JLabel("Description:");
        JTextArea textArea = new JTextArea(info.getDescription());
        textArea.setColumns(40);
        textArea.setRows(5);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

//        infoPanel.add(descLabel);
        infoPanel.add(textArea);
        infoPanel.setSize(500, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(imagePanel);
        mainPanel.add(infoPanel);
        this.getContentPane().add(mainPanel);
    }

    @Override
    public String[] getHeaders() {
        return new String[0];
    }


}
