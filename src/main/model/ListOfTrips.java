package model;

// Represents a list of trips

import java.util.ArrayList;
import java.util.List;

public class ListOfTrips {
    private List<Trip> trips;
    private String name;

    // EFFECTS: creates a list of trips with a name and an empty list of trips
    public ListOfTrips(String name) {
        this.name = name;
        this.trips = new ArrayList<>();
    }

    // MODIFIES: this
    //EFFECTS: adds a trip to trips
    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    // MODIFIES: this
    //EFFECTS: removes a trip from trips or returns false if trip is not already in the list
    public Boolean removeTrip(Trip trip) {
        if (trips.contains(trip)) {
            trips.remove(trip);
            return true;
        } else {
            return false;
        }
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public Trip getTrip(String name) {
        for (Trip trip : trips) {
            if (trip.getTripName().equals(name)) {
                return trip;
            }
        }
        return null;
    }

    public String getTripsName() {
        return name;
    }

    //MODIFIES: this
    //EFFECTS: creates a string with all trip names in trips
    public String printAllTrips() {
        String toPrint = "";
        for (Trip trip : trips) {
            toPrint = toPrint + " " + trip.getTripName();
        }
        return toPrint;
    }
}
