package model;

// Represents a Flight having a price, date, time, ID, destination, and departure location

public class Flight {

    private int price;
    private String date;
    private int time;
    private String name;
    private String location;

    // EFFECTS: creates a flight with a price, date, time, ID (name), and destination location
    public Flight(int price, String date, int time, String name, String location) {
        this.price = price;
        this.date = date;
        this.time = time;
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
    // EFFECTS: changes the current date to the new date
    public void changeDate(String newDate) {
        date = newDate;
    }

    // REQUIRES: 2400 > newTime >= 0
    // MODIFIES: this
    // EFFECTS: changes the current time to the new time
    public void changeTime(int newTime) {
        time = newTime;
    }

    // MODIFIES: this
    // EFFECTS: changes the current name to the new name
    public void changeName(String newName) {
        name = newName;
    }

    // MODIFIES: this
    // EFFECTS: changes the current location to the new location
    public void changeLocation(String newLocation) {
        location = newLocation;
    }

    public int getFlightPrice() {
        return price;
    }

    public String getFlightName() {
        return name;
    }

    public int getFlightTime() {
        return time;
    }

    public String getFlightDate() {
        return date;
    }

    public String getFlightLocation() {
        return location;
    }



}
