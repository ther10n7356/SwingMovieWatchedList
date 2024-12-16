package app.movieList.swing.listeners;

import java.util.EventListener;

public interface TableButtonListener extends EventListener {
    public void tableButtonClicked(int row, int col);
}
