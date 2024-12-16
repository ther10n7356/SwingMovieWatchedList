package app.movieList.swing.windows;

import app.movieList.controller.MovieController;
import app.movieList.dao.MovieDao;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public abstract class AbstractFrameWindow extends JFrame {

    private final MovieDao movieDao;
    private final int width;
    private final int height;
    private final String textTitle;
    private final JTable table;

    protected AbstractFrameWindow(MovieDao movieDao, String textTitle, int width, int height) {
        this.movieDao = movieDao;
        this.width = width;
        this.height = height;
        this.textTitle = textTitle;
        this.table = new JTable();
    }

    public void init() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.setPreferredSize(new Dimension(width, height));
        this.setTitle(textTitle);
        this.setVisible(true);
        initFields(); 
    }

    public JPanel initTablePanel() {
        JPanel tablePanel = new JPanel();
        initDefaultTable();
        tablePanel.add(new JScrollPane(table));
        return tablePanel;
    }

    public void initDefaultTable() {
        String[][] records = {{""}};


        table.setModel(new DefaultTableModel(records, getHeaders()));
    }

    public MovieDao getMovieDao() {
        return movieDao;
    }

    public abstract void initFields();

    public JTable getTable() {
        return table;
    }

    public abstract String[] getHeaders();

    public void setPanelBorder(JPanel panel) {
        panel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(), "Menu",
                        TitledBorder.CENTER,
                        TitledBorder.TOP
                )
        );
    }
}
