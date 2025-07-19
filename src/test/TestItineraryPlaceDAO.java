/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.ItineraryPlaceDAO;
import model.ItineraryPlace;

import java.util.List;

public class TestItineraryPlaceDAO {
    public static void main(String[] args) {
        ItineraryPlaceDAO dao = new ItineraryPlaceDAO();

        // Make sure these IDs exist in your DB before running
        int itineraryId = 1; // existing itinerary_id
        int placeId = 1;     // existing place_id

        // Test 1: Add a place to an itinerary
        ItineraryPlace ip = new ItineraryPlace(itineraryId, placeId, 1);
        dao.addPlaceToItinerary(ip);
        System.out.println("Added place ID " + placeId + " to itinerary ID " + itineraryId + " with visit order 1.");

        // Test 2: Retrieve all places for a specific itinerary
        List<ItineraryPlace> places = dao.getPlacesForItinerary(itineraryId);
        System.out.println("Places for itinerary ID " + itineraryId + ":");
        if (places.isEmpty()) {
            System.out.println("No places found.");
        } else {
            for (ItineraryPlace p : places) {
                System.out.println("Place ID: " + p.getPlaceId() + ", Visit Order: " + p.getVisitOrder());
            }
        }

        // Optional: Test 3 - Remove a place
        // dao.removePlaceFromItinerary(itineraryId, placeId);
        // System.out.println("Removed place ID " + placeId + " from itinerary ID " + itineraryId);
    }
}

