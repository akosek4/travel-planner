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
        //TODO 1: add activity price

    // REQUIRES: hotelPrice >= 0, hotelDuration >0
    // MODIFIES: this
    // EFFECTS: changes the all current details about the hotel to parameter
    public void changeAllHotelDetails(String hotelName, int hotelPrice, String hotelDate, int hotelDuration,
                                   String hotelLocation) {
        hotel.changeHotelLocation(hotelLocation);
        hotel.changeHotelDate(hotelDate);
        hotel.changeHotelName(hotelName);
        hotel.changeHotelPrice(hotelPrice);
        hotel.changeHotelDuration(hotelDuration);
    }

    // MODIFIES: this
    // EFFECTS: changes the current hotel name to the parameter
    public void changeHotelName(String hotelName) {
        hotel.changeHotelName(hotelName);
    }

    // REQUIRES: hotelPrice >= 0
    // MODIFIES: this
    // EFFECTS: changes the current hotel price about to the parameter
    public void changeHotelPrice(int hotelPrice) {
        hotel.changeHotelPrice(hotelPrice);
    }

    // MODIFIES: this
    // EFFECTS: changes the current hotel date to the parameter
    public void changeHotelDate(String hotelDate) {
        hotel.changeHotelDate(hotelDate);
    }

    // REQUIRES: hotelDuration > 0
    // MODIFIES: this
    // EFFECTS: changes the current hotel duration about to the parameter
    public void changeHotelDuration(int hotelDuration) {
        hotel.changeHotelDuration(hotelDuration);
    }

    // MODIFIES: this
    // EFFECTS: changes the current hotel location to the parameter
    public void changeHotelLocation(String hotelLocation) {
        hotel.changeHotelLocation(hotelLocation);
    }


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
