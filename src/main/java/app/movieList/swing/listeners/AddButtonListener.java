package app.movieList.swing.listeners;

import app.movieList.swing.windows.AddWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonListener implements ActionListener {

    private final AddWindow addWindow;

    public AddButtonListener(AddWindow addWindow) {
        this.addWindow = addWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            addWindow.getContentPane().removeAll();
            addWindow.clearTextFields();
            addWindow.init();
            addWindow.pack();
        });
    }
}
