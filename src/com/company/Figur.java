package com.company;

import java.awt.*;

public class Figur {

    // Attribute
    private double posX;
    private double posY;
    private final Color color;
    private final int transparency = 100;

    // Konstruktor
    public Figur(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
        color = (new Color((int) Math.floor(Math.random() * 256), (int) Math.floor(Math.random() * 256), (int) Math.floor(Math.random() * 256), transparency));
    }

    // Getter
    public double getPosX() {
        return posX;
    }
    public double getPosY() {
        return posY;
    }
    public Color getColor() {
        return color;
    }

    // Setter
    public void setPosX(double posX) {
        this.posX = posX;
    }
    public void setPosY(double posY) {
        this.posY = posY;
    }

    // toString
    public String objectPositionToString() {
        return "(" +cleanUpValue(posX)+ " | " +cleanUpValue(posY)+ ")";
    }

    // checks if double can be converted to int (String)
    public static String cleanUpValue(double number) {

        number = Math.round(number * 100.0) / 100.0;
        String str = String.valueOf(number);

        String[] parts = str.split("[.]");
        String part1 = parts[0];
        String part2 = parts[1];

        if (part2.contains("0")) {
            str = part1;
        }
        return str;
    }
}
