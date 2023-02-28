package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Represents the listoftrip class tests

public class ListOfTripTest {
    private ListOfTrips lot1;
    private ListOfTrips lot2;
    private Flight f1 = new Flight(300, "December 1", 900,
            "AC567", "YVR", "SFO");
    private Flight f2  = new Flight(230, "April 29", 1500,
            "UN888", "SFO", "YVR");
    private Hotel  h1 = new Hotel("The Modern Honolulu", 2800, "May 10",
            7, "Honolulu");
    private Hotel h2  = new Hotel("The Westin Bayshore", 1900, "December 1",
            4, "Vancouver");
    private Trip trip1 = new Trip("trip1", "December 1", f1, h1);
    private Trip trip2 = new Trip("trip2", "May 10", f2, h2);

    @BeforeEach
    public void setup() {
        lot1 = new ListOfTrips("trips 1");
        lot2  = new ListOfTrips("trips 2");
    }

    @Test
    public void constructorTest() {
        List<Trip> result = new ArrayList<>();

        assertEquals(result, lot1.getTrips());
        assertEquals(result, lot2.getTrips());
        assertEquals("trips 1", lot1.getTripsName());
        assertEquals("trips 2", lot2.getTripsName());
    }

    @Test
    public void addTripTest() {
        lot1.addTrip(trip1);
        lot2.addTrip(trip1);
        lot2.addTrip(trip2);
        List<Trip> t1Result = new ArrayList<>();
        List<Trip> t2Result = new ArrayList<>();
        t1Result.add(trip1);
        t2Result.add(trip1);
        t2Result.add(trip2);
        assertEquals(t1Result, lot1.getTrips());
        assertEquals(t2Result, lot2.getTrips());
    }

    @Test
    public void removeTripTrueTest() {
        lot1.addTrip(trip1);
        lot1.addTrip(trip2);
        lot2.addTrip(trip1);
        lot2.addTrip(trip2);
        lot1.removeTrip(trip2);
        lot2.removeTrip(trip1);
        List<Trip> t1Result = new ArrayList<>();
        List<Trip> t2Result = new ArrayList<>();
        t1Result.add(trip1);
        t2Result.add(trip2);
        assertEquals(t1Result, lot1.getTrips());
        assertEquals(t2Result, lot2.getTrips());
    }

    @Test
    public void removeTripFalseTest() {
        lot2.addTrip(trip1);
        assertFalse(lot1.removeTrip(trip2));
        assertFalse(lot2.removeTrip(trip2));
    }

    @Test
    public void getTripNotNullTest() {
        lot1.addTrip(trip1);
        lot1.addTrip(trip2);
        lot2.addTrip(trip1);
        lot2.addTrip(trip2);
        assertEquals(trip1, lot1.getTrip("trip1"));
        assertEquals(trip2, lot2.getTrip("trip2"));
    }


    @Test
    public void getTripNullTest() {
        lot1.addTrip(trip1);
        lot1.addTrip(trip2);
        lot2.addTrip(trip1);
        lot2.addTrip(trip2);
        assertNull(lot1.getTrip("not trip"));
        assertNull(lot2.getTrip("false"));
    }

    @Test
    public void printAllTripsNullTest() {
        assertEquals("", lot1.printAllTrips());
        assertEquals("", lot2.printAllTrips());
    }

    @Test
    public void printAllTripsNotNullTest() {
        lot1.addTrip(trip1);
        lot2.addTrip(trip1);
        lot2.addTrip(trip2);
        assertEquals(" trip1", lot1.printAllTrips());
        assertEquals(" trip1 trip2", lot2.printAllTrips());
    }
}
