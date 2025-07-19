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
import model.Itinerary;
import java.sql.*;
import java.util.*;

public class ItineraryDAO {
    public int createItinerary(Itinerary itinerary) {
        String sql = "INSERT INTO itineraries (user_id, title, created_at) VALUES (?, ?, SYSDATE)";
        int itineraryId = -1;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"itinerary_id"})) {

            stmt.setInt(1, itinerary.getUserId());
            stmt.setString(2, itinerary.getTitle());
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
        String sql = "SELECT * FROM itineraries WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Itinerary i = new Itinerary(
                    rs.getInt("itinerary_id"),
                    rs.getInt("user_id"),
                    rs.getString("title"),
                    rs.getDate("created_at")
                );
                list.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

