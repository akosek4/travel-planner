package persistence;

import model.ListOfTrips;
import model.Trip;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//Code is based on JsonSerializationDemo

//Represents the Reader class tests

public class ReaderTest extends JsonTest {
    @Test
    void testReaderNonExistentFile() {
        Reader reader = new Reader("./data/noFile.json");
        try {
            reader.read();
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
            assertEquals(0, lot.getTripsSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralList() {
        Reader reader = new Reader("./data/testReaderGeneralList.json");
        try {
            ListOfTrips lot = reader.read();
            List<Trip> trips = lot.getTrips();
            assertEquals(2, trips.size());
            checkTrip("trip1", "september 1", "Hawaii",200, 900,
                    "UA900", "Marriot", 900, trips.get(0));
            checkTrip("trip2", "may 1", "Vancouver", 400, 1300,
                    "UA555","Best Western", 400, trips.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
