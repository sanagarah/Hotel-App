package com.example.hotel;

import java.io.Serializable;
import java.util.Date;

public class ReservationModel implements Serializable {
    private HotelModel hotel;
    private String rooms;
    private String adults;
    private String children;
    private String checkIn;
    private String checkOut;

    public ReservationModel(HotelModel hotel, String rooms, String adults, String children, String checkIn, String checkOut) {
        this.hotel = hotel;
        this.rooms = rooms;
        this.adults = adults;
        this.children = children;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public HotelModel getHotel() {
        return hotel;
    }

    public void setHotel(HotelModel hotel) {
        this.hotel = hotel;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
