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
import model.Place;
import java.sql.*;
import java.util.*;

public class PlaceDAO {
    public List<Place> getPlacesByCityId(int cityId) {
        List<Place> places = new ArrayList<>();
        String sql = "SELECT * FROM places WHERE city_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cityId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Place place = new Place(
                    rs.getInt("place_id"),
                    rs.getString("name"),
                    rs.getInt("city_id"),
                    rs.getDouble("visit_duration"),
                    rs.getDouble("entry_fee"),
                    rs.getString("description")
                );
                places.add(place);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return places;
    }
}
