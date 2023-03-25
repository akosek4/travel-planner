package model;

// Represents a Flight having a price, date, time, ID, destination, and departure location

public class Flight {

    private int price;
    private int time;
    private String name;

    // EFFECTS: creates a flight with a price, time, and ID (name)
    public Flight(int price, int time, String name) {
        this.price = price;
        this.time = time;
        this.name = name;
    }

    // REQUIRES: newPrice >= 0
    // MODIFIES: this
    // EFFECTS: changes the current price to the new price
    public void changePrice(int newPrice) {
        price = newPrice;
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


    public int getFlightPrice() {
        return price;
    }

    public String getFlightName() {
        return name;
    }

    public int getFlightTime() {
        return time;
    }



}
