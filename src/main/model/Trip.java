package model;

// Represents a Trip having a name, date, and internal details

import org.json.JSONObject;
import persistence.Writable;

public class Trip implements Writable {
    private String name;
    private String date;
    private Flight flight;
    private Hotel hotel;
    private int price;
    private String location;

    // EFFECTS: creates a trip with a name, a date, a flight, a hotel, a location and a price.
    public Trip(String name, String date, String location, Flight flight, Hotel hotel) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.flight = flight;
        this.hotel = hotel;
        this.price = flight.getFlightPrice() + hotel.getHotelPrice();
    }

    // REQUIRES: newPrice >= 0
    // MODIFIES: this
    // EFFECTS: changes the current price to the new price
    public void changeFlightPrice(int newPrice) {
        flight.changePrice(newPrice);
    }


    // REQUIRES: newTime > 0
    // MODIFIES: this
    // EFFECTS: changes the current time to the new time
    public void changeFlightTime(int newTime) {
        flight.changeTime(newTime);
    }

    // MODIFIES: this
    // EFFECTS: changes the current name to the new name
    public void changeFlightName(String newName) {
        flight.changeName(newName);
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
    // EFFECTS: changes the name to a new name
    public void changeTripName(String newName) {
        name = newName;
    }

    // MODIFIES: this
    // EFFECTS: changes the date to a new date
    public void changeTripDate(String newDate) {
        date = newDate;
    }

    // MODIFIES: this
    // EFFECTS: changes the date to a new location
    public void changeTripLocation(String newLocation) {
        location = newLocation;
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

    public String getTripLocation() {
        return location;
    }

    public Flight getFlight() {
        return flight;
    }

    public Hotel getHotel() {
        return hotel;
    }

    //Code is based on JsonSerializationDemo
    //EFFECTS: returns trip and its details as a json object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("tripName", name);
        json.put("tripDate", date);
        json.put("tripPrice", price);
        json.put("tripLocation", location);
        json.put("flightPrice", flight.getFlightPrice());
        json.put("flightTime", flight.getFlightTime());
        json.put("flightName", flight.getFlightName());
        json.put("hotelName", hotel.getHotelName());
        json.put("hotelPrice", hotel.getHotelPrice());
        return json;
    }
}
