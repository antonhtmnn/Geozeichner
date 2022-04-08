package com.company;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {

    public static CenterPanelEingabeAusgabe cPanelEingabeAusgabe;
    public static CenterPanelKoordinatensystem cPanelKoordinatensystem;

    // Konstruktor
    public CenterPanel() {

        //-------------------- GENERAL --------------------
        setBackground(null);
        setLayout(new BorderLayout());
        //-------------------------------------------------

        cPanelEingabeAusgabe = new CenterPanelEingabeAusgabe();
        add(cPanelEingabeAusgabe, BorderLayout.NORTH);

        cPanelKoordinatensystem = new CenterPanelKoordinatensystem();
        add(cPanelKoordinatensystem, BorderLayout.CENTER);

        //-------------------------------------------------
        setVisible(true);
        //-------------------------------------------------
    }
}
