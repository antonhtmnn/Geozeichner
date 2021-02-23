package com.company;

public class Kreis extends Figur {

    // Attribute
    private double radius;

    // Konstruktor
    public Kreis(double posX, double posY, double radius) {
        super(posX, posY);
        this.radius = radius;
    }

    // Getter
    public double getRadius() {
        return radius;
    }

    // Setter
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // toString
    public String objectToSring() {
        return "Kreis";
    }
}
