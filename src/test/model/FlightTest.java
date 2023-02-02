package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightTest {
    private Flight f1;
    private Flight f2;

    @BeforeEach
    public void setup() {
        f1 = new Flight(300, "December 1", 900,
                "AC567", "YVR", "SFO");
        f2  = new Flight(230, "April 29", 1500,
                "UN888", "SFO", "YVR");
    }

    @Test
    public void testConstructor() {
        assertEquals(300, f1.getFlightPrice());
        assertEquals(230, f2.getFlightPrice());
        assertEquals("AC567", f1.getFlightID());
        assertEquals("UN888", f2.getFlightID());
        assertEquals(900, f1.getFlightTime());
        assertEquals(1500, f2.getFlightTime());
        assertEquals("December 1", f1.getFlightDate());
        assertEquals("April 29", f2.getFlightDate());
        assertEquals("YVR", f1.getFLightDestination());
        assertEquals("SFO", f2.getFLightDestination());
        assertEquals("SFO", f1.getFlightDeparture());
        assertEquals("YVR", f2.getFlightDeparture());

    }

}

