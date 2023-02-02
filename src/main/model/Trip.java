package model;

// Represents a Trip having a name, date, and internal details

public class Trip {
    private String name;
    private String date;
    private Flight flight;
    private Hotel hotel;
    private Activity activity;
    private int price;

    // EFFECTS: creates a trip with a name, a date, and no internal details
    public Trip(String name, String date) {
        this.name = name;
        this.date = date;
        this.price = flight.getFlightPrice() + hotel.getHotelPrice();
        //TODO add activity price
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

}
