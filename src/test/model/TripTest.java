package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TripTest {
    private Trip trip1;
    private Trip trip2;

    @BeforeEach
    public void setup() {
        trip1 = new Trip("trip1", "December 1");
        trip2  = new Trip("trip 2", "May 10");
    }

    @Test
    public void testConstructor() {
        assertEquals("trip1", trip1.getTripName());
        assertEquals("trip2", trip2.getTripName());
        assertEquals("December 1", trip1.getTripDate());
        assertEquals("May 10", trip2.getTripDate());
        assertEquals(0, trip1.getTripPrice());
        assertEquals(0, trip2.getTripPrice());
    }
}