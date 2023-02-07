package model;

public class Activity {
    private String name;
    private int price;
    private String date;
    private int time;
    private String location;

    // EFFECTS: creates an activity with a name, price, date, time, and location
    public Activity(String name, int price, String date, int time, String location) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    // MODIFIES: this
    // EFFECTS: changes the current date to the new date
    public void changeName(String newName) {
        name = newName;
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
    // EFFECTS: changes the current location to the new location
    public void changeLocation(String newLocation) {
        location = newLocation;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }
}
