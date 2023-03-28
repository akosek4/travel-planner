package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Represents the trip class tests

class TripTest {
    private Trip trip1;
    private Trip trip2;
    private Flight f1 = new Flight(300, 900,
            "AC567");
    private Flight f2  = new Flight(230, 1500,
            "UN888");
    private Hotel  h1 = new Hotel("The Modern Honolulu", 2800);
    private Hotel h2  = new Hotel("The Westin Bayshore", 1900);

    @BeforeEach
    public void setup() {
        trip1 = new Trip("trip1", "December 1", "Hawaii", f1, h1);
        trip2  = new Trip("trip2", "May 10", "Pheonix", f2, h2);
    }

    @Test
    public void testConstructor() {
        assertEquals("trip1", trip1.getTripName());
        assertEquals("trip2", trip2.getTripName());
        assertEquals("December 1", trip1.getTripDate());
        assertEquals("May 10", trip2.getTripDate());
        assertEquals(3100, trip1.getTripPrice());
        assertEquals(2130, trip2.getTripPrice());
        assertEquals("Hawaii", trip1.getTripLocation());
        assertEquals("Pheonix", trip2.getTripLocation());
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
    public void changeLocationTest() {
        trip1.changeTripLocation("Florida");
        trip2.changeTripLocation("Hawaii");
        assertEquals("Florida", trip1.getTripLocation());
        assertEquals("Hawaii", trip2.getTripLocation());
    }


    @Test
    public void changeFlightPriceTest() {
        trip1.changeFlightPrice(300);
        trip2.changeFlightPrice(0);
        assertEquals(300, trip1.getFlight().getFlightPrice());
        assertEquals(0, trip2.getFlight().getFlightPrice());
    }

    @Test
    public void changeFlightTimeTest() {
        trip1.changeFlightTime(2300);
        trip2.changeFlightTime(0000);
        assertEquals(2300, trip1.getFlight().getFlightTime());
        assertEquals(0000, trip2.getFlight().getFlightTime());
    }

    @Test
    public void changeFlightNameTest() {
        trip1.changeFlightName("UN123");
        trip2.changeFlightName("AC456");
        assertEquals("UN123", trip1.getFlight().getFlightName());
        assertEquals("AC456", trip2.getFlight().getFlightName());
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

}