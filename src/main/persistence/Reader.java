package persistence;

// Represents a reader that reads ListOfTrip from JSON data stored in file

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//Code is based on JsonSerializationDemo

public class Reader {
    private String source;
    
    //EFFECTS: constructs a reader to read source file
    public Reader(String source) {
        this.source = source;
    }
    
    //EFFECTS: reads ListOfTrips from file
    // throws IOException if error occurs
    public ListOfTrips read() throws IOException {
        String data = readFile(source);
        JSONObject object = new JSONObject(data);
        return parseTrips(object);
    }

    //EFFECTS: reads source as a string
    private String readFile(String source) throws IOException {
        StringBuilder content = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> content.append(s));
        }
        return content.toString();
    }
    
    //EFFECTS: parses ListOfTrips from object
    private ListOfTrips parseTrips(JSONObject object) {
        ListOfTrips lot = new ListOfTrips();
        addTrips(lot, object);
        return lot;
    }

    //MODIFIES: lot
    //EFFECTS: parses trips from object and adds them to ListOfTrips
    private void addTrips(ListOfTrips lot, JSONObject object) {
        JSONArray array = object.getJSONArray("trips");
        for (Object json : array) {
            JSONObject nextTrip = (JSONObject) json;
            addTrip(lot, nextTrip);
        }
    }

    //MODIFIES: lot
    //EFFECTS: parses trip from object and adds it to ListOfTrips
    private void addTrip(ListOfTrips lot, JSONObject object) {
        String tripName = object.getString("tripName");
        String tripDate = object.getString("tripDate");
        String tripLocation = object.getString("tripLocation");
        int flightPrice = object.getInt("flightPrice");
        int flightTime = object.getInt("flightTime");
        String flightName = object.getString("flightName");
        String hotelName = object.getString("hotelName");
        int hotelPrice = object.getInt("hotelPrice");

        Flight flight = new Flight(flightPrice, flightTime, flightName);
        Hotel hotel = new Hotel(hotelName, hotelPrice);

        Trip trip = new Trip(tripName, tripDate, tripLocation, flight, hotel);
        lot.addTrip(trip);
    }

}
