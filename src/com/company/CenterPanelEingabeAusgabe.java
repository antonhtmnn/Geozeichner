package com.company;

import javax.swing.*;
import java.awt.*;

public class CenterPanelEingabeAusgabe extends JPanel {

    // Attribute
    private final JPanel menuPanelEingabe = new JPanel();
    private final JPanel menuPanelAusgabe = new JPanel();

    // Konstruktor
    public CenterPanelEingabeAusgabe() {

        //-------------------- GENERAL --------------------
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(0, 300));
        setLayout(new GridLayout(0, 2, 0, 0));
        //-------------------------------------------------

        buildEingabeAusgabePanel();

        initComponentsMenuPanelEingabe();
        add(menuPanelEingabe);
        initComponentsMenuPanelAusgabe();
        add(menuPanelAusgabe);

        //-------------------------------------------------
        setVisible(true);
        //-------------------------------------------------
    }

    private void buildEingabeAusgabePanel() {

        // menuPanelEingabe
        menuPanelEingabe.setBackground(Color.RED);
        menuPanelEingabe.setLayout(null);

        // menuPanelAusgabe
        menuPanelAusgabe.setBackground(Color.GREEN);
        menuPanelAusgabe.setLayout(null);
    }

    // adds components to menuPanelEingabe
    private void initComponentsMenuPanelEingabe() {
    }

    // adds components to menuPanelAusgabe
    private void initComponentsMenuPanelAusgabe() {
    }
}
