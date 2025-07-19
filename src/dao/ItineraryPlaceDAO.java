package dao;

import db.DBConnection;
import model.ItineraryPlace;

import java.sql.*;
import java.util.*;

public class ItineraryPlaceDAO {

    // Add a place to an itinerary along with visit order
    public void addPlaceToItinerary(ItineraryPlace itineraryPlace) {
        String sql = "INSERT INTO itinerary_places (itinerary_id, place_id, visit_order) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itineraryPlace.getItineraryId());
            stmt.setInt(2, itineraryPlace.getPlaceId());
            stmt.setInt(3, itineraryPlace.getVisitOrder());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all places for an itinerary, ordered by visit_order
    public List<ItineraryPlace> getPlacesForItinerary(int itineraryId) {
        List<ItineraryPlace> list = new ArrayList<>();
        String sql = "SELECT * FROM itinerary_places WHERE itinerary_id = ? ORDER BY visit_order";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itineraryId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ItineraryPlace ip = new ItineraryPlace(
                    rs.getInt("itinerary_id"),
                    rs.getInt("place_id"),
                    rs.getInt("visit_order")
                );
                list.add(ip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Optional: Delete a place from an itinerary
    public void removePlaceFromItinerary(int itineraryId, int placeId) {
        String sql = "DELETE FROM itinerary_places WHERE itinerary_id = ? AND place_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itineraryId);
            stmt.setInt(2, placeId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
