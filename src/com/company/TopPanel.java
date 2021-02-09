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
        menuPanelLeft.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

        // menuPanelRight
        menuPanelRight.setBackground(null);
        menuPanelRight.setLayout(null);
    }

    // adds components to menuPanelLeft
    private void initComponentsMenuPanelLeft() {

        JLabel labelTitle = new JLabel("Geozeichner");
        labelTitle.setPreferredSize(new Dimension(520, 80));
        labelTitle.setFont(new Font(null, Font.PLAIN, 20));
        menuPanelLeft.add(labelTitle);
    }

    // adds components to menuPanelRight
    public void initComponentsMenuPanelRight() {

        ImageIcon iconInfo = new ImageIcon("images/info.png");
        ImageIcon iconHelp = new ImageIcon("images/help.png");
        ImageIcon iconReset = new ImageIcon("images/trash.png");

        // buttonInfo
        JButton buttonInfo = new JButton();
        buttonInfo.setBackground(null);
        buttonInfo.setContentAreaFilled(false);
        buttonInfo.setIcon(iconInfo);
        buttonInfo.setFocusable(false);
        buttonInfo.setBounds(490, 25, 30, 30);
        menuPanelRight.add(buttonInfo);

        // buttonHelp
        JButton buttonHelp = new JButton();
        buttonHelp.setBackground(null);
        buttonHelp.setContentAreaFilled(false);
        buttonHelp.setIcon(iconHelp);
        buttonHelp.setFocusable(false);
        buttonHelp.setBounds(430, 25, 30, 30);
        menuPanelRight.add(buttonHelp);

        // buttonReset
        JButton buttonReset = new JButton();
        buttonReset.setBackground(null);
        buttonReset.setContentAreaFilled(false);
        buttonReset.setIcon(iconReset);
        buttonReset.setFocusable(false);
        buttonReset.setBounds(370, 25, 30, 30);
        menuPanelRight.add(buttonReset);
    }
}
