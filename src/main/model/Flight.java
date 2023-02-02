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
