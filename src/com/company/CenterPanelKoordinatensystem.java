package com.company;

import javax.swing.*;
import java.awt.*;

public class CenterPanelKoordinatensystem extends JPanel {

    public static KoordinatensystemPanelMain panelKoordMain;

    // Konstruktor
    public CenterPanelKoordinatensystem() {

        //-------------------- GENERAL --------------------
        setBackground(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        //-------------------------------------------------

        buildKoordinatensystemPanelMain();

        //-------------------------------------------------
        setVisible(true);
        //-------------------------------------------------
    }

    private void buildKoordinatensystemPanelMain() {

        // koordinatensystemPanelMain
        panelKoordMain = new KoordinatensystemPanelMain();
        add(panelKoordMain);
    }
}
