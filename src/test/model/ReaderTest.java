package model;

import org.junit.jupiter.api.Test;
import persistence.Reader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//Code is based on JsonSerializationDemo

//Represents the Reader class tests

public class ReaderTest extends JsonTest{
    @Test
    void testReaderNonExistentFile() {
        Reader reader = new Reader("./data/noFile.json");
        try {
            ListOfTrips lot = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyList() {
        Reader reader = new Reader("./data/testReaderEmptyList.json");
        try {
            ListOfTrips lot = reader.read();
            assertEquals("My trips", lot.getTripsName());
            assertEquals(0, lot.getTripsSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralList() {
        Reader reader = new Reader("./data/testReaderGeneralList.json");
        Flight flight1 = new Flight(200, "september 1", 900, "UA900", "SFO",
                "YVR");
        Flight flight2 = new Flight(400, "may 1", 1300, "UA555", "YVR",
                "SFO");
        Hotel hotel1 = new Hotel("Marriot", 900, "september 1", 7, "Hawaii");
        Hotel hotel2 = new Hotel("Best Western", 400, "may 1", 4, "Santa Cruz");
        try {
            ListOfTrips lot = reader.read();
            assertEquals("My trips", lot.getTripsName());
            List<Trip> trips = lot.getTrips();
            assertEquals(2, trips.size());
            checkTrip("trip1", "september 1", 200, "september 1", 900,
                    "UA900", "SFO", "YVR", "Marriot", 900,
                    "september 1", 7, "Hawaii", trips.get(0));
            checkTrip("trip2", "may 1", 400, "may 1", 1300,
                    "UA555", "YVR", "SFO", "Best Western", 400,
                    "may 1", 4, "Santa Cruz", trips.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
