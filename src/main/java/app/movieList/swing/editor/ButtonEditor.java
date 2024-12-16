package app.movieList.swing.editor;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    private final JButton button;
    private boolean enabled;
    private int clickCountToStart;

    public ButtonEditor(ActionListener al, String columnName) {
        button = new JButton(columnName);
        button.addActionListener(al);
        enabled = true;
        clickCountToStart = 1;
    }

    public Component getTableCellEditorComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 int row, int column) {
//        String text = (String)value;
//        button.setText(text);
        button.setActionCommand(String.valueOf(row));
        button.setEnabled(enabled);
        return button;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Object getCellEditorValue() {
        return button.getText();
    }

    public boolean isCellEditable(EventObject anEvent) {
        if (anEvent instanceof MouseEvent) {
            return ((MouseEvent)anEvent).getClickCount() >= clickCountToStart;
        }
        return true;
    }

    public void actionPerformed(ActionEvent e) {
        super.stopCellEditing();
    }
}
