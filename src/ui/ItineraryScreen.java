/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cheru
 */

package ui;

import dao.ItineraryDAO;
import dao.ItineraryPlaceDAO;
import dao.PlaceDAO;
import model.Itinerary;
import model.ItineraryPlace;
import model.Place;
import model.User;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.List;

public class ItineraryScreen extends JFrame {

    private JButton btnSave, btnHome, btnLogout;
    private JTable tblSavedItineraries;
    private JTextArea txtGenerated;
    private JLabel lblBackground;
    private User currentUser;
    private int cityId;
    private double totalDuration;
    private double totalCost;
    private List<Place> selectedPlaces;


    public ItineraryScreen(User user, int cityId, List<Place> selectedPlaces, double totalDuration, double totalCost) {
    this.currentUser = user;
    this.cityId = cityId;
    this.totalDuration = totalDuration;
    this.totalCost = totalCost;
    this.selectedPlaces = selectedPlaces;
    initComponents();
    loadGeneratedItinerary();
    loadSavedItineraries();
}
    private void loadGeneratedItinerary() {
    StringBuilder sb = new StringBuilder();

    if (selectedPlaces == null || selectedPlaces.isEmpty()) {
        sb.append("No places were selected for this itinerary.");
    } else {
        for (int i = 0; i < selectedPlaces.size(); i++) {
            Place p = selectedPlaces.get(i);
            sb.append((i + 1) + ". " + p.getName() + " - ₹" + p.getEntryFee() + ", " + p.getVisitDuration() + " hrs\n");
        }
    }

    txtGenerated.setText(sb.toString());
}




    private void loadSavedItineraries() {
    List<Itinerary> itineraries = new ItineraryDAO().getUserItineraries(currentUser.getUserId());
    DefaultTableModel model = (DefaultTableModel) tblSavedItineraries.getModel();
    model.setRowCount(0);

    for (int i = 0; i < itineraries.size(); i++) {
        Itinerary itin = itineraries.get(i);
        List<ItineraryPlace> ipList = new ItineraryPlaceDAO().getPlacesForItinerary(itin.getItineraryId());

        StringBuilder itineraryText = new StringBuilder();
        for (ItineraryPlace ip : ipList) {
            Place place = new PlaceDAO().getPlaceById(ip.getPlaceId());
            if (place != null) itineraryText.append(place.getName()).append(" → ");
        }
        if (itineraryText.length() > 0) itineraryText.setLength(itineraryText.length() - 3); // Remove last arrow

        model.addRow(new Object[]{
            i + 1,
            itin.getCreatedOn().toString(),
            itineraryText.toString(),
            itin.getTotalDuration() + " hrs",
            "₹" + itin.getTotalCost()
        });
    }
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
        btnLogout.addActionListener(e -> {
            dispose();
            new LoginScreen().setVisible(true);
        });
        lblBackground.add(btnLogout);

        // Semi-transparent TextArea for generated itinerary (with rounded background)
        txtGenerated = new JTextArea();
        txtGenerated.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtGenerated.setForeground(Color.BLACK);
        txtGenerated.setOpaque(false);
        txtGenerated.setLineWrap(true);
        txtGenerated.setWrapStyleWord(true);
        txtGenerated.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollGenerated = new JScrollPane(txtGenerated);
        scrollGenerated.setOpaque(false);
        scrollGenerated.getViewport().setOpaque(false);
        scrollGenerated.setBorder(BorderFactory.createEmptyBorder());

        // Custom panel with transparent dark rounded background
        JPanel itineraryPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0, 0, 0, 120)); // Semi-transparent black
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Rounded corners
            }
        };
        itineraryPanel.setLayout(new BorderLayout());
        itineraryPanel.setBounds(30, 70, 830, 130);
        itineraryPanel.setOpaque(false);
        itineraryPanel.add(scrollGenerated, BorderLayout.CENTER);

        // Add the new rounded panel instead of direct scroll pane
        formPanel.add(itineraryPanel);


        // Save & Home buttons
        btnSave = new JButton("Save Itinerary");
        btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnSave.setBounds(250, 210, 180, 40);
        btnSave.addActionListener(e -> {
        Itinerary itinerary = new Itinerary(0, currentUser.getUserId(), cityId, totalDuration, totalCost, null);
        int itineraryId = new ItineraryDAO().createItinerary(itinerary);

        for (int i = 0; i < selectedPlaces.size(); i++) {
            ItineraryPlace ip = new ItineraryPlace(itineraryId, selectedPlaces.get(i).getPlaceId(), i + 1);
            new ItineraryPlaceDAO().addPlaceToItinerary(ip);
        }

        JOptionPane.showMessageDialog(this, "Itinerary Saved Successfully!");
        loadSavedItineraries();
    });

        formPanel.add(btnSave);
        

        btnHome = new JButton("Go To Home");
        btnHome.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btnHome.setBounds(470, 210, 180, 40);
        btnHome.addActionListener(e -> {
        dispose();
        new HomeScreen(currentUser).setVisible(true);
    });

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
}

