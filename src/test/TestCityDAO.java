package test;

import dao.CityDAO;
import model.City;
import java.util.List;

public class TestCityDAO {
public static void main(String[] args) {
CityDAO cityDAO = new CityDAO();
    List<City> cities = cityDAO.getAllCities();

    if (cities.isEmpty()) {
        System.out.println("⚠️ No cities found in the database.");
    } else {
        System.out.println("✅ List of cities:");
        for (City city : cities) {
            System.out.println("---------------------------------");
            System.out.println("City ID   : " + city.getCityId());
            System.out.println("Name      : " + city.getCityName());
            System.out.println("State     : " + city.getState());
            System.out.println("Country   : " + city.getCountry());
        }
    }
}
}
