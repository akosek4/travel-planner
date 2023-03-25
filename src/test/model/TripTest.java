package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Represents the trip class tests

class TripTest {
    private Trip trip1;
    private Trip trip2;
    private Flight f1 = new Flight(300, "December 1", 900,
            "AC567", "YVR", "SFO");
    private Flight f2  = new Flight(230, "April 29", 1500,
            "UN888", "SFO", "YVR");
    private Hotel  h1 = new Hotel("The Modern Honolulu", 2800, "May 10",
            7, "Honolulu");
    private Hotel h2  = new Hotel("The Westin Bayshore", 1900, "December 1",
            4, "Vancouver");

    @BeforeEach
    public void setup() {
        trip1 = new Trip("trip1", "December 1", f1, h1);
        trip2  = new Trip("trip2", "May 10", f2, h2);
    }

    @Test
    public void testConstructor() {
        assertEquals("trip1", trip1.getTripName());
        assertEquals("trip2", trip2.getTripName());
        assertEquals("December 1", trip1.getTripDate());
        assertEquals("May 10", trip2.getTripDate());
        assertEquals(3100, trip1.getTripPrice());
        assertEquals(2130, trip2.getTripPrice());
        assertEquals(f1, trip1.getFlight());
        assertEquals(f2, trip2.getFlight());
        assertEquals(h1, trip1.getHotel());
        assertEquals(h2, trip2.getHotel());
    }

    @Test
    public void changeNameTest() {
        trip1.changeTripName("Ski Trip");
        trip2.changeTripName("Beach Trip");
        assertEquals("Ski Trip", trip1.getTripName());
        assertEquals("Beach Trip", trip2.getTripName());
    }

    @Test
    public void changeDateTest() {
        trip1.changeTripDate("January 1");
        trip2.changeTripDate("December 31");
        assertEquals("January 1", trip1.getTripDate());
        assertEquals("December 31", trip2.getTripDate());
    }


    @Test
    public void changeFlightPriceTest() {
        trip1.changeFlightPrice(300);
        trip2.changeFlightPrice(0);
        assertEquals(300, trip1.getFlight().getFlightPrice());
        assertEquals(0, trip2.getFlight().getFlightPrice());
    }

    @Test
    public void changeFlightDateTest() {
        trip1.changeFlightDate("April 21");
        trip2.changeFlightDate("October 23");
        assertEquals("April 21", trip1.getFlight().getFlightDate());
        assertEquals("October 23", trip2.getFlight().getFlightDate());
    }

    @Test
    public void changeFlightTimeTest() {
        trip1.changeFlightTime(2300);
        trip2.changeFlightTime(0000);
        assertEquals(2300, trip1.getFlight().getFlightTime());
        assertEquals(0000, trip2.getFlight().getFlightTime());
    }

    @Test
    public void changeFlightIDTest() {
        trip1.changeFlightName("UN123");
        trip2.changeFlightName("AC456");
        assertEquals("UN123", trip1.getFlight().getFlightName());
        assertEquals("AC456", trip2.getFlight().getFlightName());
    }

    @Test
    public void changeFlightDepartureTest() {
        trip1.changeFlightDeparture("MDW");
        trip2.changeFlightDeparture("PHX");
        assertEquals("MDW", trip1.getFlight().getFlightDeparture());
        assertEquals("PHX", trip2.getFlight().getFlightDeparture());
    }

    @Test
    public void changeFlightDestinationTest() {
        trip1.changeFlightLocation("PHX");
        trip2.changeFlightLocation("MDW");
        assertEquals("PHX", trip1.getFlight().getFlightLocation());
        assertEquals("MDW", trip2.getFlight().getFlightLocation());
    }



    @Test
    public void changeHotelNameTest() {
        trip1.changeHotelName("Marriott Kona");
        trip2.changeHotelName("Home");
        assertEquals("Marriott Kona", trip1.getHotel().getHotelName());
        assertEquals("Home", trip2.getHotel().getHotelName());
    }

    @Test
    public void changeHotelPriceTest() {
        trip1.changeHotelPrice(1900);
        trip2.changeHotelPrice(0);
        assertEquals(1900, trip1.getHotel().getHotelPrice());
        assertEquals(0, trip2.getHotel().getHotelPrice());
    }

    @Test
    public void changeHotelDateTest() {
        trip1.changeHotelDate("May 9");
        trip2.changeHotelDate("September 13");
        assertEquals("May 9", trip1.getHotel().getHotelDate());
        assertEquals("September 13", trip2.getHotel().getHotelDate());
    }

    @Test
    public void changeHotelDurationTest() {
        trip1.changeHotelDuration(9);
        trip2.changeHotelDuration(0);
        assertEquals(9, trip1.getHotel().getHotelDuration());
        assertEquals(0, trip2.getHotel().getHotelDuration());
    }

    @Test
    public void changeHotelLocationTest() {
        trip1.changeHotelLocation("Kona");
        trip2.changeHotelLocation("Victoria");
        assertEquals("Kona", trip1.getHotel().getHotelLocation());
        assertEquals("Victoria", trip2.getHotel().getHotelLocation());
    }

}