package model;

// Represents a list of trips

import java.util.ArrayList;
import java.util.List;

public class ListOfTrips {
    private List<Trip> trips;
    private String toPrint = "";

    // EFFECTS: creates a list of trips
    public ListOfTrips() {
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

    public String printAllTrips() {
        for (Trip trip : trips) {
            toPrint += " " + trip.getTripName();
        }
        return toPrint;
    }
}
