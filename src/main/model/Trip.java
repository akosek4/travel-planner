package model;

// Represents a Trip having a name, date, and internal details

import java.util.ArrayList;

public class Trip {
    private String name;
    private String date;
    private Flight flight;
    private Hotel hotel;
    private ArrayList<Activity> activities;
    private int price;

    // EFFECTS: creates a trip with a name, a date, a flight, a hotel, and a price
    public Trip(String name, String date, Flight flight, Hotel hotel) {
        this.name = name;
        this.date = date;
        this.flight = flight;
        this.hotel = hotel;
        this.price = flight.getFlightPrice() + hotel.getHotelPrice();
    }
        //TODO add activity price

    public String getTripName() {
        return name;
    }

    public String getTripDate() {
        return date;
    }

    public int getTripPrice() {
        return price;
    }

    public Flight getFlight() {
        return flight;
    }

    public Hotel getHotel() {
        return hotel;
    }

}
