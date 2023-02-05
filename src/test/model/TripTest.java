package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    // REQUIRES: hotelPrice >= 0, hotelDuration >0
    // MODIFIES: this
    // EFFECTS: changes the all current details about the hotel to parameter
    @Test
    public void changeAllHotelDetails() {
        h1.changeHotelLocation("Kona");
        h1.changeHotelDate("May 1");
        h1.changeHotelName("Marriott Kona");
        h1.changeHotelPrice(1900);
        h1.changeHotelDuration(9);
        assertEquals("Kona", h1.getHotelLocation());
        assertEquals("May 1", h1.getHotelDate());
        assertEquals("Marriott Kona", h1.getHotelName());
        assertEquals(1900, h1.getHotelPrice());
        assertEquals(9, h1.getHotelDuration());
    }

    @Test
    public void changeHotelName() {
        h1.changeHotelName("Marriott Kona");
        h2.changeHotelName("Home");
        assertEquals("Marriott Kona", h1.getHotelName());
        assertEquals("Home", h2.getHotelName());
    }

    @Test
    public void changeHotelPriceTest() {
        h1.changeHotelPrice(1900);
        h2.changeHotelPrice(0);
        assertEquals(1900, h1.getHotelPrice());
        assertEquals(0, h2.getHotelPrice());
    }

    @Test
    public void changeHotelDateTest() {
        h1.changeHotelDate("May 9");
        h2.changeHotelDate("September 13");
        assertEquals("May 9", h1.getHotelDate());
        assertEquals("September 13", h2.getHotelDate());
    }

    @Test
    public void changeHotelDurationTest() {
        h1.changeHotelDuration(9);
        h2.changeHotelDuration(0);
        assertEquals(9, h1.getHotelDuration());
        assertEquals(0, h2.getHotelDuration());
    }

    @Test
    public void changeHotelLocationTest() {
        h1.changeHotelLocation("Kona");
        h2.changeHotelLocation("Victoria");
        assertEquals("Kona", h1.getHotelLocation());
        assertEquals("Victoria", h2.getHotelLocation());
    }

}