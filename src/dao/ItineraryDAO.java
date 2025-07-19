package dao;

import db.DBConnection;
import model.Itinerary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItineraryDAO {

    public int createItinerary(Itinerary itinerary) {
        String sql = "INSERT INTO itineraries (user_id, city_id, total_duration, total_cost, created_on) " +
                     "VALUES (?, ?, ?, ?, SYSDATE)";
        int itineraryId = -1;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"itinerary_id"})) {

            stmt.setInt(1, itinerary.getUserId());
            stmt.setInt(2, itinerary.getCityId());
            stmt.setDouble(3, itinerary.getTotalDuration());
            stmt.setDouble(4, itinerary.getTotalCost());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                itineraryId = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itineraryId;
    }

    public List<Itinerary> getUserItineraries(int userId) {
        List<Itinerary> list = new ArrayList<>();
        String sql = "SELECT * FROM itineraries WHERE user_id = ? ORDER BY created_on DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Itinerary itinerary = new Itinerary(
                        rs.getInt("itinerary_id"),
                        rs.getInt("user_id"),
                        rs.getInt("city_id"),
                        rs.getDouble("total_duration"),
                        rs.getDouble("total_cost"),
                        rs.getDate("created_on")
                );
                list.add(itinerary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
