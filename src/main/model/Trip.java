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

    // EFFECTS: creates a trip with a name, a date, a flight, a hotel, and a price.
    public Trip(String name, String date, Flight flight, Hotel hotel) {
        this.name = name;
        this.date = date;
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

    // MODIFIES: this
    // EFFECTS: changes the name to a new name
    public void changeName(String newName) {
        name = newName;
    }

    // MODIFIES: this
    // EFFECTS: changes the date to a new date
    public void changeDate(String newDate) {
        date = newDate;
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

    //Code is based on JsonSerializationDemo
    //EFFECTS: returns trip and its details as a json object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("tripName", name);
        json.put("tripDate", date);
        json.put("tripPrice", price);
        json.put("flightPrice", flight.getFlightPrice());
        json.put("flightDate", flight.getFlightDate());
        json.put("flightTime", flight.getFlightTime());
        json.put("flightID", flight.getFlightID());
        json.put("flightDes", flight.getFLightDestination());
        json.put("flightDep", flight.getFlightDeparture());
        json.put("hotelName", hotel.getHotelName());
        json.put("hotelPrice", hotel.getHotelPrice());
        json.put("hotelDate", hotel.getHotelDate());
        json.put("hotelDuration", hotel.getHotelDuration());
        json.put("hotelLocation", hotel.getHotelLocation());
        return json;
    }
}
