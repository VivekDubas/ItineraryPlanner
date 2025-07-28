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
    
    public List<Place> getPlacesByCityAndTags(int cityId, List<String> tagNames) {
    List<Place> places = new ArrayList<>();
    if (tagNames == null || tagNames.isEmpty()) return getPlacesByCityId(cityId);

    StringBuilder sql = new StringBuilder(
        "SELECT DISTINCT p.* FROM places p " +
        "JOIN place_tag_map ptm ON p.place_id = ptm.place_id " +
        "JOIN place_tags t ON ptm.tag_id = t.tag_id " +
        "WHERE p.city_id = ? AND t.tag_name IN ("
    );

    // Build placeholders (?, ?, ...)
    for (int i = 0; i < tagNames.size(); i++) {
        sql.append("?");
        if (i < tagNames.size() - 1) sql.append(", ");
    }
    sql.append(")");

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

        stmt.setInt(1, cityId);
        for (int i = 0; i < tagNames.size(); i++) {
            stmt.setString(i + 2, tagNames.get(i));  // +2 because cityId is at index 1
        }

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
