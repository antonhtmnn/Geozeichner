package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel implements ActionListener {

    // Attribute

    private final JPanel menuPanelLeft = new JPanel();
    private final JPanel menuPanelRight = new JPanel();
    private Color colorTopPanel = Color.WHITE;
    // buttons
    private JButton buttonReset;
    private JButton buttonHelp;
    private JButton buttonInfo;

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

    // Setter
    public void setColorTopPanel(Color color) {
        colorTopPanel = color;
    }

    private void buildMenuPanel() {

        // menuPanelLeft (title)
        menuPanelLeft.setBackground(colorTopPanel);
        menuPanelLeft.setLayout(null);

        // menuPanelRight (buttons)
        menuPanelRight.setBackground(colorTopPanel);
        menuPanelRight.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
    }

    // adds components to menuPanelLeft (title)
    private void initComponentsMenuPanelLeft() {

        JLabel labelTitle = new JLabel("Geozeichner");
        labelTitle.setBorder(null);
        labelTitle.setBounds(10, 0, 510, 80);
        labelTitle.setFont(new Font(null, Font.BOLD, 25));
        menuPanelLeft.add(labelTitle);
    }

    // adds components to menuPanelRight (buttons)
    public void initComponentsMenuPanelRight() {

        //-------------------- VARIABLES --------------------
        ImageIcon iconInfo = new ImageIcon("images/info.png");
        ImageIcon iconHelp = new ImageIcon("images/help.png");
        ImageIcon iconReset = new ImageIcon("images/trash.png");
        //---------------------------------------------------

        // buttonReset
        buttonReset = new JButton();
        buttonReset.setBackground(null);
        buttonReset.setBorderPainted(false);
        buttonReset.setContentAreaFilled(true);
        buttonReset.setIcon(iconReset);
        buttonReset.setFocusable(false);
        buttonReset.setPreferredSize(new Dimension(40, 40));
        menuPanelRight.add(buttonReset);
        buttonReset.addActionListener(this);

        // buttonHelp
        buttonHelp = new JButton();
        buttonHelp.setBackground(null);
        buttonHelp.setBorderPainted(false);
        buttonHelp.setContentAreaFilled(true);
        buttonHelp.setIcon(iconHelp);
        buttonHelp.setFocusable(false);
        buttonHelp.setPreferredSize(new Dimension(40, 40));
        menuPanelRight.add(buttonHelp);
        buttonHelp.addActionListener(this);

        // buttonInfo
        buttonInfo = new JButton();
        buttonInfo.setBackground(null);
        buttonInfo.setBorderPainted(false);
        buttonInfo.setContentAreaFilled(true);
        buttonInfo.setIcon(iconInfo);
        buttonInfo.setFocusable(false);
        buttonInfo.setPreferredSize(new Dimension(40, 40));
        menuPanelRight.add(buttonInfo);
        buttonInfo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        // reset all inputs (buttonReset)
        if (event.getSource() == buttonReset) {

            new TopPanelTrash();
        }

        // show help (buttonHelp)
        else if (event.getSource() == buttonHelp) {

            System.out.println("help");
        }

        // show info (buttonInfo)
        else if (event.getSource() == buttonInfo) {

            System.out.println("info");
        }
    }
}
