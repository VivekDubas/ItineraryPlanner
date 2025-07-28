/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cheru
 */
package ui;

import javax.swing.*;
import java.awt.*;
import ui.RoundedPanel;

public class HomeScreen extends JFrame {

    // Declare components
    private JComboBox<String> cmbCity, cmbTime, cmbBudget;
    private JCheckBox chkTag1, chkTag2, chkTag3;
    private JButton btnGenerate, btnLogout;
    private JLabel lblBackground;

    public HomeScreen() {
        initComponents();
    }

    private void initComponents() {
        // Frame setup
        setTitle("Itinerary Planner - Home");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
        setUndecorated(false); // Allows title bar (optional)

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        setSize(width, height);
        setLocationRelativeTo(null);
        setLayout(null); // Absolute layout for background

        // Load and scale background image
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Resources/travel4.jpeg"));
        Image img = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        lblBackground = new JLabel(new ImageIcon(img));
        lblBackground.setBounds(0, 0, width, height);
        lblBackground.setLayout(null);

        // Updated size for form panel
        int formWidth = 900;
        int formHeight = 600;
        int x = (width - formWidth) / 2;
        int y = (height - formHeight) / 2 - 50;

        // Panel for form (semi-transparent, rounded)
        RoundedPanel formPanel = new RoundedPanel(30);
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBounds(x, y, formWidth, formHeight);
        formPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.WEST;
        
                // Font and size setup
        Font labelFont = new Font("Segoe UI", Font.PLAIN, 24);
        Font comboFont = new Font("Segoe UI", Font.PLAIN, 18);
        Dimension comboBoxSize = new Dimension(250, 35);  // slightly bigger for readability

        

                // Title
        JLabel lblTitle = new JLabel("Itinerary Planner");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 40));
        lblTitle.setForeground(Color.WHITE);

        // Row 0: Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 15, 10, 15); // LESS TOP PADDING = MOVES TITLE UP
        formPanel.add(lblTitle, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(15, 15, 15, 15); // reset default insets


                // Row 1: City
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblCity = new JLabel("City:");
        lblCity.setForeground(Color.WHITE);
        lblCity.setFont(labelFont);
        formPanel.add(lblCity, gbc);

        gbc.gridx = 1;
        cmbCity = new JComboBox<>(new String[]{"Select", "Delhi", "Mumbai", "Mysore"});
        cmbCity.setFont(comboFont);
        cmbCity.setPreferredSize(comboBoxSize);
        formPanel.add(cmbCity, gbc);


                // Row 2: Time
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblTime = new JLabel("Time:");
        lblTime.setForeground(Color.WHITE);
        lblTime.setFont(labelFont);
        formPanel.add(lblTime, gbc);

        gbc.gridx = 1;
        cmbTime = new JComboBox<>(new String[]{"1 Day", "2 Days", "Weekend"});
        cmbTime.setFont(comboFont);
        cmbTime.setPreferredSize(comboBoxSize);
        formPanel.add(cmbTime, gbc);


                // Row 3: Budget
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblBudget = new JLabel("Budget:");
        lblBudget.setForeground(Color.WHITE);
        lblBudget.setFont(labelFont);
        formPanel.add(lblBudget, gbc);

        gbc.gridx = 1;
        cmbBudget = new JComboBox<>(new String[]{"< ₹2000", "₹2000 - ₹5000", "> ₹5000"});
        cmbBudget.setFont(comboFont);
        cmbBudget.setPreferredSize(comboBoxSize);
        formPanel.add(cmbBudget, gbc);

                // Row 4: Tags
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblTags = new JLabel("Tags:");
        lblTags.setForeground(Color.WHITE);
        lblTags.setFont(labelFont);
        formPanel.add(lblTags, gbc);

        gbc.gridx = 1;
        JPanel tagPanel = new JPanel();
        tagPanel.setOpaque(false);

        chkTag1 = new JCheckBox("Nature");
        chkTag2 = new JCheckBox("History");
        chkTag3 = new JCheckBox("Adventure");

        chkTag1.setFont(comboFont);
        chkTag2.setFont(comboFont);
        chkTag3.setFont(comboFont);

        tagPanel.add(chkTag1);
        tagPanel.add(chkTag2);
        tagPanel.add(chkTag3);
        formPanel.add(tagPanel, gbc);


        // Row 5: Generate Button
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        btnGenerate = new JButton("Generate Itinerary");
        btnGenerate.setFont(comboFont);
        formPanel.add(btnGenerate, gbc);

        // Logout Button (top-right, adjusted)
        btnLogout = new JButton("Logout");
        btnLogout.setFont(comboFont);
        btnLogout.setBounds(width - 140, 20, 120, 40);// Adjust based on screen width
        lblBackground.add(btnLogout);

        // Add to background
        lblBackground.add(formPanel);
        add(lblBackground);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomeScreen().setVisible(true));
    }
}
