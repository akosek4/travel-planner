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
    private List<Trip> jan = new ArrayList<>();
    private List<Trip> feb = new ArrayList<>();
    private List<Trip> mar = new ArrayList<>();
    private List<Trip> apr = new ArrayList<>();
    private List<Trip> may = new ArrayList<>();
    private List<Trip> jun = new ArrayList<>();
    private List<Trip> jul = new ArrayList<>();
    private List<Trip> aug = new ArrayList<>();
    private List<Trip> sep = new ArrayList<>();
    private List<Trip> oct = new ArrayList<>();
    private List<Trip> nov = new ArrayList<>();
    private List<Trip> dec = new ArrayList<>();

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

    //MODIFIES: this
    //EFFECTS: creates a string with january trip names in trips
    public String printJanTrips() {
        String toPrint = "";
        for (Trip trip : jan) {
            toPrint = toPrint + " " + trip.getTripName();
        }
        return toPrint;
    }

    //MODIFIES: this
    //EFFECTS: creates a string with febuary trip names in trips
    public String printFebTrips() {
        String toPrint = "";
        for (Trip trip : feb) {
            toPrint = toPrint + " " + trip.getTripName();
        }
        return toPrint;
    }

    //MODIFIES: this
    //EFFECTS: creates a string with march trip names in trips
    public String printMarTrips() {
        String toPrint = "";
        for (Trip trip : mar) {
            toPrint = toPrint + " " + trip.getTripName();
        }
        return toPrint;
    }

    //MODIFIES: this
    //EFFECTS: creates a string with april trip names in trips
    public String printAprTrips() {
        String toPrint = "";
        for (Trip trip : apr) {
            toPrint = toPrint + " " + trip.getTripName();
        }
        return toPrint;
    }

    //MODIFIES: this
    //EFFECTS: creates a string with may trip names in trips
    public String printMayTrips() {
        String toPrint = "";
        for (Trip trip : may) {
            toPrint = toPrint + " " + trip.getTripName();
        }
        return toPrint;
    }

    //MODIFIES: this
    //EFFECTS: creates a string with june trip names in trips
    public String printJunTrips() {
        String toPrint = "";
        for (Trip trip : jun) {
            toPrint = toPrint + " " + trip.getTripName();
        }
        return toPrint;
    }

    //MODIFIES: this
    //EFFECTS: creates a string with july trip names in trips
    public String printJulTrips() {
        String toPrint = "";
        for (Trip trip : jul) {
            toPrint = toPrint + " " + trip.getTripName();
        }
        return toPrint;
    }

    //MODIFIES: this
    //EFFECTS: creates a string with august trip names in trips
    public String printAugTrips() {
        String toPrint = "";
        for (Trip trip : aug) {
            toPrint = toPrint + " " + trip.getTripName();
        }
        return toPrint;
    }

    //MODIFIES: this
    //EFFECTS: creates a string with septemeber trip names in trips
    public String printSepTrips() {
        String toPrint = "";
        for (Trip trip : sep) {
            toPrint = toPrint + " " + trip.getTripName();
        }
        return toPrint;
    }

    //MODIFIES: this
    //EFFECTS: creates a string with october trip names in trips
    public String printOctTrips() {
        String toPrint = "";
        for (Trip trip : oct) {
            toPrint = toPrint + " " + trip.getTripName();
        }
        return toPrint;
    }

    //MODIFIES: this
    //EFFECTS: creates a string with novemember trip names in trips
    public String printNovTrips() {
        String toPrint = "";
        for (Trip trip : nov) {
            toPrint = toPrint + " " + trip.getTripName();
        }
        return toPrint;
    }

    //MODIFIES: this
    //EFFECTS: creates a string with december trip names in trips
    public String printDecTrips() {
        String toPrint = "";
        for (Trip trip : dec) {
            toPrint = toPrint + " " + trip.getTripName();
        }
        return toPrint;
    }

    public int getTripsSize() {
        return trips.size();
    }

    public void groupTripsByMonth() {
        for (Trip trip : trips) {
            if (trip.getTripDate().contains("jan")) {
                jan.add(trip);
            } else if (trip.getTripDate().contains("feb")) {
                feb.add(trip);
            } else if (trip.getTripDate().contains("mar")) {
                mar.add(trip);
            } else if (trip.getTripDate().contains("apr")) {
                apr.add(trip);
            } else if (trip.getTripDate().contains("may")) {
                may.add(trip);
            } else if (trip.getTripDate().contains("jun")) {
                jun.add(trip);
            } else if (trip.getTripDate().contains("jul")) {
                jul.add(trip);
            } else if (trip.getTripDate().contains("aug")) {
                aug.add(trip);
            } else if (trip.getTripDate().contains("sep")) {
                sep.add(trip);
            } else if (trip.getTripDate().contains("oct")) {
                oct.add(trip);
            } else if (trip.getTripDate().contains("nov")) {
                nov.add(trip);
            } else if (trip.getTripDate().contains("dec")) {
                dec.add(trip);
            }
        }
    }

    public List<Trip> getGroupedTrips(String month) {
        if (month.contains("jan")) {
            return jan;
        } else if (month.contains("feb")) {
            return feb;
        } else if (month.contains("mar")) {
            return mar;
        } else if (month.contains("apr")) {
            return apr;
        } else if (month.contains("may")) {
            return may;
        } else if (month.contains("jun")) {
            return jun;
        } else if (month.contains("jul")) {
            return jul;
        } else if (month.contains("aug")) {
            return aug;
        } else if (month.contains("sep")) {
            return sep;
        } else if (month.contains("oct")) {
            return oct;
        } else if (month.contains("nov")) {
            return nov;
        } else if (month.contains("dec")) {
            return dec;
        }
        return null;
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
