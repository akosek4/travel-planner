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


    //MODIFIES: this
    //EFFECTS: processes user command
    //TODO: Figure out how to add/insert more user inputs
    private void processListOfTripCommand(String command) {
        if (command.equals("v")) {
            viewAllTrips();
        } else if (command.equals("s")) {
            selectTrip();
        } else if (command.equals("a")) {
            addTrip();
        } else if (command.equals("r")) {
            removeTrip();
        } else {
            System.out.println("Selection is not valid");
        }
    }

    private void removeTrip(String name) {
        Trip trip = trips.getTrip(name);
        trips.removeTrip(trip);
    }

    private void addTrip(String name) {
        Trip trip = trips.getTrip(name);
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
            veiwHotel(trip);
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

    private void veiwHotel(Trip trip) {
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
    //TODO: Figure out how to add/insert more user inputs
    private void processHotelCommand(String command, Hotel hotel) {
        if (command.equals("v")) {
            veiwHotelDetails(hotel);
        } else if (command.equals("du")) {
            changeHotelDuration(hotel);
        } else if (command.equals("p")) {
            changeHotelPrice(hotel);
        } else if (command.equals("n")) {
            changeHotelName(hotel);
        } else if (command.equals("da")) {
            changeHotelDate(hotel);
        } else if (command.equals("l")) {
            changeHotelLocation(hotel);
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

    private void veiwHotelDetails(Hotel hotel) {
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
    //TODO: Figure out how to add/insert more user inputs
    private void processFlightCommand(String command, Flight flight) {
        if (command.equals("v")) {
            veiwFlightDetails(flight);
        } else if (command.equals("t")) {
            changeFlightTime(flight);
        } else if (command.equals("p")) {
            changeFlightPrice(flight);
        } else if (command.equals("i")) {
            changeFlightID(flight);
        } else if (command.equals("d")) {
            changeFlightDate(flight);
        } else if (command.equals("des")) {
            changeFlightDestination(flight);
        } else if (command.equals("dep")) {
            changeFlightDeparture(flight);
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

    private void veiwFlightDetails(Flight flight) {
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
    //TODO: Figure out how to add/insert more user inputs
    private void processListOfActivityCommand(String command, List<Activity> activities, Trip trip) {
        if (command.equals("v")) {
            veiwAllActivities(trip);
        } else if (command.equals("s")) {
            selectActivity(activities);
        } else if (command.equals("a")) {
            addActivity(activities, trip);
        } else if (command.equals("r")) {
            removeActivity(activities);
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

    private void addActivity(List<Activity> activities, Activity activity) {
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

    private void veiwAllActivities(Trip trip) {
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
    //TODO: Figure out how to add/insert more user inputs
    private void processActivityCommand(String command, Activity activity) {
        if (command.equals("v")) {
            veiwActivityDetails(activity);
        } else if (command.equals("n")) {
            changeActivityName(activity);
        } else if (command.equals("p")) {
            changeActivityPrice(activity);
        } else if (command.equals("t")) {
            changeActivityTime(activity);
        } else if (command.equals("d")) {
            changeActivitylDate(activity);
        } else if (command.equals("l")) {
            changeActivityLocation(activity);
        } else {
            System.out.println("Selection is not valid");
        }
    }

    private void changeActivityLocation(Activity activity, String location) {
        activity.changeLocation(location);
    }

    private void changeActivitylDate(Activity activity, String date) {
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

    private void veiwActivityDetails(Activity activity) {
        activity.getDate();
        activity.getLocation();
        activity.getName();
        activity.getPrice();
        activity.getTime();
    }


}
