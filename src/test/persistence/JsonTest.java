package persistence;

import model.Trip;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Code is based on JsonSerializationDemo

//Represents the tests to check if read trips are correct

public class JsonTest {
    protected void checkTrip(String tripName, String tripDate, int flightPrice, String flightDate, int flightTime,
    String flightID, String flightDes, String flightDep, String hotelName, int hotelPrice, String hotelDate,
    int hotelDuration, String hotelLocation, Trip trip) {
        assertEquals(tripName, trip.getTripName());
        assertEquals(tripDate, trip.getTripDate());
        assertEquals(flightPrice, trip.getFlight().getFlightPrice());
        assertEquals(flightDate, trip.getFlight().getFlightDate());
        assertEquals(flightTime, trip.getFlight().getFlightTime());
        assertEquals(flightID, trip.getFlight().getFlightID());
        assertEquals(flightDes, trip.getFlight().getFLightDestination());
        assertEquals(flightDep, trip.getFlight().getFlightDeparture());
        assertEquals(hotelName, trip.getHotel().getHotelName());
        assertEquals(hotelPrice, trip.getHotel().getHotelPrice());
        assertEquals(hotelDate, trip.getHotel().getHotelDate());
        assertEquals(hotelDuration, trip.getHotel().getHotelDuration());
        assertEquals(hotelLocation, trip.getHotel().getHotelLocation());
    }
}
