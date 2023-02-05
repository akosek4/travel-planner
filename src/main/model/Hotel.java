package model;

// Represents a Hotel having a name, price, date, and location

public class Hotel {
    private String name;
    private int price;
    private String date;
    private String location;
    private int duration;

    // EFFECTS: creates a hotel with a name, price, date, duration, and location
    public Hotel(String name, int price, String date, int duration, String location) {
        this.price = price;
        this.date = date;
        this.name = name;
        this.duration = duration;
        this.location = location;
    }

    // REQUIRES: newDuration > 0
    // MODIFIES: this
    // EFFECTS: changes the current duration to the new duration
    public void changeHotelDuration(int newDuration) {
        duration = newDuration;
    }

    // REQUIRES: newPrice >= 0
    // MODIFIES: this
    // EFFECTS: changes the current price to the new price
    public void changeHotelPrice(int newPrice) {
        price = newPrice;
    }

    // MODIFIES: this
    // EFFECTS: changes the current name to the new name
    public void changeHotelName(String newName) {
        name = newName;
    }

    // MODIFIES: this
    // EFFECTS: changes the current date to the new date
    public void changeHotelDate(String newDate) {
        date = newDate;
    }

    // MODIFIES: this
    // EFFECTS: changes the current location to the new location
    public void changeHotelLocation(String newLocation) {
        location = newLocation;
    }

    public int getHotelDuration() {
        return duration;
    }

    public int getHotelPrice() {
        return price;
    }

    public String getHotelName() {
        return name;
    }

    public String getHotelLocation() {
        return location;
    }

    public String getHotelDate() {
        return date;
    }

}
