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
import model.City;
import java.sql.*;
import java.util.*;

public class CityDAO {
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT city_id, city_name, state, country FROM cities";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                City city = new City(
                    rs.getInt("city_id"),
                    rs.getString("city_name"),
                    rs.getString("state"),
                    rs.getString("country")
                );
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }
}

