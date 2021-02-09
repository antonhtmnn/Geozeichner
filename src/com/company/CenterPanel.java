package com.company;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {

    // Konstruktor
    public CenterPanel() {

        //-------------------- GENERAL --------------------
        setBackground(null);
        setLayout(new BorderLayout());
        //-------------------------------------------------

        CenterPanelEingabeAusgabe cPanelEingabeAusgabe = new CenterPanelEingabeAusgabe();
        add(cPanelEingabeAusgabe, BorderLayout.NORTH);

        CenterPanelKoordinatensystem cPanelKoordinatensystem = new CenterPanelKoordinatensystem();
        add(cPanelKoordinatensystem, BorderLayout.CENTER);

        //-------------------------------------------------
        setVisible(true);
        //-------------------------------------------------
    }
}
