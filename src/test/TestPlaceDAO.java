/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cheru
 */
package test;

import dao.PlaceDAO;
import model.Place;

import java.util.List;

public class TestPlaceDAO {
public static void main(String[] args) {
    int testCityId = 1;
        System.out.println(" Fetching places for city_id = " + testCityId);
    PlaceDAO placeDAO = new PlaceDAO();
    List<Place> places = placeDAO.getPlacesByCityId(testCityId);

    if (places.isEmpty()) {
        System.out.println("️No places found for city_id = " + testCityId);
    } else {
        System.out.println(" Found " + places.size() + " places:");
        for (Place place : places) {
            System.out.println("------------------------------");
            System.out.println("Place ID       : " + place.getPlaceId());
            System.out.println("Name           : " + place.getName());
            System.out.println("City ID        : " + place.getCityId());
            System.out.println("Visit Duration : " + place.getVisitDuration());
            System.out.println("Entry Fee      : " + place.getEntryFee());
            System.out.println("Description    : " + place.getDescription());
        }
    }
}
}