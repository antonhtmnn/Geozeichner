package com.company;

import javax.swing.*;
import java.awt.*;

public class GeozeichnerFrame extends JFrame {

    // Konstruktor
    public GeozeichnerFrame() {

        //-------------------- GENERAL --------------------
        setTitle("Geozeichner");
        setLayout(new BorderLayout());

        setSize(1200, 1000);
        setMinimumSize(new Dimension(1040, 800));
        setResizable(true);
        setLocationRelativeTo(null);
        //-------------------------------------------------

        TopPanel tPanel = new TopPanel();
        add(tPanel, BorderLayout.NORTH);

        CenterPanel cPanel = new CenterPanel();
        add(cPanel, BorderLayout.CENTER);

        //-------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        //-------------------------------------------------
    }
}
