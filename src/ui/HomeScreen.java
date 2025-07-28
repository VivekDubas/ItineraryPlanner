/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cheru
 */
package ui;

import dao.CityDAO;
import dao.TagDAO;
import model.City;
import model.Tag;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HomeScreen extends JFrame {

    private JComboBox<String> cmbCity;
    private JTextField txtTime, txtBudget;
    private JButton btnGenerate, btnLogout;
    private JLabel lblBackground;
    private JPanel tagPanel;

    public HomeScreen() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Itinerary Planner - Home");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(width, height);
        setLocationRelativeTo(null);
        setLayout(null);

        // Background image
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Resources/travel4.jpeg"));
        Image img = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        lblBackground = new JLabel(new ImageIcon(img));
        lblBackground.setBounds(0, 0, width, height);
        lblBackground.setLayout(null);

        // Center form panel
        int formWidth = 900;
        int formHeight = 600;
        int x = (width - formWidth) / 2;
        int y = (height - formHeight) / 2 - 50;

        RoundedPanel formPanel = new RoundedPanel(30);
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBounds(x, y, formWidth, formHeight);
        formPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 24);
        Font inputFont = new Font("Segoe UI", Font.PLAIN, 18);
        Dimension inputSize = new Dimension(250, 35);

        // Title
        JLabel lblTitle = new JLabel("Itinerary Planner");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 40));
        lblTitle.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(lblTitle, gbc);
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // City
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblCity = new JLabel("City:");
        lblCity.setFont(labelFont);
        lblCity.setForeground(Color.WHITE);
        formPanel.add(lblCity, gbc);

        gbc.gridx = 1;
        cmbCity = new JComboBox<>();
        cmbCity.setFont(inputFont);
        cmbCity.setPreferredSize(inputSize);
        formPanel.add(cmbCity, gbc);
        loadCities();

        // Time
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblTime = new JLabel("Time (in hours):");
        lblTime.setFont(labelFont);
        lblTime.setForeground(Color.WHITE);
        formPanel.add(lblTime, gbc);

        gbc.gridx = 1;
        txtTime = new JTextField();
        txtTime.setFont(inputFont);
        txtTime.setPreferredSize(inputSize);
        formPanel.add(txtTime, gbc);

        // Budget
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblBudget = new JLabel("Budget (in ₹):");
        lblBudget.setFont(labelFont);
        lblBudget.setForeground(Color.WHITE);
        formPanel.add(lblBudget, gbc);

        gbc.gridx = 1;
        txtBudget = new JTextField();
        txtBudget.setFont(inputFont);
        txtBudget.setPreferredSize(inputSize);
        formPanel.add(txtBudget, gbc);

        // Tags
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblTags = new JLabel("Tags:");
        lblTags.setFont(labelFont);
        lblTags.setForeground(Color.WHITE);
        formPanel.add(lblTags, gbc);

        gbc.gridx = 1;
        tagPanel = new JPanel();
        tagPanel.setOpaque(false);
        tagPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        formPanel.add(tagPanel, gbc);
        loadTags();

        // Generate Button
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        btnGenerate = new JButton("Generate Itinerary");
        btnGenerate.setFont(inputFont);
        formPanel.add(btnGenerate, gbc);

        // Logout Button (top right)
        btnLogout = new JButton("Logout");
        btnLogout.setFont(inputFont);
        btnLogout.setBounds(width - 140, 20, 120, 40);
        lblBackground.add(btnLogout);

        lblBackground.add(formPanel);
        add(lblBackground);
    }

    private void loadCities() {
        CityDAO cityDAO = new CityDAO();
        List<City> cities = cityDAO.getAllCities();
        for (City city : cities) {
            cmbCity.addItem(city.getCityName());
        }
    }

    private void loadTags() {
        TagDAO tagDAO = new TagDAO();
        List<Tag> tags = tagDAO.getAllTags();
        for (Tag tag : tags) {
            JCheckBox checkBox = new JCheckBox(tag.getTagName());
            checkBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            checkBox.setOpaque(false);
            checkBox.setForeground(Color.WHITE);
            tagPanel.add(checkBox);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomeScreen().setVisible(true));
    }
}
