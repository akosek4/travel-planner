package model;

// Represents a Flight having a price, date, time, ID, destination, and departure location

public class Flight {

    private int price;
    private String date;
    private int time;
    private String identification;
    private String destination;
    private String departure;

    // EFFECTS: creates a flight with a price, date, time, ID, destination, and departure location
    public Flight(int price, String date, int time, String identification,
                  String destination, String departure) {
        this.price = price;
        this.date = date;
        this.time = time;
        this.identification = identification;
        this.destination = destination;
        this.departure = departure;
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

    // REQUIRES: newTime > 0
    // MODIFIES: this
    // EFFECTS: changes the current time to the new time
    public void changeTime(int newTime) {
        time = newTime;
    }

    // MODIFIES: this
    // EFFECTS: changes the current ID to the new ID
    public void changeID(String newID) {
        identification = newID;
    }

    // MODIFIES: this
    // EFFECTS: changes the current departure to the new departure
    public void changeDeparture(String newDeparture) {
        departure = newDeparture;
    }

    // MODIFIES: this
    // EFFECTS: changes the current destination to the new destination
    public void changeDestination(String newDestination) {
        destination = newDestination;
    }

    public int getFlightPrice() {
        return price;
    }

    public String getFlightID() {
        return identification;
    }

    public int getFlightTime() {
        return time;
    }

    public String getFlightDate() {
        return date;
    }

    public String getFLightDestination() {
        return destination;
    }

    public String getFlightDeparture() {
        return departure;
    }


}
