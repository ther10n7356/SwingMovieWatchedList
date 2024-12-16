package app.movieList.swing.render;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ButtonRender implements TableCellRenderer {
    private final JButton button;
    private boolean enabled;

    public ButtonRender(String buttonName) {
        this.button = new JButton(buttonName);
        enabled = true;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        button.setEnabled(enabled);
        return button;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
