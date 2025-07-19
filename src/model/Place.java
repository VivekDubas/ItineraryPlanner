/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Place {
    private int placeId;
    private String name;
    private int cityId;
    private double visitDuration;
    private double entryFee;
    private String description;

    public Place() {}

    public Place(int placeId, String name, int cityId, double visitDuration, double entryFee, String description) {
        this.placeId = placeId;
        this.name = name;
        this.cityId = cityId;
        this.visitDuration = visitDuration;
        this.entryFee = entryFee;
        this.description = description;
    }

    // Getters and Setters
    public int getPlaceId() { return placeId; }
    public void setPlaceId(int placeId) { this.placeId = placeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCityId() { return cityId; }
    public void setCityId(int cityId) { this.cityId = cityId; }

    public double getVisitDuration() { return visitDuration; }
    public void setVisitDuration(double visitDuration) { this.visitDuration = visitDuration; }

    public double getEntryFee() { return entryFee; }
    public void setEntryFee(double entryFee) { this.entryFee = entryFee; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

