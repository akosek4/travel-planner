package ui;

import model.Flight;
import model.Hotel;
import model.ListOfTrips;
import model.Trip;
import persistence.Reader;
import persistence.Writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class GUIhelper {
    private static final String data = "./data/listoftrip.json";
    private ListOfTrips trips;
    private Trip trip;
    private String tripName;
    private String tripDate;
    private String tripLocation;
    private String hotelName;
    private int hotelPrice;
    private int flightPrice;
    private int flightTime;
    private String flightName;
    private Reader reader;
    private Writer writer;

    //EFFECTS: runs the list of trip application
    public GUIhelper() {
        init();
    }


    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        trips = new ListOfTrips();
        reader = new Reader(data);
        writer = new Writer(data);
    }


    //MODIFIES: this
    //EFFECTS: processes user command
    protected void processListOfTripCommand(String command) {
        if (command.equals("a")) {
            addTrip();
        } else if (command.equals("r")) {
            removeTrip();
        } else if (command.equals("save")) {
            saveTrips();
        } else if (command.equals("l")) {
            loadTrips();
        } else {
            System.out.println("Selection is not valid");
        }
    }


    //MODIFIES: this
    //EFFECTS: removes a trip from trips
    private void removeTrip() {
        this.trip = trips.getTrip(tripName);
        trips.removeTrip(this.trip);
    }

    //MODIFIES: this
    //EFFECTS: adds a trip to trips
    private void addTrip() {
        Flight flight = new Flight(flightPrice, flightTime, flightName);
        Hotel hotel = new Hotel(hotelName, hotelPrice);
        Trip trip = new Trip(tripName, tripDate, tripLocation, flight, hotel);
        trips.addTrip(trip);
    }

    //MODIFIES: this
    //EFFECTS: loads trips from file
    private void loadTrips() {
        try {
            trips = reader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from " + data);
        }
    }

    // EFFECTS: saves trips to file
    private void saveTrips() {
        try {
            writer.open();
            writer.write(trips);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + data);
        }
    }

    public List<String> getAllTripsInfoForGUI() {
        return trips.getListOfTripsInfo();
    }

    public ListOfTrips getTrips() {
        return trips;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTripName(String name) {
        tripName = name;
    }

    public void setTripDate(String date) {
        tripDate = date;
    }

    public void setTripLocation(String loc) {
        tripLocation = loc;
    }

    public void setHotelName(String name) {
        hotelName = name;
    }

    public void setHotelPrice(int price) {
        hotelPrice = price;
    }

    public void setFlightName(String name) {
        flightName = name;
    }

    public void setFlightTime(int time) {
        flightTime = time;
    }

    public void setFlightPrice(int price) {
        flightPrice = price;
    }
}

