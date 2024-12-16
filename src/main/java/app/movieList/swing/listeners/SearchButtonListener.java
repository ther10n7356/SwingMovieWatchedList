package app.movieList.swing.listeners;

import app.movieList.api.model.ItemName;
import app.movieList.api.model.MovieDoc;
import app.movieList.api.model.SearchDocs;
import app.movieList.controller.MovieController;
import app.movieList.model.MovieInfo;
import app.movieList.swing.button.ButtonColumn;
import app.movieList.swing.button.SaveButton;
import app.movieList.swing.editor.ButtonEditor;
import app.movieList.swing.model.JResultTableModel;
import app.movieList.swing.render.ButtonRender;
import app.movieList.swing.windows.AddWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchButtonListener implements ActionListener {

    private final AddWindow addWindow;
    private final MovieController controller;

    public SearchButtonListener(AddWindow addWindow, MovieController controller) {
        this.addWindow = addWindow;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SearchDocs docs = null;
        List<MovieDoc> findingDocs = new ArrayList<>();
        try {
            docs = controller.findAllByName(addWindow.getTextField(), 1);

            int countPage = 0;

            while (countPage < docs.getPages()) {
                List<MovieDoc> result = docs.getDocs()
                        .stream()
                        .filter(d -> d.getName().equalsIgnoreCase(addWindow.getTextField())
                                && (d.getType().equals(addWindow.getBoxTypes().getSelectedItem())
                                || addWindow.getBoxTypes().getSelectedItem().equals(""))
                                && (addWindow.getYearField() == -1
                                || d.getYear() == addWindow.getYearField())
                        )
                        .collect(Collectors.toList());

                if (result.size() > 0) {
                    findingDocs.addAll(result);
                    break;
                }

                docs = controller.findAllByName(addWindow.getTextField(), countPage + 1);
                countPage++;
                break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Object[][] movies = new Object[findingDocs.size()][addWindow.getHeaders().length];
        for (int i = 0; i < findingDocs.size(); i++) {
            MovieDoc doc = findingDocs.get(i);
            movies[i][0] = doc.getId();
            movies[i][1] = doc.getName();
            movies[i][2] = doc.getType();
            movies[i][3] = doc.getYear();
            movies[i][4] = doc.getDescription();
            movies[i][5] = doc.getGenres().stream().map(ItemName::getName).collect(Collectors.joining(","));
            movies[i][6] = doc.getRating().getKp();
        }

        addWindow.getTable().setModel(new JResultTableModel(movies, addWindow.getHeaders()));
        TableColumnModel columnModel = addWindow.getTable().getColumnModel();
        columnModel.getColumn(
                addWindow.getHeaders().length-1).setCellRenderer(new ButtonRender("Save")
        );
        columnModel.getColumn(
                addWindow.getHeaders().length-1).setCellEditor(
                        new ButtonEditor(new SaveButtonListener(
                                controller,
                                addWindow
                        ), "Save")
        );
        addWindow.getTable().repaint();
    }
}
