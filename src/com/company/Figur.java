package com.company;

public class Figur {

    // Attribute
    private double posX;
    private double posY;

    // Konstruktor
    public Figur(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    // Getter
    public double getPosX() {
        return posX;
    }
    public double getPosY() {
        return posY;
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
        return "(" +posX+ " | " +posY+ ")";
    }
}
