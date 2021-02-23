package com.company;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    // Attribute
    private final JPanel menuPanelLeft = new JPanel();
    private final JPanel menuPanelRight = new JPanel();

    // Konstruktor
    public TopPanel() {

        //-------------------- GENERAL --------------------
        setBackground(null);
        setPreferredSize(new Dimension(0, 80));
        setLayout(new GridLayout(0, 2, 0, 0));
        //-------------------------------------------------

        buildMenuPanel();

        initComponentsMenuPanelLeft();
        add(menuPanelLeft);
        initComponentsMenuPanelRight();
        add(menuPanelRight);

        //-------------------------------------------------
        setVisible(true);
        //-------------------------------------------------
    }

    private void buildMenuPanel() {

        // menuPanelLeft
        menuPanelLeft.setBackground(null);
        menuPanelLeft.setLayout(null);

        // menuPanelRight
        menuPanelRight.setBackground(null);
        menuPanelRight.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
    }

    // adds components to menuPanelLeft
    private void initComponentsMenuPanelLeft() {

        JLabel labelTitle = new JLabel("Geozeichner");
        labelTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        labelTitle.setBounds(10, 0, 510, 80);
        labelTitle.setFont(new Font(null, Font.BOLD, 25));
        menuPanelLeft.add(labelTitle);
    }

    // adds components to menuPanelRight
    public void initComponentsMenuPanelRight() {

        //-------------------- VARIABLES --------------------
        ImageIcon iconInfo = new ImageIcon("images/info.png");
        ImageIcon iconHelp = new ImageIcon("images/help.png");
        ImageIcon iconReset = new ImageIcon("images/trash.png");
        //---------------------------------------------------

        // buttonReset
        JButton buttonReset = new JButton();
        buttonReset.setBackground(null);
        buttonReset.setBorderPainted(false);
        buttonReset.setContentAreaFilled(false);
        buttonReset.setIcon(iconReset);
        buttonReset.setFocusable(false);
        buttonReset.setPreferredSize(new Dimension(40, 40));
        menuPanelRight.add(buttonReset);

        // buttonHelp
        JButton buttonHelp = new JButton();
        buttonHelp.setBackground(null);
        buttonHelp.setBorderPainted(false);
        buttonHelp.setContentAreaFilled(false);
        buttonHelp.setIcon(iconHelp);
        buttonHelp.setFocusable(false);
        buttonHelp.setPreferredSize(new Dimension(40, 40));
        menuPanelRight.add(buttonHelp);

        // buttonInfo
        JButton buttonInfo = new JButton();
        buttonInfo.setBackground(null);
        buttonInfo.setBorderPainted(false);
        buttonInfo.setContentAreaFilled(false);
        buttonInfo.setIcon(iconInfo);
        buttonInfo.setFocusable(false);
        buttonInfo.setPreferredSize(new Dimension(40, 40));
        menuPanelRight.add(buttonInfo);
    }
}
