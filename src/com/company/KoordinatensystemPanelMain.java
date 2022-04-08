package com.company;

import javax.swing.*;
import java.awt.*;

public class KoordinatensystemPanelMain extends JPanel {

    private static double scale = 50; // minimum = 10 | maximum = 210
    private final int gridGap = 10;

    // Konstruktor
    public KoordinatensystemPanelMain() {

        //-------------------- GENERAL --------------------
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1000, 500));
        setLayout(null);
        //-------------------------------------------------

        //-------------------------------------------------
        setVisible(true);
        //-------------------------------------------------
    }

    public void paint(Graphics g) {

        //-------------------- GENERAL --------------------
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        //-------------------------------------------------

        // Koordinatensystem
        drawAchseX(g2D);
        drawAchseY(g2D);
        drawGridAndNumbers(g2D);

        // shapes
        drawSquare(g2D);
        drawCircle(g2D);
    }

    public void drawAchseX(Graphics2D g2D) {

        // x-Achse
        g2D.setStroke(new BasicStroke(3));
        g2D.drawLine(500, gridGap, 500, 500-gridGap);

        // x-arrow
        int[] xPoints = {1000-gridGap, 975, 975};
        int[] yPoints = {250, 260, 240};
        g2D.drawPolygon(xPoints, yPoints, 3);
        g2D.fillPolygon(xPoints, yPoints, 3);

        // x-String
        g2D.setFont(new Font(null, Font.BOLD, 20));
        g2D.drawString("x", 975, 280);
    }

    public void drawAchseY(Graphics2D g2D) {

        // y-Achse
        g2D.setStroke(new BasicStroke(3));
        g2D.drawLine(gridGap, 250, 1000-gridGap, 250);

        // y-arrow
        int[] xPoints = {500, 510, 490};
        int[] yPoints = {gridGap, 25, 25};
        g2D.drawPolygon(xPoints, yPoints, 3);
        g2D.fillPolygon(xPoints, yPoints, 3);

        // y-String
        g2D.setFont(new Font(null, Font.BOLD, 20));
        g2D.drawString("y", 470, 25);
    }

    public void drawGridAndNumbers(Graphics2D g2D) {

        int iRight = 500;
        int iLeft = 500;
        int numberX = 1;
        while (iRight < 1000-gridGap-scale) {

            // grid
            iRight += scale;
            iLeft -= scale;
            g2D.setStroke(new BasicStroke(0));
            g2D.setColor(new Color(0, 0, 0, 70));
            g2D.drawLine(iRight, gridGap, iRight, 500-gridGap);
            g2D.drawLine(iLeft, gridGap, iLeft, 500-gridGap);

            // x-Achse
            if (iRight <= 960) {

                // numbers positive (x-Achse)
                if (scale >= 160) {
                    double n = scale;
                    for (int i = 0; i < 9; i++) {
                        n -= scale/10;
                        if (i == 4) {
                            g2D.setStroke(new BasicStroke(2));
                        } else {
                            g2D.setStroke(new BasicStroke(1));
                        }
                        g2D.setColor(new Color(0, 0, 0, 255));
                        g2D.drawLine((int) (iRight-n), 250-4, (int) (iRight-n), 250+4);
                    }
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(iRight, 250-6, iRight, 250+6);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberX < 10) {
                        g2D.drawString(String.valueOf(numberX), iRight-5, 270);
                        g2D.setColor(new Color(0, 0, 0, 70));
                        g2D.drawString(String.valueOf(numberX-0.5), (int) ((iRight-scale/2)-12), 270);
                    }
                }
                else if (scale >= 120) {
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine((int) (iRight-scale/2), 250-4, (int) (iRight-scale/2), 250+4);
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(iRight, 250-6, iRight, 250+6);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberX < 10) {
                        g2D.drawString(String.valueOf(numberX), iRight-5, 270);
                        g2D.setColor(new Color(0, 0, 0, 70));
                        g2D.drawString(String.valueOf(numberX-0.5), (int) ((iRight-scale/2)-12), 270);
                    }
                }
                else if (scale >= 80) {
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine((int) (iRight-scale/2), 250-4, (int) (iRight-scale/2), 250+4);
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(iRight, 250-6, iRight, 250+6);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberX < 10) g2D.drawString(String.valueOf(numberX), iRight-5, 270);
                    else g2D.drawString(String.valueOf(numberX), iRight-9, 270);
                }
                else if (scale >= 40) {
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(iRight, 250-6, iRight, 250+6);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberX < 10) g2D.drawString(String.valueOf(numberX), iRight-5, 270);
                    else g2D.drawString(String.valueOf(numberX), iRight-9, 270);
                }
                else if (scale >= 20) {
                    if (numberX % 2 == 0) {
                        g2D.setStroke(new BasicStroke(2));
                        g2D.setColor(new Color(0, 0, 0, 255));
                        g2D.drawLine(iRight, 250-6, iRight, 250+6);

                        g2D.setFont(new Font(null, Font.BOLD, 14));
                        if (numberX < 10) g2D.drawString(String.valueOf(numberX), iRight-5, 270);
                        else g2D.drawString(String.valueOf(numberX), iRight-9, 270);
                    }
                }
                else if (scale >= 10) {
                    if (numberX % 4 == 0) {
                        g2D.setStroke(new BasicStroke(2));
                        g2D.setColor(new Color(0, 0, 0, 255));
                        g2D.drawLine(iRight, 250-6, iRight, 250+6);

                        g2D.setFont(new Font(null, Font.BOLD, 14));
                        if (numberX < 10) g2D.drawString(String.valueOf(numberX), iRight-5, 270);
                        else g2D.drawString(String.valueOf(numberX), iRight-9, 270);
                    }
                }
                // numbers negative (x-Achse)
                if (scale >= 160) {
                    double n = scale;
                    for (int i = 0; i < 9; i++) {
                        n -= scale/10;
                        if (i == 4) {
                            g2D.setStroke(new BasicStroke(2));
                        } else {
                            g2D.setStroke(new BasicStroke(1));
                        }
                        g2D.setColor(new Color(0, 0, 0, 255));
                        g2D.drawLine((int) (iLeft+n), 250-4, (int) (iLeft+n), 250+4);
                    }
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(iLeft, 250-6, iLeft, 250+6);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberX < 10) {
                        g2D.drawString("-" +numberX, iLeft-11, 270);
                        g2D.setColor(new Color(0, 0, 0, 70));
                        g2D.drawString("-" +(numberX-0.5), (int) ((iLeft+scale/2)-18), 270);
                    }
                }
                else if (scale >= 120) {
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine((int) (iLeft+scale/2), 250-4, (int) (iLeft+scale/2), 250+4);
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(iLeft, 250-6, iLeft, 250+6);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberX < 10) {
                        g2D.drawString("-" +numberX, iLeft-11, 270);
                        g2D.setColor(new Color(0, 0, 0, 70));
                        g2D.drawString("-" +(numberX-0.5), (int) ((iLeft+scale/2)-18), 270);
                    }
                }
                else if (scale >= 80) {
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine((int) (iLeft+scale/2), 250-4, (int) (iLeft+scale/2), 250+4);
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(iLeft, 250-6, iLeft, 250+6);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberX < 10) g2D.drawString("-" +numberX, iLeft-11, 270);
                    else g2D.drawString("-" +numberX, iLeft-15, 270);
                }
                else if (scale >= 40) {
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(iLeft, 250-6, iLeft, 250+6);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberX < 10) g2D.drawString("-" +numberX, iLeft-11, 270);
                    else g2D.drawString("-" +numberX, iLeft-15, 270);
                }
                else if (scale >= 20) {
                    if (numberX % 2 == 0) {
                        g2D.setStroke(new BasicStroke(2));
                        g2D.setColor(new Color(0, 0, 0, 255));
                        g2D.drawLine(iLeft, 250-6, iLeft, 250+6);

                        g2D.setFont(new Font(null, Font.BOLD, 14));
                        if (numberX < 10) g2D.drawString("-" +numberX, iLeft-11, 270);
                        else g2D.drawString("-" +numberX, iLeft-15, 270);
                    }
                }
                else if (scale >= 10) {
                    if (numberX % 4 == 0) {
                        g2D.setStroke(new BasicStroke(2));
                        g2D.setColor(new Color(0, 0, 0, 255));
                        g2D.drawLine(iLeft, 250-6, iLeft, 250+6);

                        g2D.setFont(new Font(null, Font.BOLD, 14));
                        if (numberX < 10) g2D.drawString("-" +numberX, iLeft-11, 270);
                        else g2D.drawString("-" +numberX, iLeft-15, 270);
                    }
                }
                numberX++;
            }
        }

        int iTop = 250;
        int iBottom = 250;
        int numberY = 1;
        while (iBottom < 500-gridGap-scale) {

            // grid
            iTop -= scale;
            iBottom += scale;
            g2D.setStroke(new BasicStroke(0));
            g2D.setColor(new Color(0, 0, 0, 70));
            g2D.drawLine(gridGap, iTop, 1000-gridGap, iTop);
            g2D.drawLine(gridGap, iBottom, 1000-gridGap, iBottom);

            // y-Achse
            if (iBottom <= 460) {

                // numbers positive (y-Achse)
                if (scale >= 160) {
                    double n = scale;
                    for (int i = 0; i < 9; i++) {
                        n -= scale/10;
                        if (i == 4) {
                            g2D.setStroke(new BasicStroke(2));
                        } else {
                            g2D.setStroke(new BasicStroke(1));
                        }
                        g2D.setColor(new Color(0, 0, 0, 255));
                        g2D.drawLine(500-4, (int) (iTop+n), 500+4, (int) (iTop+n));
                    }
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(500-6, iTop, 500+6, iTop);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberY < 10) {
                        g2D.drawString(String.valueOf(numberY), 480, iTop+5);
                        g2D.setColor(new Color(0, 0, 0, 70));
                        g2D.drawString(String.valueOf(numberY-0.5), 480-15, (int) ((iTop+scale/2)+5));
                    }
                }
                else if (scale >= 120) {
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(500-4, (int) (iTop+scale/2), 500+4, (int) (iTop+scale/2));
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(500-6, iTop, 500+6, iTop);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberY < 10) {
                        g2D.drawString(String.valueOf(numberY), 480, iTop+5);
                        g2D.setColor(new Color(0, 0, 0, 70));
                        g2D.drawString(String.valueOf(numberY-0.5), 480-15, (int) ((iTop+scale/2)+5));
                    }
                }
                else if (scale >= 80) {
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(500-4, (int) (iTop+scale/2), 500+4, (int) (iTop+scale/2));
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(500-6, iTop, 500+6, iTop);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberY < 10) g2D.drawString(String.valueOf(numberY), 480, iTop+5);
                    else g2D.drawString(String.valueOf(numberY), 480-9, iTop+5);
                }
                else if (scale >= 40) {
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(500-6, iTop, 500+6, iTop);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberY < 10) g2D.drawString(String.valueOf(numberY), 480, iTop+5);
                    else g2D.drawString(String.valueOf(numberY), 480-9, iTop+5);
                }
                else if (scale >= 20) {
                    if (numberY % 2 == 0) {
                        g2D.setStroke(new BasicStroke(2));
                        g2D.setColor(new Color(0, 0, 0, 255));
                        g2D.drawLine(500-6, iTop, 500+6, iTop);

                        g2D.setFont(new Font(null, Font.BOLD, 14));
                        if (numberY < 10) g2D.drawString(String.valueOf(numberY), 480, iTop+5);
                        else g2D.drawString(String.valueOf(numberY), 480-9, iTop+5);
                    }
                }
                else if (scale >= 10) {
                    if (numberY % 4 == 0) {
                        g2D.setStroke(new BasicStroke(2));
                        g2D.setColor(new Color(0, 0, 0, 255));
                        g2D.drawLine(500-6, iTop, 500+6, iTop);

                        g2D.setFont(new Font(null, Font.BOLD, 14));
                        if (numberY < 10) g2D.drawString(String.valueOf(numberY), 480, iTop+5);
                        else g2D.drawString(String.valueOf(numberY), 480-9, iTop+5);
                    }
                }
                // numbers negative (y-Achse)
                if (scale >= 160) {
                    double n = scale;
                    for (int i = 0; i < 9; i++) {
                        n -= scale/10;
                        if (i == 4) {
                            g2D.setStroke(new BasicStroke(2));
                        } else {
                            g2D.setStroke(new BasicStroke(1));
                        }
                        g2D.setColor(new Color(0, 0, 0, 255));
                        g2D.drawLine(500-4, (int) (iBottom-n), 500+4, (int) (iBottom-n));
                    }
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(500-6, iBottom, 500+6, iBottom);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberY < 10) {
                        g2D.drawString("-" +numberY, 480-6, iBottom+5);
                        g2D.setColor(new Color(0, 0, 0, 70));
                        g2D.drawString("-" +(numberY-0.5), 480-20, (int) ((iBottom-scale/2)+5));
                    }
                }
                else if (scale >= 120) {
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(500-4, (int) (iBottom-scale/2), 500+4, (int) (iBottom-scale/2));
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(500-6, iBottom, 500+6, iBottom);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberY < 10) {
                        g2D.drawString("-" +numberY, 480-6, iBottom+5);
                        g2D.setColor(new Color(0, 0, 0, 70));
                        g2D.drawString("-" +(numberY-0.5), 480-20, (int) ((iBottom-scale/2)+5));
                    }
                }
                else if (scale >= 80) {
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(500-4, (int) (iBottom-scale/2), 500+4, (int) (iBottom-scale/2));
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(500-6, iBottom, 500+6, iBottom);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberY < 10) g2D.drawString("-" +numberY, 480-6, iBottom+5);
                    else g2D.drawString("-" +numberY, 480-15, iBottom+5);
                }
                else if (scale >= 40) {
                    g2D.setStroke(new BasicStroke(2));
                    g2D.setColor(new Color(0, 0, 0, 255));
                    g2D.drawLine(500-6, iBottom, 500+6, iBottom);

                    g2D.setFont(new Font(null, Font.BOLD, 14));
                    if (numberY < 10) g2D.drawString("-" +numberY, 480-6, iBottom+5);
                    else g2D.drawString("-" +numberY, 480-15, iBottom+5);
                }
                else if (scale >= 20) {
                    if (numberY % 2 == 0) {
                        g2D.setStroke(new BasicStroke(2));
                        g2D.setColor(new Color(0, 0, 0, 255));
                        g2D.drawLine(500-6, iBottom, 500+6, iBottom);

                        g2D.setFont(new Font(null, Font.BOLD, 14));
                        if (numberY < 10) g2D.drawString("-" +numberY, 480-6, iBottom+5);
                        else g2D.drawString("-" +numberY, 480-15, iBottom+5);
                    }
                }
                else if (scale >= 10) {
                    if (numberY % 4 == 0) {
                        g2D.setStroke(new BasicStroke(2));
                        g2D.setColor(new Color(0, 0, 0, 255));
                        g2D.drawLine(500-6, iBottom, 500+6, iBottom);

                        g2D.setFont(new Font(null, Font.BOLD, 14));
                        if (numberY < 10) g2D.drawString("-" +numberY, 480-6, iBottom+5);
                        else g2D.drawString("-" +numberY, 480-15, iBottom+5);
                    }
                }
                numberY++;
            }
        }
    }

    public void drawSquare(Graphics2D g2D) {

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

                g2D.setColor(CenterPanelEingabeAusgabe.figuren[i].getColor());
                g2D.fillRect(posX, posY, width, height);
            }
        }
    }

    public void drawCircle(Graphics2D g2D) {

        for (int i = 0; i < CenterPanelEingabeAusgabe.figuren.length; i++) {

            if (CenterPanelEingabeAusgabe.figuren[i] instanceof Kreis) {

                int posX = 500;
                int posY = 250;
                int radius;

                radius = (int) (((Kreis) CenterPanelEingabeAusgabe.figuren[i]).getRadius() * scale) * 2;
                posX += (int) (CenterPanelEingabeAusgabe.figuren[i].getPosX() * scale);
                posX -= (radius / 2);
                posY -= (int) (CenterPanelEingabeAusgabe.figuren[i].getPosY() * scale);
                posY -= (radius / 2);

                g2D.setColor(CenterPanelEingabeAusgabe.figuren[i].getColor());
                g2D.fillOval(posX, posY, radius, radius);
            }
        }
    }

    // Getter
    public static double getScale() {
        return scale;
    }

    // Setter
    public static void setScale(int scale) {
        KoordinatensystemPanelMain.scale = scale;
    }
}
