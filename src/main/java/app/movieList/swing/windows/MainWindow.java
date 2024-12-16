package app.movieList.swing.windows;

import app.movieList.controller.MovieController;
import app.movieList.dao.MovieDao;
import app.movieList.model.MovieType;
import app.movieList.swing.listeners.AddButtonListener;
import app.movieList.swing.listeners.RefreshListener;
import app.movieList.swing.listeners.ShowInfoListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.*;

@Controller
public class MainWindow extends AbstractFrameWindow {

    private final String[] headers = {
            "Movie Id",
            "Movie Name",
            "Movie Type",
            "Movie year",
            "Description",
            "Genres",
            "KP rating",
            "Watched"
    };
    private final AddWindow addWindow;
    private final JTabbedPane tabbedPane;
    private JCheckBox checkBox;

    @Autowired
    public MainWindow(MovieDao movieDao, AddWindow addWindow) {
        super(movieDao, "Watched list", 1200, 1200);
        this.addWindow = addWindow;
        this.tabbedPane = new JTabbedPane();
    }

    @Override
    public void initFields() {
        JPanel buttonPanel = new JPanel();

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(
                new RefreshListener(this, getMovieDao())
        );
        JButton addButton = new JButton("Add new");
        addButton.addActionListener(new AddButtonListener(addWindow));
        checkBox = new JCheckBox("Show only not watched");
        checkBox.setSelected(false);
        buttonPanel.add(refreshButton);
        buttonPanel.add(addButton);
        buttonPanel.add(checkBox);
        super.setPanelBorder(buttonPanel);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(buttonPanel);
//        mainPanel.add(initTablePanel());
        mainPanel.add(initTabs());
        this.getContentPane().add(mainPanel, BorderLayout.LINE_START);
    }

    @Override
    public void initDefaultTable() {
        super.initDefaultTable();
        super.getTable().addMouseListener(new ShowInfoListener(this));
    }

    public JTabbedPane initTabs() {
        tabbedPane.addTab("All", initTablePanel());
        for (MovieType type: super.getMovieDao().getMovieTypes()) {
            tabbedPane.addTab(type.getTypeName(), initTablePanel());
        }

        return tabbedPane;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public String[] getHeaders() {
        return headers;
    }

    public boolean getCheckBoxValue() {
        return checkBox.isSelected();
    }
}
