package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Represents the flight class tests

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

    @Test
    public void changePriceTest() {
        f1.changePrice(290);
        f2.changePrice(0);
        assertEquals(290, f1.getFlightPrice());
        assertEquals(0, f2.getFlightPrice());
    }

    @Test
    public void changeDateTest() {
        f1.changeDate("December 3");
        f2.changeDate("May 31");
        assertEquals("December 3", f1.getFlightDate());
        assertEquals("May 31", f2.getFlightDate());
    }

    @Test
    public void changeTimeTest() {
        f1.changeTime(1000);
        f2.changeTime(0);
        assertEquals(1000, f1.getFlightTime());
        assertEquals(0, f2.getFlightTime());
    }

    @Test
    public void changeIDTest() {
        f1.changeID("AC555");
        f2.changeID("UN123");
        assertEquals("AC555", f1.getFlightID());
        assertEquals("UN123", f2.getFlightID());
    }

    @Test
    public void changeDepartureTest() {
        f1.changeDeparture("YYC");
        f2.changeDeparture("SJC");
        assertEquals("YYC", f1.getFlightDeparture());
        assertEquals("SJC", f2.getFlightDeparture());
        }

    @Test
    public void changeDestinationTest() {
        f1.changeDestination("SJC");
        f2.changeDestination("YYC");
        assertEquals("SJC", f1.getFLightDestination());
        assertEquals("YYC", f2.getFLightDestination());
    }


}

