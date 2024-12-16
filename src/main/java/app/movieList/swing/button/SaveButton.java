package app.movieList.swing.button;

import app.movieList.api.model.MovieDoc;
import app.movieList.controller.MovieController;
import app.movieList.swing.listeners.TableButtonListener;
import app.movieList.swing.windows.AddWindow;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.Vector;

public class SaveButton extends JButton implements TableCellEditor, TableCellRenderer {

    private final int movieId;
    private final MovieController controller;
    private final AddWindow window;
    private int selectedRow;
    private int selectedColumn;
    private Vector<TableButtonListener> listeners;

    public SaveButton(int movieId, MovieController controller, AddWindow window) {
        super("Save");
        this.movieId = movieId;
        this.controller = controller;
        this.window = window;
        this.listeners = new Vector<>();
        addActionListener(e -> {
            for (TableButtonListener listener: listeners) {
                listener.tableButtonClicked(selectedRow, selectedColumn);
            }
        });
    }

    public void addTableButtonListener(TableButtonListener listener) {
        this.listeners.add(listener);
    }

    public void removeTableButtonListener(TableButtonListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return this;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        return true;
    }

    @Override
    public void cancelCellEditing() {

    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {

    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.selectedRow = row;
        this.selectedColumn = column;
        return this;
    }
}
