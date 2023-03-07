package persistence;

import model.Flight;
import model.Hotel;
import model.ListOfTrips;
import model.Trip;
import org.junit.jupiter.api.Test;
import persistence.JsonTest;
import persistence.Reader;
import persistence.Writer;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//Code is based on JsonSerializationDemo

//Represents the hotel class tests

public class WriterTest extends JsonTest {

    @Test
    void testWriterInvalid() {
        try {
            ListOfTrips lot = new ListOfTrips("My trips");
            Writer writer = new Writer("./data/my\0illegalfileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyList() {
        try {
            ListOfTrips lot = new ListOfTrips("My trips");
            Writer writer = new Writer("./data/testWriterEmptyList.json");
            writer.open();
            writer.write(lot);
            writer.close();

            Reader reader = new Reader("./data/testWriterEmptyList.json");
            lot = reader.read();
            assertEquals("My trips", lot.getTripsName());
            assertEquals(0, lot.getTripsSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralList() {
        Flight flight1 = new Flight(200, "september 1", 900, "UA900", "SFO",
                "YVR");
        Flight flight2 = new Flight(400, "may 1", 1300, "UA555", "YVR",
                "SFO");
        Hotel hotel1 = new Hotel("Marriot", 900, "september 1", 7, "Hawaii");
        Hotel hotel2 = new Hotel("Best Western", 400, "may 1", 4, "Santa Cruz");
        Trip trip1 = new Trip("trip1", "september 1", flight1, hotel1);
        Trip trip2 = new Trip("trip2", "may 1", flight2, hotel2);
        try {
            ListOfTrips lot = new ListOfTrips("My trips");
            lot.addTrip(trip1);
            lot.addTrip(trip2);
            Writer writer = new Writer("./data/testWriterGeneralList.json");
            writer.open();
            writer.write(lot);
            writer.close();

            Reader reader = new Reader("./data/testWriterGeneralList.json");
            lot = reader.read();
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
            fail("Exception should not have been thrown");
        }
    }
}
