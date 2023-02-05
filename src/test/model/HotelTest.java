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
        assertEquals("The Westin Bayshore", h2.getHotelName());
        assertEquals("Honolulu", h1.getHotelLocation());
        assertEquals("Vancouver", h2.getHotelLocation());

    }


    @Test
    public void changeHotelDurationTest() {
        h1.changeHotelDuration(3);
        h2.changeHotelDuration(8);
        assertEquals(3, h1.getHotelDuration());
        assertEquals(8, h2.getHotelDuration());
    }

    @Test
    public void changeHotelPriceTest() {
        h1.changeHotelPrice(1700);
        h2.changeHotelPrice(0);
        assertEquals(1700, h1.getHotelPrice());
        assertEquals(0, h2.getHotelPrice());
    }

    @Test
    public void changeHotelNameTest() {
        h1.changeHotelName("Best Western Santa Cruz");
        h2.changeHotelName("Motel 6 San Diego");
        assertEquals("Best Western Santa Cruz", h1.getHotelName());
        assertEquals("Motel 6 San Diego", h2.getHotelName());
    }

    @Test
    public void changeHotelDateTest() {
        h1.changeHotelDate("May 2");
        h2.changeHotelDate("September 8");
        assertEquals("May 2", h1.getHotelDate());
        assertEquals("September 8", h2.getHotelDate());
    }

    @Test
    public void changeHotelLocationTest() {
        h1.changeHotelLocation("Santa Cruz");
        h2.changeHotelLocation("San Diego");
        assertEquals("Santa Cruz", h1.getHotelLocation());
        assertEquals("San Diego", h2.getHotelLocation());
    }

}
