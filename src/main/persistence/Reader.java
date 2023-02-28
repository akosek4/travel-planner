package persistence;

// Represents a reader that reads ListOfTrip from JSON data stored in file

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

        try (Stream<String> stream = Files.lines( Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> content.append(s));
        }
        return content.toString();
    }
    
    //EFFECTS: parses ListOfTrips from object
    private ListOfTrips parseTrips(JSONObject object) {
        String name = object.getString("name");
        ListOfTrips lot = new ListOfTrips(name);
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
        String tripName = object.getString("name");
        String tripDate = object.getString("date");
        int flightPrice = object.getInt("price");
        String flightDate = object.getString("date");
        int flightTime = object.getInt("time");
        String flightID = object.getString("identification");
        String flightDes = object.getString("destination");
        String flightDep = object.getString("departure");
        String hotelName = object.getString("name");
        int hotelPrice = object.getInt("price");
        String hotelDate = object.getString("name");
        int hotelDuration = object.getInt("duration");
        String hotelLocation = object.getString("name");

        Flight flight = new Flight(flightPrice, flightDate, flightTime, flightID, flightDes, flightDep);
        Hotel hotel = new Hotel(hotelName, hotelPrice, hotelDate, hotelDuration, hotelLocation);

        Trip trip = new Trip(tripName, tripDate, flight, hotel); //TODO: figure out how to add activities
        lot.addTrip(trip);
    }

}
