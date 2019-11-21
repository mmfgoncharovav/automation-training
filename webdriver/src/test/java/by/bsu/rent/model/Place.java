package by.bsu.rent.model;

import java.util.Objects;

public class Place {
    private String country;
    private String city;
    private String placeInCity;

    public Place(String country, String city, String placeInCity) {
        this.country = country;
        this.city = city;
        this.placeInCity = placeInCity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlaceInCity() {
        return placeInCity;
    }

    public void setPlaceInCity(String placeInCity) {
        this.placeInCity = placeInCity;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return country.equals(place.country) &&
                city.equals(place.city) &&
                placeInCity.equals(place.placeInCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, placeInCity);
    }

    @Override
    public String toString() {
        return "Place{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", placeInCity='" + placeInCity + '\'' +
                '}';
    }
}
