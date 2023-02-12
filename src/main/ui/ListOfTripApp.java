package ui;

import model.*;

import java.util.List;
import java.util.Scanner;

public class ListOfTripApp {
    private Scanner input;
    private ListOfTrips trips;

    //EFFECTS: runs the list of trip application
    public ListOfTripApp() {
        runListOfTrip();
    }

    //MODIFIES: this
    //EFFECTS: processes user input
    private void runListOfTrip() {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            displayMainMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processListOfTripCommand(command);
            }
        }
        System.out.println("\nGoodbye!");
    }

    // EFFECTS: displays menu of options to user
    private void displayMainMenu() {
        System.out.println("\n Select from:");
        System.out.println("\tv -> view all trips");
        System.out.println("\ts -> select a trip");
        System.out.println("\ta -> add a trip");
        System.out.println("\tr -> remove a trip");
        System.out.println("\tq -> quit");
    }

    //EFFECTS: displays prompt for user to input name selection
    private void displayNamePrompt() {
        System.out.println("\n Write name/ID: ");
    }

    //EFFECTS: displays prompt for user to input date selection
    private void displayDatePrompt() {
        System.out.println("\n Write date: ");
    }

    //EFFECTS: displays prompt for user to input price selection
    private void displayPricePrompt() {
        System.out.println("\n Write price: ");
    }

    //EFFECTS: displays prompt for user to input duration selection
    private void displayDurationPrompt() {
        System.out.println("\n Write duration: ");
    }

    //EFFECTS: displays prompt for user to input location selection
    private void displayLocationPrompt() {
        System.out.println("\n Write location: ");
    }

    //EFFECTS: displays prompt for user to input time selection
    private void displayTimePrompt() {
        System.out.println("\n Write time: ");
    }

    //EFFECTS: displays prompt for user to input destination selection
    private void displayDestinationPrompt() {
        System.out.println("\n Write destination: ");
    }

    //EFFECTS: displays prompt for user to input departure selection
    private void displayDeparturePrompt() {
        System.out.println("\n Write departure: ");
    }

    //EFFECTS: displays prompt for user to input hotel selection
    private void displayHotelPrompt() {
        System.out.println("\n Write hotel details: ");
    }

    //EFFECTS: displays prompt for user to input flight selection
    private void displayFLightPrompt() {
        System.out.println("\n Write flight details: ");
    }

    //EFFECTS: displays prompt for user to input trip selection
    private void displayTripPrompt() {
        System.out.println("\n Write trip details: ");
    }


    //MODIFIES: this
    //EFFECTS: processes user command
    private void processListOfTripCommand(String command) {
        if (command.equals("v")) {
            viewAllTrips();
        } else if (command.equals("s")) {
            displayNamePrompt();
            selectTrip(command);
        } else if (command.equals("a")) {
            displayTripPrompt();
            displayNamePrompt();
            String tripName = command;
            displayDatePrompt();
            String tripDate = command;

            displayHotelPrompt();
            displayNamePrompt();
            String hotelName = command;
            displayPricePrompt();
            int hotelPrice = Integer.parseInt(command);
            displayDatePrompt();
            String hotelDate = command;
            displayDurationPrompt();
            int hotelDuration = Integer.parseInt(command);
            displayLocationPrompt();
            String hotelLocation = command;

            displayFLightPrompt();
            displayPricePrompt();
            int flightPrice = Integer.parseInt(command);
            displayDatePrompt();
            String flightDate = command;
            displayTimePrompt();
            int flightTime = Integer.parseInt(command);
            displayNamePrompt();
            String flightID = command;
            displayDestinationPrompt();
            String flightDes = command;
            displayDeparturePrompt();
            String flightDep = command;

            addTrip(tripName, tripDate, hotelName, hotelPrice, hotelDate, hotelDuration, hotelLocation, flightPrice,
                    flightDate, flightTime, flightID, flightDes, flightDep);
        } else if (command.equals("r")) {
            displayNamePrompt();
            removeTrip(command);
        } else {
            System.out.println("Selection is not valid");
        }
    }

    private void removeTrip(String name) {
        Trip trip = trips.getTrip(name);
        trips.removeTrip(trip);
    }

    private void addTrip(String name, String date, String hotelName, int hotelPrice, String hotelDate,
                         int hotelDuration, String hotelLocation, int flightPrice, String flightDate, int flightTime,
                         String flightID, String flightDes, String flightDep) {
        Flight flight = new Flight(flightPrice, flightDate, flightTime, flightID, flightDes, flightDep);
        Hotel hotel = new Hotel(hotelName, hotelPrice, hotelDate, hotelDuration, hotelLocation);
        Trip trip = new Trip(name, date, flight, hotel);
        trips.addTrip(trip);
    }

    private void selectTrip(String name) {
        Trip trip = trips.getTrip(name);
        String command = null;
        command = input.next();
        command = command.toLowerCase();
        displayTripMenu();
        processTripCommand(command, trip);
    }

    private void viewAllTrips() {
        trips.getTrips();
    }

    // EFFECTS: displays menu of options to user
    private void displayTripMenu() {
        System.out.println("\n Select from:");
        System.out.println("\tv -> view all details");
        System.out.println("\th -> view hotel");
        System.out.println("\tf -> view flight");
        System.out.println("\ta -> view all activities");
        System.out.println("\tq -> quit");
    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processTripCommand(String command, Trip trip) {
        if (command.equals("v")) {
            viewTripDetails(trip);
        } else if (command.equals("h")) {
            viewHotel(trip);
        } else if (command.equals("f")) {
            viewFlight(trip);
        } else if (command.equals("a")) {
            viewActivities(trip);
        } else {
            System.out.println("Selection is not valid");
        }
    }

    private void viewActivities(Trip trip) {
        List<Activity> activities = trip.getActivities();
        String command = null;
        command = input.next();
        command = command.toLowerCase();
        displayListOfActivityMenu();
        processListOfActivityCommand(command, activities, trip);
    }

    private void viewFlight(Trip trip) {
        Flight flight = trip.getFlight();
        String command = null;
        command = input.next();
        command = command.toLowerCase();
        displayFlightMenu();
        processFlightCommand(command, flight);
    }

    private void viewHotel(Trip trip) {
        Hotel hotel = trip.getHotel();
        String command = null;
        command = input.next();
        command = command.toLowerCase();
        displayHotelMenu();
        processHotelCommand(command, hotel);
    }

    private void viewTripDetails(Trip trip) {
        trip.getTripDate();
        trip.getTripName();
        trip.getTripPrice();
    }

    // EFFECTS: displays menu of options to user
    private void displayHotelMenu() {
        System.out.println("\n Select from:");
        System.out.println("\tv -> view all details");
        System.out.println("\ta -> change all hotel details");
        System.out.println("\tdu -> change duration");
        System.out.println("\tp -> change price");
        System.out.println("\tn -> change name");
        System.out.println("\tda -> change date");
        System.out.println("\tl -> change location");
        System.out.println("\tq -> quit");
    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processHotelCommand(String command, Hotel hotel) {
        if (command.equals("v")) {
            viewHotelDetails(hotel);
        } else if (command.equals("du")) {
            displayDurationPrompt();
            changeHotelDuration(hotel, Integer.parseInt(command));
        } else if (command.equals("p")) {
            displayPricePrompt();
            changeHotelPrice(hotel, Integer.parseInt(command));
        } else if (command.equals("n")) {
            displayNamePrompt();
            changeHotelName(hotel, command);
        } else if (command.equals("da")) {
            displayDatePrompt();
            changeHotelDate(hotel, command);
        } else if (command.equals("l")) {
            displayLocationPrompt();
            changeHotelLocation(hotel, command);
        } else {
            System.out.println("Selection is not valid");
        }
    }

    private void changeHotelLocation(Hotel hotel, String location) {
        hotel.changeLocation(location);
    }

    private void changeHotelDate(Hotel hotel, String date) {
        hotel.changeDate(date);
    }

    private void changeHotelName(Hotel hotel, String name) {
        hotel.changeName(name);
    }

    private void changeHotelPrice(Hotel hotel, int price) {
        hotel.changePrice(price);
    }

    private void changeHotelDuration(Hotel hotel, int duration) {
        hotel.changeDuration(duration);
    }

    private void viewHotelDetails(Hotel hotel) {
        hotel.getHotelPrice();
        hotel.getHotelDate();
        hotel.getHotelLocation();
        hotel.getHotelDuration();
        hotel.getHotelName();
    }

    // EFFECTS: displays menu of options to user
    private void displayFlightMenu() {
        System.out.println("\n Select from:");
        System.out.println("\tv -> view all details");
        System.out.println("\ta -> change all flight details");
        System.out.println("\tt -> change time");
        System.out.println("\tp -> change price");
        System.out.println("\ti -> change ID");
        System.out.println("\tda -> change date");
        System.out.println("\tdes -> change destination location");
        System.out.println("\tdep -> change departure location");
        System.out.println("\tq -> quit");
    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processFlightCommand(String command, Flight flight) {
        if (command.equals("v")) {
            viewFlightDetails(flight);
        } else if (command.equals("t")) {
            displayTimePrompt();
            changeFlightTime(flight, Integer.parseInt(command));
        } else if (command.equals("p")) {
            displayPricePrompt();
            changeFlightPrice(flight, Integer.parseInt(command));
        } else if (command.equals("i")) {
            displayNamePrompt();
            changeFlightID(flight, command);
        } else if (command.equals("d")) {
            displayDatePrompt();
            changeFlightDate(flight, command);
        } else if (command.equals("des")) {
            displayDestinationPrompt();
            changeFlightDestination(flight, command);
        } else if (command.equals("dep")) {
            displayDeparturePrompt();
            changeFlightDeparture(flight, command);
        } else {
            System.out.println("Selection is not valid");
        }
    }

    private void changeFlightDeparture(Flight flight, String departure) {
        flight.changeDeparture(departure);
    }

    private void changeFlightDestination(Flight flight, String destination) {
        flight.changeDestination(destination);
    }

    private void changeFlightDate(Flight flight, String date) {
        flight.changeDate(date);
    }

    private void changeFlightID(Flight flight, String id) {
        flight.changeID(id);
    }

    private void changeFlightPrice(Flight flight, int price) {
        flight.changePrice(price);
    }

    private void changeFlightTime(Flight flight, int time) {
        flight.changeTime(time);
    }

    private void viewFlightDetails(Flight flight) {
        flight.getFlightPrice();
        flight.getFlightID();
        flight.getFlightDate();
        flight.getFlightDeparture();
        flight.getFlightTime();
        flight.getFLightDestination();
    }

    // EFFECTS: displays menu of options to user
    private void displayListOfActivityMenu() {
        System.out.println("\n Select from:");
        System.out.println("\tv -> view all activities");
        System.out.println("\ts -> select an activity");
        System.out.println("\ta -> add an activity");
        System.out.println("\tr -> remove an activity");
        System.out.println("\tq -> quit");
    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processListOfActivityCommand(String command, List<Activity> activities, Trip trip) {
        if (command.equals("v")) {
            viewAllActivities(trip);
        } else if (command.equals("s")) {
            displayNamePrompt();
            selectActivity(trip, command);
        } else if (command.equals("a")) {
            displayNamePrompt();
            String name = command;
            displayPricePrompt();
            int price = Integer.parseInt(command);
            displayDatePrompt();
            String date = command;
            displayTimePrompt();
            int time = Integer.parseInt(command);
            displayLocationPrompt();
            String location = command;
            addActivity(activities, name, price, date, time, location);
        } else if (command.equals("r")) {
            displayNamePrompt();
            removeActivity(activities, trip, command);
        } else {
            System.out.println("Selection is not valid");
        }
    }

    private void removeActivity(List<Activity> activities, Trip trip, String name) {
        Activity activity = trip.getActivity(name);
        if (activities.contains(activity)) {
            activities.remove(activity);
        }
    }

    private void addActivity(List<Activity> activities, String name, int price, String date, int time,
                             String location) {
        Activity activity = new Activity(name, price, date, time, location);
        activities.add(activity);
    }

    private void selectActivity(Trip trip, String name) {
        Activity activity = trip.getActivity(name);
        String command = null;
        command = input.next();
        command = command.toLowerCase();
        displayActivityMenu();
        processActivityCommand(command, activity);
    }

    private void viewAllActivities(Trip trip) {
        trip.getActivities();
    }

    // EFFECTS: displays menu of options to user
    private void displayActivityMenu() {
        System.out.println("\n Select from:");
        System.out.println("\tv -> view all details");
        System.out.println("\tn -> change name");
        System.out.println("\tp -> change price");
        System.out.println("\td -> change date");
        System.out.println("\tt -> change time");
        System.out.println("\tl -> change location");
        System.out.println("\tq -> quit");
    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processActivityCommand(String command, Activity activity) {
        if (command.equals("v")) {
            viewActivityDetails(activity);
        } else if (command.equals("n")) {
            changeActivityName(activity, command);
        } else if (command.equals("p")) {
            changeActivityPrice(activity, Integer.parseInt(command));
        } else if (command.equals("t")) {
            changeActivityTime(activity, Integer.parseInt(command));
        } else if (command.equals("d")) {
            changeActivityDate(activity, command);
        } else if (command.equals("l")) {
            changeActivityLocation(activity, command);
        } else {
            System.out.println("Selection is not valid");
        }
    }

    private void changeActivityLocation(Activity activity, String location) {
        activity.changeLocation(location);
    }

    private void changeActivityDate(Activity activity, String date) {
        activity.changeDate(date);
    }

    private void changeActivityTime(Activity activity, int time) {
        activity.changeTime(time);
    }

    private void changeActivityPrice(Activity activity, int price) {
        activity.changePrice(price);
    }

    private void changeActivityName(Activity activity, String name) {
        activity.changeName(name);
    }

    private void viewActivityDetails(Activity activity) {
        activity.getDate();
        activity.getLocation();
        activity.getName();
        activity.getPrice();
        activity.getTime();
    }


}
