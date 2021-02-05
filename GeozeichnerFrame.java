package com.company;

import javax.swing.*;
import java.awt.*;

public class GeozeichnerFrame extends JFrame {

    // Konstruktor
    public GeozeichnerFrame() {

        setTitle("Geozeichner");
        setLayout(null);

        setSize(1200, 1000);
        setMinimumSize(new Dimension(600, 500));
        setResizable(true);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
