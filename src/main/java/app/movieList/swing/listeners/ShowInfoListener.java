package app.movieList.swing.listeners;

import app.movieList.api.model.MovieDoc;
import app.movieList.swing.windows.AbstractFrameWindow;
import app.movieList.swing.windows.AddWindow;
import app.movieList.swing.windows.MovieInfoWindow;
import org.springframework.jdbc.UncategorizedSQLException;

import javax.swing.*;
import java.awt.event.*;

public class ShowInfoListener extends MouseAdapter {
    private final AbstractFrameWindow window;

    public ShowInfoListener(AbstractFrameWindow window) {
        this.window = window;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getClickCount() == 2) {
            try {
                JTable table = (JTable) e.getSource();
                int row = table.rowAtPoint(e.getPoint());
//            int modelRow = Integer.parseInt(e.getActionCommand());
                int movieId = (int) table.getModel().getValueAt(row, 0);
                String name = (String) table.getModel().getValueAt(row, 1);
                SwingUtilities.invokeLater(() -> {
                    MovieInfoWindow infoWindow = new MovieInfoWindow(
                            window.getMovieDao(), name, movieId
                    );
                    infoWindow.init();
                    infoWindow.pack();
                });
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

    }
}
