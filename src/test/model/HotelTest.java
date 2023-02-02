package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelTest {
    private Hotel h1;
    private Hotel h2;

    @BeforeEach
    public void setup() {
        h1 = new Hotel("The Modern Honolulu", 2800, "May 10",
                7, "Honolulu");

        h2  = new Hotel("The Westin Bayshore", 1900, "December 1",
                4, "Vancouver");
    }

    @Test
    public void testConstructor() {
        assertEquals(7, h1.getHotelDuration());
        assertEquals(4, h2.getHotelDuration());
        assertEquals(2800, h1.getHotelPrice());
        assertEquals(1900, h2.getHotelPrice());
        assertEquals("May 10", h1.getHotelDate());
        assertEquals("December 1", h2.getHotelDate());
        assertEquals("The Modern Honolulu", h1.getHotelName());
        assertEquals("The Westin Bayshore 29", h2.getHotelName());
        assertEquals("Honolulu", h1.getHotelLocation());
        assertEquals("Vancouver", h2.getHotelLocation());

    }

}
