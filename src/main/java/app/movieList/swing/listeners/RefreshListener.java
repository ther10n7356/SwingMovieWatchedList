package app.movieList.swing.listeners;

import app.movieList.dao.MovieDao;
import app.movieList.model.MovieInfo;
import app.movieList.swing.editor.JCheckboxTableEditor;
import app.movieList.swing.windows.MainWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.List;

public class RefreshListener implements ActionListener {

    private final MainWindow window;
    private final MovieDao movieDao;
    private int LAST_SELECTED_COLUMN = -1;

    public RefreshListener(MainWindow window, MovieDao movieDao) {
        this.window = window;
        this.movieDao = movieDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = window.getTabbedPane().getSelectedIndex();
        List<MovieInfo> savedMovies = movieDao.getSavedMovies(index, window.getCheckBoxValue());
        Object[][] movies = new Object[savedMovies.size()][window.getHeaders().length];
        for (int i = 0; i < savedMovies.size(); i++) {
            MovieInfo info = savedMovies.get(i);
            movies[i][0] = info.getMovieId();
            movies[i][1] = info.getMovieName();
            movies[i][2] = info.getMovieType();
            movies[i][3] = info.getMovieYear();
            movies[i][4] = info.getDescription();
            movies[i][5] = info.getGenres();
            movies[i][6] = info.getKpRating();
            movies[i][7] = info.isWatched();
        }

        JTable table = new JTable(
                new DefaultTableModel(movies, window.getHeaders())
        );
        table.addMouseListener(new ShowInfoListener(window));
        TableColumn booleanColumn = table.getColumnModel().getColumn(7);
        booleanColumn.setCellEditor(table.getDefaultEditor(Boolean.class));
        booleanColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
//        JCheckBox checkBox = new JCheckBox();
////        checkBox.setRolloverEnabled(false);
//        checkBox.addItemListener(e1 -> {
//            JCheckBox cb = (JCheckBox) e1.getSource();
//            if (cb.isSelected()) {
//                int row = table.getSelectedRow();
//                int column = table.getSelectedColumn();
//                if (column != -1) {
//                    boolean selected = (boolean) table.getModel().getValueAt(row, column);
//                    int movieId = (int) table.getModel().getValueAt(row, 0);
//                    System.out.println("Checkbox in row " + row + " for movie id " + movieId + " is " + (selected ? "not selected" : "selected"));
//                    movieDao.updateWatchedState(selected, movieId);
//                    LAST_SELECTED_COLUMN = column;
//                }
//            }
//        });
//        checkBox.setSelected(true);
//        booleanColumn.setCellEditor(new DefaultCellEditor(checkBox));

        ItemListener itemListener = e1 -> {
            JCheckBox cb = (JCheckBox) e1.getSource();
            int row = table.getSelectedRow();
            int column = table.getSelectedColumn();
            if (column != -1) {
                boolean selected = (boolean) table.getModel().getValueAt(row, column);
                int movieId = (int) table.getModel().getValueAt(row, 0);
                System.out.println("Checkbox in row " + row + " for movie id " + movieId + " is " + (selected ? "not selected" : "selected"));
                movieDao.updateWatchedState(!selected, movieId);
                table.getModel().setValueAt(!selected, row, column);
//                cb.setSelected(!selected);
            }
        };

        booleanColumn.setCellEditor(new JCheckboxTableEditor(itemListener));

        window.getTabbedPane().setComponentAt(
                index,
                new JScrollPane(table)
        );
    }
}
