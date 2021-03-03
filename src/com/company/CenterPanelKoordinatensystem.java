package com.company;

import javax.swing.*;
import java.awt.*;

public class CenterPanelKoordinatensystem extends JPanel {

    public static KoordinatensystemPanelMain panelKoordMain;

    // Konstruktor
    public CenterPanelKoordinatensystem() {

        //-------------------- GENERAL --------------------
        setBackground(Color.CYAN);
        setLayout(new FlowLayout(FlowLayout.CENTER, 999, 0));
        //-------------------------------------------------

        buildKoordinatensystemPanelMain();
        buildKoordinatensystemPanelBorder();

        //-------------------------------------------------
        setVisible(true);
        //-------------------------------------------------
    }

    private void buildKoordinatensystemPanelMain() {

        // koordinatensystemPanelMain
        panelKoordMain = new KoordinatensystemPanelMain();
        add(panelKoordMain);
    }

    private void buildKoordinatensystemPanelBorder() {

        JPanel koordinatensystemPanelBorderLeft = new JPanel();
        koordinatensystemPanelBorderLeft.setBackground(null);
        koordinatensystemPanelBorderLeft.setPreferredSize(new Dimension(100, 0));
        koordinatensystemPanelBorderLeft.setLayout(null);
        add(koordinatensystemPanelBorderLeft, BorderLayout.WEST);

        JPanel koordinatensystemPanelBorderRight = new JPanel();
        koordinatensystemPanelBorderRight.setBackground(null);
        koordinatensystemPanelBorderRight.setPreferredSize(new Dimension(100, 0));
        koordinatensystemPanelBorderRight.setLayout(null);
        add(koordinatensystemPanelBorderRight, BorderLayout.EAST);
    }
}
