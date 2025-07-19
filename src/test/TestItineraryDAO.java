/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.ItineraryDAO;
import model.Itinerary;

import java.util.Date;
import java.util.List;

public class TestItineraryDAO {
    public static void main(String[] args) {
        ItineraryDAO dao = new ItineraryDAO();

        // Test case: Create a new itinerary
        Itinerary itinerary = new Itinerary();
        itinerary.setUserId(1);        // Make sure user_id 1 exists
        itinerary.setCityId(1);        // Make sure city_id 1 exists
        itinerary.setTotalDuration(3.5);
        itinerary.setTotalCost(1200.75);
        itinerary.setCreatedOn(new Date());

        int newId = dao.createItinerary(itinerary);
        if (newId != -1) {
            System.out.println("Itinerary created with ID: " + newId);
        } else {
            System.out.println("Failed to create itinerary.");
        }

        // Test case: Fetch all itineraries of a user
        int userId = 1; // same user_id used above
        List<Itinerary> itineraries = dao.getUserItineraries(userId);
        System.out.println("Itineraries for user ID " + userId + ":");

        if (itineraries.isEmpty()) {
            System.out.println("No itineraries found.");
        } else {
            for (Itinerary i : itineraries) {
                System.out.println("ID: " + i.getItineraryId() +
                                   ", City ID: " + i.getCityId() +
                                   ", Duration: " + i.getTotalDuration() +
                                   ", Cost: " + i.getTotalCost() +
                                   ", Created On: " + i.getCreatedOn());
            }
        }
    }
}
