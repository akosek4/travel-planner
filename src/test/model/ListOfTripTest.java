package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Represents the listoftrip class tests

public class ListOfTripTest {
    private ListOfTrips lot1;
    private ListOfTrips lot2;
    private ListOfTrips lot3;
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
    private Trip trip3 = new Trip("trip3", "March 1", f1, h1);
    private Trip trip4 = new Trip("trip4", "april 10", f2, h2);
    private Trip trip5 = new Trip("trip5", "june 1", f1, h1);
    private Trip trip6 = new Trip("trip6", "july 10", f2, h2);
    private Trip trip7 = new Trip("trip7", "august 1", f1, h1);
    private Trip trip8 = new Trip("trip8", "september 10", f2, h2);
    private Trip trip9 = new Trip("trip9", "feburary 1", f1, h1);
    private Trip trip10 = new Trip("trip10", "october 10", f2, h2);
    private Trip trip11 = new Trip("trip11", "november 1", f1, h1);
    private Trip trip12 = new Trip("trip12", "january 10", f2, h2);


    @BeforeEach
    public void setup() {
        lot1 = new ListOfTrips("trips 1");
        lot2  = new ListOfTrips("trips 2");
        lot3 = new ListOfTrips("grouped trips");
        lot3.addTrip(trip1);
        lot3.addTrip(trip2);
        lot3.addTrip(trip3);
        lot3.addTrip(trip4);
        lot3.addTrip(trip5);
        lot3.addTrip(trip6);
        lot3.addTrip(trip7);
        lot3.addTrip(trip8);
        lot3.addTrip(trip9);
        lot3.addTrip(trip10);
        lot3.addTrip(trip11);
        lot3.addTrip(trip12);
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

    @Test
    public void getTripsSizeTest() {
        lot1.addTrip(trip1);
        lot2.addTrip(trip1);
        lot2.addTrip(trip2);
        assertEquals(1, lot1.getTripsSize());
        assertEquals(2, lot2.getTripsSize());
    }

    @Test
    public void printJanTripsTest() {
        lot3.groupTripsByMonth();
        assertEquals("", lot2.printJanTrips());
        assertEquals("trip12", lot3.printJanTrips());
    }

    @Test
    public void printFebTripsTest() {
        lot3.groupTripsByMonth();
        assertEquals("", lot2.printFebTrips());
        assertEquals("trip9", lot3.printFebTrips());
    }

    @Test
    public void printMarTripsTest() {
        lot3.groupTripsByMonth();
        assertEquals("", lot2.printMarTrips());
        assertEquals("trip3", lot3.printMarTrips());
    }

    @Test
    public void printAprTripsTest() {
        lot3.groupTripsByMonth();
        assertEquals("", lot2.printAprTrips());
        assertEquals("trip4", lot3.printAprTrips());
    }

    @Test
    public void printMayTripsTest() {
        lot3.groupTripsByMonth();
        assertEquals("", lot2.printMayTrips());
        assertEquals("trip2", lot3.printMayTrips());
    }

    @Test
    public void printJunTripsTest() {
        lot3.groupTripsByMonth();
        assertEquals("", lot2.printJunTrips());
        assertEquals("trip5", lot3.printJunTrips());
    }

    @Test
    public void printJulTripsTest() {
        lot3.groupTripsByMonth();
        assertEquals("", lot2.printJulTrips());
        assertEquals("trip6", lot3.printJulTrips());
    }

    @Test
    public void printAugTripsTest() {
        lot3.groupTripsByMonth();
        assertEquals("", lot2.printAugTrips());
        assertEquals("trip7", lot3.printAugTrips());
    }

    @Test
    public void printSepTripsTest() {
        lot3.groupTripsByMonth();
        assertEquals("", lot2.printSepTrips());
        assertEquals("trip8", lot3.printSepTrips());
    }

    @Test
    public void printOctTripsTest() {
        lot3.groupTripsByMonth();
        assertEquals("", lot2.printOctTrips());
        assertEquals("trip10", lot3.printOctTrips());
    }

    @Test
    public void printNovTripsTest() {
        lot3.groupTripsByMonth();
        assertEquals("", lot2.printNovTrips());
        assertEquals("trip11", lot3.printNovTrips());
    }

    @Test
    public void printDecTripsTest() {
        lot3.groupTripsByMonth();
        assertEquals("", lot2.printDecTrips());
        assertEquals("trip1", lot3.printDecTrips());
    }


    @Test
    public void groupTripsByMonthTest() {
        lot3.groupTripsByMonth();
        assertEquals(trip12, lot3.getJan());
        assertEquals(trip9, lot3.getFeb());
        assertEquals(trip3, lot3.getMar());
        assertEquals(trip4, lot3.getApr());
        assertEquals(trip2, lot3.getMay());
        assertEquals(trip5, lot3.getJun());
        assertEquals(trip6, lot3.getJul());
        assertEquals(trip7, lot3.getAug());
        assertEquals(trip8, lot3.getSep());
        assertEquals(trip10, lot3.getOct());
        assertEquals(trip11, lot3.getNov());
        assertEquals(trip1, lot3.getDec());
    }

    @Test
    public void eraseGroupsTest() {
        lot3.groupTripsByMonth();
        lot3.eraseGroups();
        assertEquals(0, lot3.getJanSize());
        assertEquals(0, lot3.getFebSize());
        assertEquals(0, lot3.getMarSize());
        assertEquals(0, lot3.getAprSize());
        assertEquals(0, lot3.getMaySize());
        assertEquals(0, lot3.getJunSize());
        assertEquals(0, lot3.getJulSize());
        assertEquals(0, lot3.getAugSize());
        assertEquals(0, lot3.getSepSize());
        assertEquals(0, lot3.getOctSize());
        assertEquals(0, lot3.getNovSize());
        assertEquals(0, lot3.getDecSize());
    }

    @Test
    public void tripsToJsonTest() {
        //TODO
    }


    @Test
    public void toJsonTest() {
        //TODO
    }

}
