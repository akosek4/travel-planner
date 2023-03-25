package model;

// Represents a Hotel having a name, price, date, and location

public class Hotel {
    private String name;
    private int price;

    // EFFECTS: creates a hotel with a name and a price
    public Hotel(String name, int price) {
        this.price = price;
        this.name = name;
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


    public int getHotelPrice() {
        return price;
    }

    public String getHotelName() {
        return name;
    }

}
