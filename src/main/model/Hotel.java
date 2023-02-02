package model;

// Represents a Hotel having a name, price, date, and location

public class Hotel {
    private String name;
    private int price;
    private String date;
    private String location;

    // EFFECTS: creates a hotel with a name, price, date, and location
    public Hotel(String name, int price, String date, String location) {
        this.price = price;
        this.date = date;
        this.name = name;
        this.location = location;
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
