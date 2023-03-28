package persistence;

import model.Flight;
import model.Hotel;
import model.ListOfTrips;
import model.Trip;
import org.junit.jupiter.api.Test;

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
            ListOfTrips lot = new ListOfTrips();
            Writer writer = new Writer("./data/testWriterEmptyList.json");
            writer.open();
            writer.write(lot);
            writer.close();

            Reader reader = new Reader("./data/testWriterEmptyList.json");
            lot = reader.read();
            assertEquals(0, lot.getTripsSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralList() {
        Flight flight1 = new Flight(200, 900, "UA900");
        Flight flight2 = new Flight(400, 1300, "UA555");
        Hotel hotel1 = new Hotel("Marriot", 900);
        Hotel hotel2 = new Hotel("Best Western", 400);
        Trip trip1 = new Trip("trip1", "september 1", "Hawaii", flight1, hotel1);
        Trip trip2 = new Trip("trip2", "may 1", "Vancouver", flight2, hotel2);
        try {
            ListOfTrips lot = new ListOfTrips();
            lot.addTrip(trip1);
            lot.addTrip(trip2);
            Writer writer = new Writer("./data/testWriterGeneralList.json");
            writer.open();
            writer.write(lot);
            writer.close();

            Reader reader = new Reader("./data/testWriterGeneralList.json");
            lot = reader.read();
            List<Trip> trips = lot.getTrips();
            assertEquals(2, trips.size());
            checkTrip("trip1", "september 1", "Hawaii",200, 900,
                    "UA900", "Marriot", 900, trips.get(0));
            checkTrip("trip2", "may 1", "Vancouver", 400, 1300,
                    "UA555","Best Western", 400, trips.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
