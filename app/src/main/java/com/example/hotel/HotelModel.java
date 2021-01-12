package com.example.hotel;

import java.io.Serializable;

public class HotelModel implements Serializable {
    private int id;
    private String name;
    private String distance;
    private String city;
    private String price;
    private int rating;


    public HotelModel(int id, String name, String distance, String city, String price, int rating) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.city = city;
        this.price = price;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "HotelModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", distance='" + distance + '\'' +
                ", city='" + city + '\'' +
                ", price='" + price + '\'' +
                ", rating=" + rating +
                '}';
    }
}
