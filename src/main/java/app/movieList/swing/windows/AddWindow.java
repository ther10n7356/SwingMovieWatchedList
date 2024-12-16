package app.movieList.swing.windows;

import app.movieList.controller.MovieController;
import app.movieList.dao.MovieDao;
import app.movieList.swing.listeners.SearchButtonListener;
import app.movieList.swing.listeners.ShowInfoListener;
import app.movieList.swing.render.SearchResultTableRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

@Controller
@Scope("prototype")
public class AddWindow extends AbstractFrameWindow {

    private final MovieController controller;
    private JTextField textField;
    private JTextField yearField;
    private JComboBox boxTypes;
    private final String[] headers = {
            "Movie Id",
            "Movie Name",
            "Movie Type",
            "Movie year",
            "Description",
            "Genres",
            "KP rating",
            "Save"
    };

    @Autowired
    public AddWindow(MovieDao movieDao, MovieController controller) throws HeadlessException {
        super(movieDao, "Add new movie", 1200, 1200);
        this.controller = controller;
        this.textField = new JTextField();
        this.yearField = new JTextField();
    }

    @Override
    public void initFields() {
        super.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        JPanel searchPanel = new JPanel();
        JPanel namePanel = new JPanel();

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Название фильма:");
        textField.setColumns(20);
        namePanel.add(nameLabel);
        namePanel.add(textField);

        JPanel typePanel =  new JPanel();
        JLabel typeLabel = new JLabel();
        typeLabel.setText("Тип:  ");
        boxTypes = new JComboBox(controller.getMovieTypes());
        boxTypes.addItem("");
        boxTypes.setSelectedItem("");
        typePanel.add(typeLabel);
        typePanel.add(boxTypes);

        JPanel yearPanel = new JPanel();
        JLabel yearLabel = new JLabel();
        yearLabel.setText("Год:");
        yearField.setColumns(10);
        yearPanel.add(yearLabel);
        yearPanel.add(yearField);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(
                new SearchButtonListener(this, controller)
        );

        JPanel fieldPanel = new JPanel();
        fieldPanel.add(namePanel);
        fieldPanel.add(typePanel);
        fieldPanel.add(yearPanel);
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
        searchPanel.add(fieldPanel, BorderLayout.WEST);
        searchPanel.add(searchButton, BorderLayout.EAST);
        super.setPanelBorder(searchPanel); 

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(searchPanel);
        mainPanel.add(initTablePanel());
        this.getContentPane().add(mainPanel, BorderLayout.LINE_START);
    }

    @Override
    public void initDefaultTable() {
        super.initDefaultTable();
        TableCellRenderer tableRenderer = getTable().getDefaultRenderer(JButton.class);
        getTable().setDefaultRenderer(JButton.class, new SearchResultTableRender(tableRenderer));
        getTable().setCellSelectionEnabled(true);
        getTable().addMouseListener(new ShowInfoListener(this));
        getTable().setPreferredScrollableViewportSize(new Dimension(1200, 1200));
    }

    public String getTextField() {
        return textField.getText();
    }

    public JComboBox getBoxTypes() {
        return boxTypes;
    }

    public int getYearField() {
        try {
            return Integer.parseInt(yearField.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String[] getHeaders() {
        return headers;
    }

    public void clearTextFields() {
        textField.setText("");
        yearField.setText("");
    }
}
