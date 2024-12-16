package app.movieList.swing.render;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class SearchResultTableRender implements TableCellRenderer {
    private TableCellRenderer defaultRenderer;

    public SearchResultTableRender(TableCellRenderer renderer) {
        this.defaultRenderer = renderer;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof Component)
            return (Component)value;
        return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
