package app.movieList.swing.editor;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.EventObject;

public class JCheckboxTableEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    private final JCheckBox checkBox;

    public JCheckboxTableEditor(ItemListener itemListener) {
        this.checkBox = new JCheckBox();
        checkBox.addItemListener(itemListener);
    }

    @Override
    public Object getCellEditorValue() {
        return !checkBox.isSelected();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.stopCellEditing();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return checkBox;
    }
}
