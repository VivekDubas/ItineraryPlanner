/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cheru
 */
package dao;

import db.DBConnection;
import java.sql.*;
import java.util.*;

public class ItineraryPlaceDAO {
    public void addPlaceToItinerary(int itineraryId, int placeId) {
        String sql = "INSERT INTO itinerary_places (itinerary_id, place_id) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itineraryId);
            stmt.setInt(2, placeId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getPlacesForItinerary(int itineraryId) {
        List<Integer> placeIds = new ArrayList<>();
        String sql = "SELECT place_id FROM itinerary_places WHERE itinerary_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itineraryId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                placeIds.add(rs.getInt("place_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placeIds;
    }
}

