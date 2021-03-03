package com.company;

import javax.swing.*;
import java.awt.*;

public class KoordinatensystemPanelMain extends JPanel {

    private final double scale = 37.8;

    // Konstruktor
    public KoordinatensystemPanelMain() {

        //-------------------- GENERAL --------------------
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(1000, 500));
        setLayout(null);
        //-------------------------------------------------

        //-------------------------------------------------
        setVisible(true);
        //-------------------------------------------------
    }

    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawLine(500, 0, 500, 500);
        g2D.drawLine(250, 250, 750, 250);

        drawSquare(g);
    }

    public void drawSquare(Graphics g) {

        for (int i = 0; i < CenterPanelEingabeAusgabe.figuren.length; i++) {

            if (CenterPanelEingabeAusgabe.figuren[i] instanceof Rechteck) {

                int posX = 500;
                int posY = 250;
                int width;
                int height;

                width = (int) (((Rechteck) CenterPanelEingabeAusgabe.figuren[i]).getSeiteA() * scale);
                height = (int) (((Rechteck) CenterPanelEingabeAusgabe.figuren[i]).getSeiteB() * scale);
                posX += (int) (CenterPanelEingabeAusgabe.figuren[i].getPosX() * scale);
                posY -= (int) (CenterPanelEingabeAusgabe.figuren[i].getPosY() * scale) + height;

                g.setColor(CenterPanelEingabeAusgabe.figuren[i].getColor());
                g.fillRect(posX, posY, width, height);
            }
        }
    }
}
