/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author cheru
 */

import dao.UserDAO;
import model.User;

public class TestUserDAO {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        // Test Registration
        User newUser = new User(1,"Alice", "alice@example.com", "pass123");
        boolean success = dao.registerUser(newUser);
        System.out.println("Registration successful? " + success);

        // Test Login
        User loggedIn = dao.login("alice@example.com", "pass123");
        if (loggedIn != null) {
            System.out.println("Login successful. Welcome: " + loggedIn.getName());
        } else {
            System.out.println("Login failed.");
        }
    }
}
