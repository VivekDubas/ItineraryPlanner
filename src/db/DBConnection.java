/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/orclpdb";
    private static final String USER = "system";   // Replace with your Oracle username
    private static final String PASS = "hello";   // Replace with your password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("✅ Connected to Oracle Database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
