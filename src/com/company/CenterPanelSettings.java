package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class CenterPanelSettings extends JPanel implements ChangeListener {

    private boolean visibility;

    private final JPanel panelLeft = new JPanel();
    private final JPanel panelRight = new JPanel();

    public JSlider sliderScale;

    // Konstruktor
    public CenterPanelSettings() {

        //-------------------- GENERAL --------------------
        setBackground(Color.GRAY);
        setLayout(new GridLayout(0, 2, 0, 0));
        setPreferredSize(new Dimension(500, 0));
        //-------------------------------------------------

        buildPanelLeft();
        buildPanelRight();

        initComponentsPanelLeft();
        initComponentsPanelRight();

        //-------------------------------------------------
        setVisible(true);
        //-------------------------------------------------
    }

    // Getter
    public boolean getVisibility() {
        return visibility;
    }

    // Setter
    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    private void buildPanelLeft() {

        // panelLeft
        panelLeft.setBackground(Color.GRAY);
        panelLeft.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 4));
        add(panelLeft);
    }

    private void buildPanelRight() {

        // panelRight
        panelRight.setBackground(Color.GRAY);
        panelRight.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 4));
        add(panelRight);
    }

    // adds components to panelLeft
    private void initComponentsPanelLeft() {

        //--------------------- General ---------------------
        Dimension size = new Dimension(240, 30);
        Font font = new Font(null, Font.PLAIN, 20);
        //---------------------------------------------------

        JLabel labelScale = new JLabel("Maßstab");
        labelScale.setBorder(null);
        labelScale.setPreferredSize(size);
        labelScale.setFont(font);
        panelLeft.add(labelScale);
    }

    // adds components to panelRight
    private void initComponentsPanelRight() {

        //--------------------- General ---------------------
        Dimension size = new Dimension(240, 30);
        //---------------------------------------------------

        // sliderScale
        sliderScale = new JSlider(0, 100, 20);
        sliderScale.setPreferredSize(size);
        sliderScale.setBackground(Color.GRAY);
        sliderScale.setMajorTickSpacing(20);
        sliderScale.setPaintLabels(true);
        panelRight.add(sliderScale);
        sliderScale.addChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {

        int scale = (sliderScale.getValue() + 5) * 2;

        KoordinatensystemPanelMain.setScale(scale);
        CenterPanelKoordinatensystem.panelKoordMain.repaint();
    }
}
