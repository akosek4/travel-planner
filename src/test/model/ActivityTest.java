package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Represents the activity class tests

public class ActivityTest {
    private Activity a1;
    private Activity a2;

    @BeforeEach
    public void setup() {
        a1 = new Activity("Zip Lining",300, "December 1", 900,
                "Kona");
        a2  = new Activity("ATV Riding",500, "May 2", 1300,
                "Santa Cruz");
    }

    @Test
    public void constructorTest() {
        assertEquals("Zip Lining", a1.getName());
        assertEquals("ATV Riding", a2.getName());
        assertEquals(300, a1.getPrice());
        assertEquals(500, a2.getPrice());
        assertEquals("December 1", a1.getDate());
        assertEquals("May 2", a2.getDate());
        assertEquals(900, a1.getTime());
        assertEquals(1300, a2.getTime());
        assertEquals("Kona", a1.getLocation());
        assertEquals("Santa Cruz", a2.getLocation());

    }

    @Test
    public void changeNameTest() {
        a1.changeName("Tree Top Fun");
        a2.changeName("Beach Day");
        assertEquals("Tree Top Fun", a1.getName());
        assertEquals("Beach Day", a2.getName());
    }

    @Test
    public void changePriceTest() {
        a1.changePrice(135);
        a2.changePrice(0);
        assertEquals(135, a1.getPrice());
        assertEquals(0, a2.getPrice());
    }

    @Test
    public void changeDateTest() {
        a1.changeDate("August 10");
        a2.changeDate("October 1");
        assertEquals("August 10", a1.getDate());
        assertEquals("October 1", a2.getDate());
    }

    @Test
    public void changeTimeTest() {
        a1.changeTime(1000);
        a2.changeTime(0);
        assertEquals(1000, a1.getTime());
        assertEquals(0, a2.getTime());
    }

    @Test
    public void changeLocationTest() {
        a1.changeLocation("Maui");
        a2.changeLocation("Scotts Valley");
        assertEquals("Maui", a1.getLocation());
        assertEquals("Scotts Valley", a2.getLocation());
    }
}
