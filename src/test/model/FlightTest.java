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
        f1 = new Flight(300, 900,
                "AC567");
        f2  = new Flight(230, 1500,
                "UN888");
    }

    @Test
    public void testConstructor() {
        assertEquals(300, f1.getFlightPrice());
        assertEquals(230, f2.getFlightPrice());
        assertEquals("AC567", f1.getFlightName());
        assertEquals("UN888", f2.getFlightName());
        assertEquals(900, f1.getFlightTime());
        assertEquals(1500, f2.getFlightTime());
    }

    @Test
    public void changePriceTest() {
        f1.changePrice(290);
        f2.changePrice(0);
        assertEquals(290, f1.getFlightPrice());
        assertEquals(0, f2.getFlightPrice());
    }


    @Test
    public void changeTimeTest() {
        f1.changeTime(1000);
        f2.changeTime(0);
        assertEquals(1000, f1.getFlightTime());
        assertEquals(0, f2.getFlightTime());
    }

    @Test
    public void changeNameTest() {
        f1.changeName("AC555");
        f2.changeName("UN123");
        assertEquals("AC555", f1.getFlightName());
        assertEquals("UN123", f2.getFlightName());
    }


}

