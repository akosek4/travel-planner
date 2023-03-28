package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Represents the hotel class tests

public class HotelTest {
    private Hotel h1;
    private Hotel h2;

    @BeforeEach
    public void setup() {
        h1 = new Hotel("The Modern Honolulu", 2800);

        h2  = new Hotel("The Westin Bayshore", 1900);
    }

    @Test
    public void testConstructor() {
        assertEquals(2800, h1.getHotelPrice());
        assertEquals(1900, h2.getHotelPrice());
        assertEquals("The Modern Honolulu", h1.getHotelName());
        assertEquals("The Westin Bayshore", h2.getHotelName());
    }



    @Test
    public void changePriceTest() {
        h1.changePrice(1700);
        h2.changePrice(0);
        assertEquals(1700, h1.getHotelPrice());
        assertEquals(0, h2.getHotelPrice());
    }

    @Test
    public void changeNameTest() {
        h1.changeName("Best Western Santa Cruz");
        h2.changeName("Motel 6 San Diego");
        assertEquals("Best Western Santa Cruz", h1.getHotelName());
        assertEquals("Motel 6 San Diego", h2.getHotelName());
    }

}
