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

    // REQUIRES: flightPrice >= 0, 2400 > flightTime >= 0
    // MODIFIES: this
    // EFFECTS: changes the all current details about the hotel to parameter
    public void changeAllFlightDetails(int flightPrice, String flightDate, int flightTime, String flightID,
                                       String flightDestination, String flightDeparture) {
        this.changeFlightPrice(flightPrice);
        this.changeFlightDate(flightDate);
        this.changeFlightTime(flightTime);
        this.changeFlightID(flightID);
        this.changeFlightDestination(flightDestination);
        this.changeFlightDeparture(flightDeparture);
    }

    // REQUIRES: newPrice >= 0
    // MODIFIES: this
    // EFFECTS: changes the current price to the new price
    public void changeFlightPrice(int newPrice) {
        flight.changePrice(newPrice);
    }

    // MODIFIES: this
    // EFFECTS: changes the current date to the new date
    public void changeFlightDate(String newDate) {
        flight.changeDate(newDate);
    }

    // REQUIRES: newTime > 0
    // MODIFIES: this
    // EFFECTS: changes the current time to the new time
    public void changeFlightTime(int newTime) {
        flight.changeTime(newTime);
    }

    // MODIFIES: this
    // EFFECTS: changes the current ID to the new ID
    public void changeFlightID(String newID) {
        flight.changeID(newID);
    }

    // MODIFIES: this
    // EFFECTS: changes the current departure to the new departure
    public void changeFlightDeparture(String newDeparture) {
        flight.changeDeparture(newDeparture);
    }

    // MODIFIES: this
    // EFFECTS: changes the current destination to the new destination
    public void changeFlightDestination(String newDestination) {
        flight.changeDestination(newDestination);
    }

    // REQUIRES: hotelPrice >= 0, hotelDuration >0
    // MODIFIES: this
    // EFFECTS: changes the all current details about the hotel to parameter
    public void changeAllHotelDetails(String hotelName, int hotelPrice, String hotelDate, int hotelDuration,
                                   String hotelLocation) {
        this.changeHotelLocation(hotelLocation);
        this.changeHotelDate(hotelDate);
        this.changeHotelName(hotelName);
        this.changeHotelPrice(hotelPrice);
        this.changeHotelDuration(hotelDuration);
    }

    // MODIFIES: this
    // EFFECTS: changes the current hotel name to the parameter
    public void changeHotelName(String hotelName) {
        hotel.changeName(hotelName);
    }

    // REQUIRES: hotelPrice >= 0
    // MODIFIES: this
    // EFFECTS: changes the current hotel price about to the parameter
    public void changeHotelPrice(int hotelPrice) {
        hotel.changePrice(hotelPrice);
    }

    // MODIFIES: this
    // EFFECTS: changes the current hotel date to the parameter
    public void changeHotelDate(String hotelDate) {
        hotel.changeDate(hotelDate);
    }

    // REQUIRES: hotelDuration > 0
    // MODIFIES: this
    // EFFECTS: changes the current hotel duration about to the parameter
    public void changeHotelDuration(int hotelDuration) {
        hotel.changeDuration(hotelDuration);
    }

    // MODIFIES: this
    // EFFECTS: changes the current hotel location to the parameter
    public void changeHotelLocation(String hotelLocation) {
        hotel.changeLocation(hotelLocation);
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
