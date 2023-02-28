package model;

// Represents a list of trips

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class ListOfTrips implements Writable {
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

    public int getTripsSize() {
        return trips.size();
    }

    //Code is based on JsonSerializationDemo
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("trips", tripsToJson());
        return json;
    }

    //Code is based on JsonSerializationDemo
    // EFFECTS: returns trips in this list as a JSON array
    private JSONArray tripsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Trip t : trips) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }
}
