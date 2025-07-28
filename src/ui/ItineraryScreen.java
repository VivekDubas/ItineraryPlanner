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
import javax.swing.table.*;
import java.awt.*;

public class ItineraryScreen extends JFrame {

    private JButton btnSave, btnHome, btnLogout;
    private JTable tblSavedItineraries;
    private JTextArea txtGenerated;
    private JLabel lblBackground;

    public ItineraryScreen() {
        initComponents();
    }

    private void initComponents() {
        // Full screen setup
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        setSize(width, height);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Itinerary Planner - Itinerary");

        // Background image
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Resources/travel4.jpeg"));
        Image img = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        lblBackground = new JLabel(new ImageIcon(img));
        lblBackground.setBounds(0, 0, width, height);
        lblBackground.setLayout(null);

        // Centered RoundedPanel
        int formWidth = 900;
        int formHeight = 600;
        int x = (width - formWidth) / 2;
        int y = (height - formHeight) / 2 - 50;

        RoundedPanel formPanel = new RoundedPanel(30);
        formPanel.setLayout(null);
        formPanel.setBounds(x, y, formWidth, formHeight);

        // Title
        JLabel lblTitle = new JLabel("Generated Itinerary");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(30, 20, 400, 40);
        formPanel.add(lblTitle);

        // Logout Button (top-right of screen)
        btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnLogout.setBounds(width - 140, 20, 120, 40);
        lblBackground.add(btnLogout);

        // Semi-transparent TextArea for generated itinerary
        txtGenerated = new JTextArea();
        txtGenerated.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtGenerated.setForeground(Color.WHITE);
        txtGenerated.setOpaque(false);
        txtGenerated.setLineWrap(true);
        txtGenerated.setWrapStyleWord(true);
        txtGenerated.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollGenerated = new JScrollPane(txtGenerated);
        scrollGenerated.setBounds(30, 70, 830, 130);
        scrollGenerated.setOpaque(false);
        scrollGenerated.getViewport().setOpaque(false);
        scrollGenerated.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 100), 1));
        formPanel.add(scrollGenerated);

        // Save & Home buttons
        btnSave = new JButton("Save Itinerary");
        btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnSave.setBounds(250, 210, 180, 40);
        formPanel.add(btnSave);

        btnHome = new JButton("Go To Home");
        btnHome.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnHome.setBounds(470, 210, 180, 40);
        formPanel.add(btnHome);

        // Label: Saved Itineraries
        JLabel lblSaved = new JLabel("Saved Itineraries");
        lblSaved.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblSaved.setForeground(Color.WHITE);
        lblSaved.setBounds(30, 270, 400, 40);
        formPanel.add(lblSaved);

        // Table setup
        String[] columns = {"S.No", "Date", "Itinerary", "Duration", "Cost"};
        Object[][] data = {
            {1, "28-07-2025", "Mysore Palace → Zoo", "1 Day", "₹2000"},
            {2, "29-07-2025", "Delhi Fort → India Gate", "2 Days", "₹4500"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        tblSavedItineraries = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table non-editable
            }
        };

        tblSavedItineraries.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        tblSavedItineraries.setRowHeight(30);
        tblSavedItineraries.setForeground(Color.WHITE);
        tblSavedItineraries.setOpaque(false);
        ((DefaultTableCellRenderer) tblSavedItineraries.getDefaultRenderer(Object.class)).setOpaque(false);

        JTableHeader header = tblSavedItineraries.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 18));
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(0, 0, 0, 150));
        header.setOpaque(false);

        JScrollPane tableScroll = new JScrollPane(tblSavedItineraries);
        tableScroll.setBounds(30, 320, 830, 230);
        tableScroll.setOpaque(false);
        tableScroll.getViewport().setOpaque(false);
        tableScroll.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 100), 1));
        formPanel.add(tableScroll);

        // Set specific column widths
        TableColumnModel colModel = tblSavedItineraries.getColumnModel();
        colModel.getColumn(0).setPreferredWidth(50);   // S.No
        colModel.getColumn(1).setPreferredWidth(100);  // Date
        colModel.getColumn(2).setPreferredWidth(400);  // Itinerary
        colModel.getColumn(3).setPreferredWidth(100);  // Duration
        colModel.getColumn(4).setPreferredWidth(100);  // Cost

        // Add everything to background
        lblBackground.add(formPanel);
        add(lblBackground);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ItineraryScreen().setVisible(true));
    }
}

