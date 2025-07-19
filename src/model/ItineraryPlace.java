/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class ItineraryPlace {
    private int itineraryId;
    private int placeId;
    private int visitOrder;

    public ItineraryPlace() {}

    public ItineraryPlace(int itineraryId, int placeId, int visitOrder) {
        this.itineraryId = itineraryId;
        this.placeId = placeId;
        this.visitOrder = visitOrder;
    }

    // Getters and Setters
    public int getItineraryId() { return itineraryId; }
    public void setItineraryId(int itineraryId) { this.itineraryId = itineraryId; }

    public int getPlaceId() { return placeId; }
    public void setPlaceId(int placeId) { this.placeId = placeId; }

    public int getVisitOrder() { return visitOrder; }
    public void setVisitOrder(int visitOrder) { this.visitOrder = visitOrder; }
}

