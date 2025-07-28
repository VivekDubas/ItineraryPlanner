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
import java.util.ArrayList;
import java.util.List;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;


import model.City;
import model.Tag;
import model.User;
import dao.CityDAO;
import dao.TagDAO;
import dao.PlaceDAO;
import model.Place;


public class HomeScreen extends JFrame {

    private JComboBox<String> cmbCity;
    private JTextField txtTime, txtBudget;
    private JButton btnGenerate, btnLogout;
    private JLabel lblBackground;
    private JPanel tagPanel;

    private User currentUser;

    public HomeScreen(User user) {
        this.currentUser = user;
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
        btnGenerate.addActionListener(e -> generateItinerary());
        formPanel.add(btnGenerate, gbc);

        // Logout Button (top right)
        btnLogout = new JButton("Logout");
        btnLogout.setFont(inputFont);
        btnLogout.setBounds(width - 140, 20, 120, 40);
        lblBackground.add(btnLogout);

        lblBackground.add(formPanel);
        add(lblBackground);
        
        btnLogout.addActionListener(e -> {
            dispose();
            new LoginScreen().setVisible(true);
        });

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
    
    private void generateItinerary() {
    String selectedCity = (String) cmbCity.getSelectedItem();
    String timeStr = txtTime.getText().trim();
    String budgetStr = txtBudget.getText().trim();

    if (selectedCity == null || timeStr.isEmpty() || budgetStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;
    }

    try {
        double maxTime = Double.parseDouble(timeStr);
        double maxBudget = Double.parseDouble(budgetStr);

        int cityId = new CityDAO().getAllCities().stream()
                .filter(c -> c.getCityName().equals(selectedCity))
                .findFirst().orElseThrow().getCityId();

        List<String> selectedTags = new ArrayList<>();
        for (Component comp : tagPanel.getComponents()) {
            if (comp instanceof JCheckBox checkBox && checkBox.isSelected()) {
                selectedTags.add(checkBox.getText());
            }
        }

        PlaceDAO placeDAO = new PlaceDAO();
        List<Place> filteredPlaces = placeDAO.getPlacesByCityAndTags(cityId, selectedTags);

        // Simple greedy selection based on time + budget
        List<Place> selectedPlaces = new ArrayList<>();
        double totalTime = 0, totalCost = 0;

        for (Place place : filteredPlaces) {
            if (totalTime + place.getVisitDuration() <= maxTime &&
                totalCost + place.getEntryFee() <= maxBudget) {
                selectedPlaces.add(place);
                totalTime += place.getVisitDuration();
                totalCost += place.getEntryFee();
            }
        }

        if (selectedPlaces.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No places match your criteria.");
        } else {
            StringBuilder sb = new StringBuilder("Generated Itinerary:\n");
            for (Place p : selectedPlaces) {
                sb.append("- ").append(p.getName())
                  .append(" (").append(p.getVisitDuration()).append(" hrs, ₹")
                  .append(p.getEntryFee()).append(")\n");
            }
            sb.append("\nTotal Time: ").append(totalTime).append(" hrs");
            sb.append("\nTotal Cost: ₹").append(totalCost);
            // Launch ItineraryScreen with data
            ItineraryScreen itineraryScreen = new ItineraryScreen(
                currentUser,
                cityId,
                selectedPlaces,
                totalTime,
                totalCost
            );
            itineraryScreen.setVisible(true);
            dispose(); // Close HomeScreen

        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers for time and budget.");
    }
}


}
