package com.company;

import javax.swing.*;

public class TopPanelTrash extends JOptionPane {

    // Konstruktor
    public TopPanelTrash() {

        int answer = showOptionDialog(null, "Möchten Sie wirklich alle Eingaben löschen?", "Eingaben löschen", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 1);

        if (answer == 0) {
            resetAll();
        }
    }

    public void resetAll() {

        CenterPanel.cPanelEingabeAusgabe.resetAll();
    }
}
