package app.movieList.swing.listeners;

import app.movieList.api.model.MovieDoc;
import app.movieList.controller.MovieController;
import app.movieList.swing.windows.AddWindow;
import org.springframework.jdbc.UncategorizedSQLException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SaveButtonListener implements ActionListener {
    private final MovieController controller;
    private final AddWindow addWindow;

    public SaveButtonListener(MovieController controller, AddWindow addWindow) {
        this.controller = controller;
        this.addWindow = addWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                try {
                    JButton editorButton = (JButton) e.getSource();
                    int modelRow = Integer.parseInt(e.getActionCommand());
                    int movieId = (int) addWindow.getTable().getModel().getValueAt(modelRow, 0);
                    MovieDoc doc = controller.findById(movieId);
                    controller.addNewMovie(doc);
                    addWindow.dispose();
                } catch (UncategorizedSQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getSQLException().getLocalizedMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
    }
}