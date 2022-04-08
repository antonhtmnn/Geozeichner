package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CenterPanelEingabeAusgabe extends JPanel implements ActionListener {

    //------------------------------------------------ Attributes ------------------------------------------------
    // panalEingabe
    private final JPanel panelEingabe = new JPanel();
    private final JPanel panelEingabeTop = new JPanel();
    private final JPanel panelEingabeTopTop = new JPanel();
    private final JPanel panelCenter = new JPanel();
    private final CenterPanelSettings panelSettingsCenter = new CenterPanelSettings();
    private final JPanel panelEingabeCenter = new JPanel();
    private final JPanel panelEingabeCenterLeft = new JPanel();
    private final JPanel panelEingabeCenterRight = new JPanel();
    private final JPanel panelEingabeBottom = new JPanel();

    // panalAusgabe
    private final JPanel panelAusgabe = new JPanel();
    private final JPanel panelAusgabeTop = new JPanel();
    private final JPanel panelAusgabeTopTop = new JPanel();
    private final JPanel panelAusgabeCenter = new JPanel();
    private final JPanel panelAusgabeBottom = new JPanel();

    // buttons
    private JButton buttonAdd;
    private JButton buttonInput;
    private JButton buttonSettings;
    private JButton buttonOutput;

    // contains all components of panelEingabe / panelAusgabe
    private final JComponent[] componentsPanelEingabeCenter = new JComponent[12];

    // textField index (in componentsPanelEingabeCenter) of specific objects
    private final int[] rechteckTextFieldIndex = {3, 5, 7, 9};
    private final int[] kreisTextFieldIndex = {3, 5, 11};
    private double[] eigenschaften;

    // array (figuren) contains all created objects
    public static int anzahlFiguren;
    public static Figur[] figuren = new Figur[0];

    // output table
    private JTable tableAusgabe;
    private DefaultTableModel model;
    private String[] row;
    private JScrollPane pane;

    // colors
    private Color colorCenterPanel = null;

    // others
    private int checklist;
    private int rechteckTotalAmount;
    private int kreisTotalAmount;
    //------------------------------------------------------------------------------------------------------------

    //------------------------------------------------- General --------------------------------------------------
    // Konstruktor
    public CenterPanelEingabeAusgabe() {

        //-------------------- GENERAL --------------------
        setBackground(null);
        setPreferredSize(new Dimension(0, 300));
        setLayout(new GridLayout(0, 2, 0, 0));
        //-------------------------------------------------

        buildEingabeAusgabePanel();

        // Eingabe (build)
        buildEingabePanelTop();
        buildEingabePanelCenter();
        buildEingabePanelCenterLeft();
        buildEingabePanelCenterRight();
        buildEingabePanelBottom();
        // Eingabe (init)
        initComponentsPanelEingabeTop();
        initComponentsPanelEingabeCenter();
        initComponentsPanelEingabeBottom();
        add(panelEingabe);

        // Ausgabe (build)
        buildAusgabePanelTop();
        buildAusgabePanelCenter();
        buildAusgabePanelBottom();
        // Ausgabe (init)
        initComponentsPanelAusgabeTop();
        initComponentsPanelAusgabeCenter();
        initComponentsPanelAusgabeBottom();
        add(panelAusgabe);

        //-------------------------------------------------
        setVisible(true);
        //-------------------------------------------------
    }

    // Main-Panel
    private void buildEingabeAusgabePanel() {

        // panelEingabe
        panelEingabe.setBackground(colorCenterPanel);
        panelEingabe.setLayout(new BorderLayout());

        // panelAusgabe
        panelAusgabe.setBackground(colorCenterPanel);
        panelAusgabe.setLayout(new BorderLayout());

        // panelCenter
        panelCenter.setBackground(null);
        panelCenter.setLayout(new BorderLayout());
        panelCenter.setPreferredSize(new Dimension(500, 0));
        panelEingabe.add(panelCenter, BorderLayout.EAST);
    }
    //------------------------------------------------------------------------------------------------------------

    //----------------------------------------------- panelEingabe -----------------------------------------------
    private void buildEingabePanelTop() {

        // panelEingabeTop
        panelEingabeTop.setBackground(null);
        panelEingabeTop.setPreferredSize(new Dimension(0, 40));
        panelEingabeTop.setLayout(new BorderLayout());
        panelEingabe.add(panelEingabeTop, BorderLayout.NORTH);

        // panelEingabeTopTop
        panelEingabeTopTop.setBackground(null);
        panelEingabeTopTop.setPreferredSize(new Dimension(500, 0));
        panelEingabeTopTop.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelEingabeTop.add(panelEingabeTopTop, BorderLayout.EAST);
    }

    private void buildEingabePanelCenter() {

        if (panelSettingsCenter.getVisibility()) {
            panelEingabeCenter.setVisible(false);
            // panelAppearanceCenter
            panelCenter.add(panelSettingsCenter, BorderLayout.CENTER);
            panelSettingsCenter.setVisible(true);
        }
        else {
            panelSettingsCenter.setVisible(false);
            // panelEingabeCenter
            panelEingabeCenter.setLayout(new GridLayout(0, 2, 0, 0));
            panelEingabeCenter.setPreferredSize(new Dimension(500, 0));
            panelCenter.add(panelEingabeCenter, BorderLayout.CENTER);
            panelEingabeCenter.setVisible(true);
        }
    }

    private void buildEingabePanelCenterLeft() {

        // panelEingabeCenterLeft
        panelEingabeCenterLeft.setBackground(Color.LIGHT_GRAY);
        panelEingabeCenterLeft.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 4));
        panelEingabeCenter.add(panelEingabeCenterLeft);
    }

    private void buildEingabePanelCenterRight() {

        // panelEingabeCenterRight
        panelEingabeCenterRight.setBackground(Color.LIGHT_GRAY);
        panelEingabeCenterRight.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 4));
        panelEingabeCenter.add(panelEingabeCenterRight);
    }

    private void buildEingabePanelBottom() {

        // panelEingabeBottom
        panelEingabeBottom.setBackground(colorCenterPanel);
        panelEingabeBottom.setPreferredSize(new Dimension(0, 40));
        panelEingabeBottom.setLayout(new FlowLayout(FlowLayout.RIGHT, 190, 5));
        panelEingabe.add(panelEingabeBottom, BorderLayout.SOUTH);
    }

    // adds components to panelEingabeTop
    private void initComponentsPanelEingabeTop() {

        Font font = new Font(null, Font.BOLD, 20);
        int width = 200;

        // buttonInput
        buttonInput = new JButton("Eingabe");
        buttonInput.setFont(font);
        buttonInput.setFocusable(false);
        buttonInput.setBackground(Color.LIGHT_GRAY);
        buttonInput.setPreferredSize(new Dimension(width, 40));
        panelEingabeTopTop.add(buttonInput);
        buttonInput.addActionListener(this);

        // buttonSettings
        buttonSettings = new JButton("Einstellungen");
        buttonSettings.setFont(font);
        buttonSettings.setFocusable(false);
        buttonSettings.setBackground(Color.GRAY);
        buttonSettings.setPreferredSize(new Dimension(width, 40));
        panelEingabeTopTop.add(buttonSettings);
        buttonSettings.addActionListener(this);
    }

    // adds components to panelEingabeCenter
    private void initComponentsPanelEingabeCenter() {

        //--------------------- General ---------------------
        Dimension size = new Dimension(240, 30);
        Font font = new Font(null, Font.PLAIN, 20);

        String[] figuren = {"Bitte auswählen", "Rechteck", "Kreis"};
        //---------------------------------------------------

        // Array elements
        componentsPanelEingabeCenter[0] = new JLabel("2D-Figur");
        componentsPanelEingabeCenter[1] = new JComboBox(figuren);
        componentsPanelEingabeCenter[2] = new JLabel("Position x-Achse");
        componentsPanelEingabeCenter[3] = new JTextField("0");
        componentsPanelEingabeCenter[4] = new JLabel("Position y-Achse");
        componentsPanelEingabeCenter[5] = new JTextField("0");
        componentsPanelEingabeCenter[6] = new JLabel("Seite a");
        componentsPanelEingabeCenter[7] = new JTextField("0");
        componentsPanelEingabeCenter[8] = new JLabel("Seite b");
        componentsPanelEingabeCenter[9] = new JTextField("0");
        componentsPanelEingabeCenter[10] = new JLabel("Radius");
        componentsPanelEingabeCenter[11] = new JTextField("0");

        // init array elements
        for (int i = 0; i < componentsPanelEingabeCenter.length; i++) {

            // label (JLabel)
            if (componentsPanelEingabeCenter[i] instanceof JLabel) {
                componentsPanelEingabeCenter[i].setBorder(null);
                componentsPanelEingabeCenter[i].setPreferredSize(size);
                componentsPanelEingabeCenter[i].setFont(font);
                panelEingabeCenterLeft.add(componentsPanelEingabeCenter[i]);
            }
            // comboBox (JComboBox)
            else if (componentsPanelEingabeCenter[i] instanceof JComboBox) {
                componentsPanelEingabeCenter[i].setBorder(null);
                componentsPanelEingabeCenter[i].setPreferredSize(size);
                ((JComboBox) componentsPanelEingabeCenter[i]).setSelectedIndex(0);
                panelEingabeCenterRight.add(componentsPanelEingabeCenter[i]);
                ((JComboBox) componentsPanelEingabeCenter[i]).addActionListener(this);
            }
            // textField (JTextField)
            else if (componentsPanelEingabeCenter[i] instanceof JTextField) {
                componentsPanelEingabeCenter[i].setPreferredSize(size);
                panelEingabeCenterRight.add(componentsPanelEingabeCenter[i]);
            }
            // visibility
            if (i > 1) {
                componentsPanelEingabeCenter[i].setVisible(false);
            }
        }
    }

    // adds components to panelEingabeBottom
    private void initComponentsPanelEingabeBottom() {

        // buttonAdd
        buttonAdd = new JButton("Hinzufügen");
        buttonAdd.setFocusable(false);
        buttonAdd.setPreferredSize(new Dimension(120, 30));
        panelEingabeBottom.add(buttonAdd);
        buttonAdd.setVisible(false);
        buttonAdd.addActionListener(this);
    }
    //------------------------------------------------------------------------------------------------------------

    //----------------------------------------------- panelAusgabe -----------------------------------------------
    private void buildAusgabePanelTop() {

        // panelAusgabeTop
        panelAusgabeTop.setBackground(null);
        panelAusgabeTop.setPreferredSize(new Dimension(0, 40));
        panelAusgabeTop.setLayout(new BorderLayout());
        panelAusgabe.add(panelAusgabeTop, BorderLayout.NORTH);

        // panelAusgabeTopTop
        panelAusgabeTopTop.setBackground(null);
        panelAusgabeTopTop.setPreferredSize(new Dimension(500, 0));
        panelAusgabeTopTop.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelAusgabeTop.add(panelAusgabeTopTop, BorderLayout.WEST);
    }

    private void buildAusgabePanelCenter() {

        // panelAusgabeCenter
        panelAusgabeCenter.setBackground(Color.LIGHT_GRAY);
        panelAusgabeCenter.setLayout(new BorderLayout());
        panelAusgabeCenter.setPreferredSize(new Dimension(500, 0));
        panelAusgabe.add(panelAusgabeCenter, BorderLayout.WEST);
    }

    private void buildAusgabePanelBottom() {

        // panelAusgabeBottom
        panelAusgabeBottom.setBackground(colorCenterPanel);
        panelAusgabeBottom.setPreferredSize(new Dimension(0, 40));
        panelAusgabeBottom.setLayout(null);
        panelAusgabe.add(panelAusgabeBottom, BorderLayout.SOUTH);
    }

    // adds components to panelAusgabeTop
    private void initComponentsPanelAusgabeTop() {

        Font font = new Font(null, Font.BOLD, 20);
        int width = 200;

        // buttonOutput
        buttonOutput = new JButton("Ausgabe");
        buttonOutput.setFont(font);
        buttonOutput.setFocusable(false);
        buttonOutput.setBackground(Color.LIGHT_GRAY);
        buttonOutput.setPreferredSize(new Dimension(width, 40));
        panelAusgabeTopTop.add(buttonOutput);
        buttonOutput.addActionListener(this);
    }

    // adds components to panelAusgabeCenter
    private void initComponentsPanelAusgabeCenter() {

        //--------------------- General ---------------------
        Object[] columnsTitle = {"Figur", "Position", "Eingaben", "Eigenschaften"};
        row = new String[columnsTitle.length];
        //---------------------------------------------------

        model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return  false;
            }
        };
        model.setColumnIdentifiers(columnsTitle);

        tableAusgabe = new JTable();
        tableAusgabe.setModel(model);
        tableAusgabe.setFont(new Font(null, Font.PLAIN, 16));
        tableAusgabe.setRowHeight(30);
        tableAusgabe.getTableHeader().setReorderingAllowed(false);
        tableAusgabe.setFocusable(false);
        tableAusgabe.setRowSelectionAllowed(false);
        tableAusgabe.setVisible(true);

        // column default size
        TableColumn column;
        column = tableAusgabe.getColumnModel().getColumn(0);
        column.setPreferredWidth(60);
        column = tableAusgabe.getColumnModel().getColumn(1);
        column.setPreferredWidth(120);
        column = tableAusgabe.getColumnModel().getColumn(2);
        column.setPreferredWidth(160);
        column = tableAusgabe.getColumnModel().getColumn(3);
        column.setPreferredWidth(160);

        // set column location of input to center
        for (int i = 0; i < columnsTitle.length; i++) {
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            tableAusgabe.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            tableAusgabe.setDefaultRenderer(String.class, centerRenderer);
        }

        pane = new JScrollPane(tableAusgabe);
        panelAusgabeCenter.add(pane, BorderLayout.CENTER);
        pane.setVisible(false);
    }

    // adds components to panelAusgabeBottom
    private void initComponentsPanelAusgabeBottom() {
    }
    //------------------------------------------------------------------------------------------------------------

    //-------------------------------------------------- Action --------------------------------------------------
    public void actionPerformed(ActionEvent event) {

        // Figuren Auswahl (comboBox, componentsPanelEingabeCenter index 1)
        if (event.getSource() == componentsPanelEingabeCenter[1]) {

            // keine Figur (index 0)
            if (((JComboBox) componentsPanelEingabeCenter[1]).getSelectedIndex() == 0) {
                for (int i = 2; i < componentsPanelEingabeCenter.length; i++) {
                    componentsPanelEingabeCenter[i].setVisible(false);
                    resetTextFields();
                    buttonAdd.setVisible(false);
                }
            }
            // Rechteck
            else if (((JComboBox) componentsPanelEingabeCenter[1]).getSelectedItem() == "Rechteck") {
                for (int i = 0; i < componentsPanelEingabeCenter.length; i++) {
                    componentsPanelEingabeCenter[i].setVisible(i < 10);
                    resetTextFields();
                    buttonAdd.setVisible(true);
                }
            }
            // Kreis
            else if (((JComboBox) componentsPanelEingabeCenter[1]).getSelectedItem() == "Kreis") {
                for (int i = 0; i < componentsPanelEingabeCenter.length; i++) {
                    componentsPanelEingabeCenter[i].setVisible(i < 6 || i == 10 || i == 11);
                    resetTextFields();
                    buttonAdd.setVisible(true);
                }
            }
        }
        //-----------------------------------------------------------------------------------
        // Hinzufuegen (buttonAdd)
        else if (event.getSource() == buttonAdd && ((JComboBox) componentsPanelEingabeCenter[1]).getSelectedIndex() != 0) {

            //----------------------------------------------------------
            anzahlFiguren++;
            int index = anzahlFiguren - 1;

            // Main-Array (figuren) zwischnenspeichern in Array (figurenTemp)
            Figur[] figurenTemp = new Figur[figuren.length];
            for (int i = 0; i < figuren.length; i++) {
                figurenTemp[i] = figuren[i];
            }
            // Gespeichertes Array (figurenTemp) einfuegen in Main-Array (figuren)
            figuren = new Figur[anzahlFiguren];
            for (int i = 0; i < figuren.length - 1; i++) {
                figuren[i] = figurenTemp[i];
            }
            //----------------------------------------------------------

            // Rechteck
            if (((JComboBox) componentsPanelEingabeCenter[1]).getSelectedItem() == "Rechteck") {

                // Rechteck Eigenschaften in Array (eigenschaften) speichern [posX / posY / seiteA / seiteB]
                eigenschaften = inputToArray(rechteckTextFieldIndex);

                // check user input
                if (checklist == eigenschaften.length) {
                    figuren[index] = new Rechteck(eigenschaften[0], eigenschaften[1], eigenschaften[2], eigenschaften[3]);
                    rechteckTotalAmount++;
                    inputToArrayRow(index);
                    resetTextFields();

                    CenterPanelKoordinatensystem.panelKoordMain.repaint();
                }
            }
            // Kreis
            else if (((JComboBox) componentsPanelEingabeCenter[1]).getSelectedItem() == "Kreis") {

                // Kreis Eigenschaften in Array (eigenschaften) speichern [posX / posY / radius]
                eigenschaften = inputToArray(kreisTextFieldIndex);

                // check user input
                if (checklist == eigenschaften.length) {
                    figuren[index] = new Kreis(eigenschaften[0], eigenschaften[1], eigenschaften[2]);
                    kreisTotalAmount++;
                    inputToArrayRow(index);
                    resetTextFields();

                    CenterPanelKoordinatensystem.panelKoordMain.repaint();
                }
            }
        }
        //-----------------------------------------------------------------------------------
        // Input (buttonInput)
        else if (event.getSource() == buttonInput) {

            panelSettingsCenter.setVisibility(false);
            buildEingabePanelCenter();

            ((JComboBox) componentsPanelEingabeCenter[1]).setSelectedIndex(0);
        }
        //-----------------------------------------------------------------------------------
        // Appearance (buttonAppearance)
        else if (event.getSource() == buttonSettings) {

            panelSettingsCenter.setVisibility(true);
            buildEingabePanelCenter();

            buttonAdd.setVisible(false);
        }
    }
    //------------------------------------------------------------------------------------------------------------

    //-------------------------------------------------- Others --------------------------------------------------
    // reset all textFields to default
    private void resetTextFields() {

        for (int i = 0; i < componentsPanelEingabeCenter.length; i++) {
            if (componentsPanelEingabeCenter[i] instanceof JTextField) {
                ((JTextField) componentsPanelEingabeCenter[i]).setText("0");
                componentsPanelEingabeCenter[i].setBorder(null);
            }
        }
    }

    // saves user input in double array and checks for invalid inputs
    private double[] inputToArray(int[] textFieldIndex) {

        checklist = 0;
        double[] eigenschaften = new double[textFieldIndex.length];

        for (int i = 0; i < eigenschaften.length; i++) {

            if (i < 2) {
                if (((JTextField) componentsPanelEingabeCenter[textFieldIndex[i]]).getText().matches("^\\-?(\\d{0,2})(\\.\\d{0,2})?$")) {
                    eigenschaften[i] = Double.parseDouble(((JTextField) componentsPanelEingabeCenter[textFieldIndex[i]]).getText());
                    componentsPanelEingabeCenter[textFieldIndex[i]].setBorder(null);
                    checklist++;
                } else {
                    componentsPanelEingabeCenter[textFieldIndex[i]].setBorder(BorderFactory.createLineBorder(Color.red, 4));
                }
            }
            else {
                if (((JTextField) componentsPanelEingabeCenter[textFieldIndex[i]]).getText().matches("^(([1-9]\\d?(\\.\\d{0,2})?)|(0\\.\\d{0,2}))$")) {
                    eigenschaften[i] = Double.parseDouble(((JTextField) componentsPanelEingabeCenter[textFieldIndex[i]]).getText());
                    componentsPanelEingabeCenter[textFieldIndex[i]].setBorder(null);
                    checklist++;
                } else {
                    componentsPanelEingabeCenter[textFieldIndex[i]].setBorder(BorderFactory.createLineBorder(Color.red, 4));
                }
            }
        }
        return eigenschaften;
    }

    // saves user input (object attributes) in row array (used for output table)
    private void inputToArrayRow(int objectIndex) {

        if (figuren[objectIndex] instanceof Rechteck) {
            row[0] = "R" +rechteckTotalAmount;
            row[1] = figuren[objectIndex].objectPositionToString();
            row[2] = "a = " +Figur.cleanUpValue(((Rechteck) figuren[objectIndex]).getSeiteA())+ " | b = " +Figur.cleanUpValue(((Rechteck) figuren[objectIndex]).getSeiteB());
            row[3] = "A = " +Figur.cleanUpValue(((Rechteck) figuren[objectIndex]).flaeche());
        }
        else if (figuren[objectIndex] instanceof Kreis) {
            row[0] = "K" +kreisTotalAmount;
            row[1] = figuren[objectIndex].objectPositionToString();
            row[2] = "r = " +Figur.cleanUpValue(((Kreis) figuren[objectIndex]).getRadius());
            row[3] = "A = " +Figur.cleanUpValue(((Kreis) figuren[objectIndex]).flaeche());
        }
        model.addRow(row);
        pane.setVisible(true);
        panelAusgabeCenter.revalidate();
    }

    // reset all
    public void resetAll() {

        // comboBox reset to "Bitte auswählen"
        ((JComboBox) componentsPanelEingabeCenter[1]).setSelectedIndex(0);

        // change to panelEingabeCenter
        buttonInput.doClick();

        // remove all created objects
        anzahlFiguren = 0;
        figuren = new Figur[0];
        rechteckTotalAmount = 0;
        kreisTotalAmount = 0;

        // reset Koordinatensystem
        panelSettingsCenter.sliderScale.setValue(20);
        CenterPanelKoordinatensystem.panelKoordMain.repaint();

        // reset Output-table
        panelAusgabeCenter.remove(pane);
        panelAusgabeCenter.repaint();
        initComponentsPanelAusgabeCenter();
    }
    //------------------------------------------------------------------------------------------------------------
}
