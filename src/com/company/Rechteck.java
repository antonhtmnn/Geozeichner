package com.company;

public class Rechteck extends Figur {

    // Attribute
    private double seiteA;
    private double seiteB;

    // Konstruktor
    public Rechteck(double posX, double posY, double seiteA, double seiteB) {
        super(posX, posY);
        this.seiteA = seiteA;
        this.seiteB = seiteB;
    }

    // Getter
    public double getSeiteA() {
        return seiteA;
    }
    public double getSeiteB() {
        return seiteB;
    }

    // Setter
    public void setSeiteA(double seiteA) {
        this.seiteA = seiteA;
    }
    public void setSeiteB(double seiteB) {
        this.seiteB = seiteB;
    }

    // Berechnungen
    public double flaeche() {
        return seiteA * seiteB;
    }

    // toString
    public String objectToSring() {
        return "Rechteck";
    }
}
