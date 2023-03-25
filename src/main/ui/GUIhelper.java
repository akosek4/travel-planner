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
    protected ListOfTrips trips;
    private Trip trip;
    protected String tripsName;
    protected String tripName;
    protected String tripDate;
    protected String hotelName;
    protected int hotelPrice;
    protected String hotelDate;
    protected String hotelLocation;
    protected int flightPrice;
    protected String flightDate;
    protected int flightTime;
    protected String flightName;
    protected String flightLocation;
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
            addTrip(tripName, tripDate, hotelName, hotelPrice, hotelDate, hotelLocation, flightPrice,
                    flightDate, flightTime, flightName, flightLocation);
        } else if (command.equals("r")) {
            removeTrip(tripName);
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
    private void removeTrip(String name) {
        this.trip = trips.getTrip(name);
        trips.removeTrip(this.trip);
    }

    //MODIFIES: this
    //EFFECTS: adds a trip to trips
    private void addTrip(String name, String date, String hotelName, int hotelPrice, String hotelDate, String hotelLocation, int flightPrice, String flightDate, int flightTime,
                         String flightName, String flightLocation) {
        Flight flight = new Flight(flightPrice, flightDate, flightTime, flightName, flightLocation);
        Hotel hotel = new Hotel(hotelName, hotelPrice, hotelDate, hotelLocation);
        Trip trip = new Trip(name, date, flight, hotel);
        trips.addTrip(trip);
    }

    //MODIFIES: this
    //EFFECTS: loads trips from file
    private void loadTrips() {
        try {
            trips = reader.read();
            System.out.println("Loaded list of trips from " + data);
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
            System.out.println("Saved trips to " + data);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + data);
        }
    }

    public List<String> getAllTripsInfoForGUI() {
        return trips.getListOfTripsInfo();
    }
}
