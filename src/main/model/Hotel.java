package model;

// Represents a Hotel having a name, price, date, and location

public class Hotel {
    private String name;
    private int price;
    private String date;
    private String location;

    // EFFECTS: creates a hotel with a name, price, date,  and location
    public Hotel(String name, int price, String date, String location) {
        this.price = price;
        this.date = date;
        this.name = name;
        this.location = location;
    }

    // REQUIRES: newPrice >= 0
    // MODIFIES: this
    // EFFECTS: changes the current price to the new price
    public void changePrice(int newPrice) {
        price = newPrice;
    }

    // MODIFIES: this
    // EFFECTS: changes the current name to the new name
    public void changeName(String newName) {
        name = newName;
    }

    // MODIFIES: this
    // EFFECTS: changes the current date to the new date
    public void changeDate(String newDate) {
        date = newDate;
    }

    // MODIFIES: this
    // EFFECTS: changes the current location to the new location
    public void changeLocation(String newLocation) {
        location = newLocation;
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
