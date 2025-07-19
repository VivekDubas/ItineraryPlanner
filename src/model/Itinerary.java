/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class Itinerary {
    private int itineraryId;
    private int userId;
    private int cityId;
    private double totalDuration;
    private double totalCost;
    private Date createdOn;

    public Itinerary() {}

    public Itinerary(int itineraryId, int userId, int cityId, double totalDuration, double totalCost, Date createdOn) {
        this.itineraryId = itineraryId;
        this.userId = userId;
        this.cityId = cityId;
        this.totalDuration = totalDuration;
        this.totalCost = totalCost;
        this.createdOn = createdOn;
    }

    // Getters and Setters
    public int getItineraryId() { return itineraryId; }
    public void setItineraryId(int itineraryId) { this.itineraryId = itineraryId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getCityId() { return cityId; }
    public void setCityId(int cityId) { this.cityId = cityId; }

    public double getTotalDuration() { return totalDuration; }
    public void setTotalDuration(double totalDuration) { this.totalDuration = totalDuration; }

    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    public Date getCreatedOn() { return createdOn; }
    public void setCreatedOn(Date createdOn) { this.createdOn = createdOn; }
}
