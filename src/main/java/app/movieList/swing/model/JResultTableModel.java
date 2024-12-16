package app.movieList.swing.model;

import javax.swing.table.AbstractTableModel;

public class JResultTableModel extends AbstractTableModel {
    private final Object[][] rows;
    private final String[] columns;

    public JResultTableModel(Object[][] rows, String[] columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows[rowIndex][columnIndex];
    }

    public void setValueAt(Object value, int row, int col) {
        rows[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        if (columnIndex == columns.length-1) {
//            return true;
//        }
        return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }
}
