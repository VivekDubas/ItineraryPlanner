/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class City {
    private int cityId;
    private String cityName;
    private String state;
    private String country;

    public City() {}

    public City(int cityId, String cityName, String state, String country) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.state = state;
        this.country = country;
    }

    // Getters and Setters
    public int getCityId() { return cityId; }
    public void setCityId(int cityId) { this.cityId = cityId; }

    public String getCityName() { return cityName; }
    public void setCityName(String cityName) { this.cityName = cityName; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}

