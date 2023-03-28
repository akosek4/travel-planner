package persistence;

import model.Trip;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Code is based on JsonSerializationDemo

//Represents the tests to check if read trips are correct

public class JsonTest {
    protected void checkTrip(String tripName, String tripDate, String tripLocation, int flightPrice, int flightTime,
    String flightName, String hotelName, int hotelPrice, Trip trip) {
        assertEquals(tripName, trip.getTripName());
        assertEquals(tripDate, trip.getTripDate());
        assertEquals(tripLocation, trip.getTripLocation());
        assertEquals(flightPrice, trip.getFlight().getFlightPrice());
        assertEquals(flightTime, trip.getFlight().getFlightTime());
        assertEquals(flightName, trip.getFlight().getFlightName());
        assertEquals(hotelName, trip.getHotel().getHotelName());
        assertEquals(hotelPrice, trip.getHotel().getHotelPrice());
    }
}
