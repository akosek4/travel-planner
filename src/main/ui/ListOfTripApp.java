package ui;

import model.Hotel;
import model.ListOfTrips;
import model.Trip;

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

    //TODO: figure out why call to getTrip isn't working
    private void removeTrip(String name) {
        Trip trip = getTrip(name);
        trips.removeTrip(trip);
    }

    //TODO: figure out why call to getTrip isn't working
    private void addTrip(String name) {
        Trip trip = getTrip(name);
        trips.addTrip(trip);
    }

    //TODO: figure out why call to getTrip isn't working
    private void selectTrip(String name) {
        Trip trip = getTrip(name);
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
            veiwTripDetails(trip);
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
        trip.getActivities();
    }

    private void viewFlight(Trip trip) {
        trip.getFlight();
    }

    private void veiwHotel(Trip trip) {
        Hotel hotel = trip.getHotel();
        String command = null;
        command = input.next();
        command = command.toLowerCase();
        displayHotelMenu();
        processHotelCommand(command, hotel);
    }

    private void veiwTripDetails(Trip trip) {
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

    //TODO: figure out how to insert user command into method call
    private void changeHotelLocation(Hotel hotel) {
        hotel.changeLocation();
    }

    //TODO: figure out how to insert user command into method call
    private void changeHotelDate(Hotel hotel) {
        hotel.changeDate();
    }

    //TODO: figure out how to insert user command into method call
    private void changeHotelName(Hotel hotel) {
        hotel.changeName();
    }

    //TODO: figure out how to insert user command into method call
    private void changeHotelPrice(Hotel hotel) {
        hotel.changePrice();
    }

    //TODO: figure out how to insert user command into method call
    private void changeHotelDuration(Hotel hotel) {
        hotel.changeDuration();
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
    private void processFlightCommand(String command) {
        if (command.equals("v")) {
            veiwFlightDetails();
        } else if (command.equals("a")) {
            changeAllFlight();
        } else if (command.equals("t")) {
            changeFlightTime();
        } else if (command.equals("p")) {
            changeFlightPrice();
        } else if (command.equals("i")) {
            changeFlightID();
        } else if (command.equals("d")) {
            changeFlightDate();
        } else if (command.equals("des")) {
            changeFlightDestination();
        } else if (command.equals("dep")) {
            changeFlightDeparture();
        } else {
            System.out.println("Selection is not valid");
        }
    }

    //TODO: finish method body
    private void changeFlightDeparture() {
    }

    //TODO: finish method body
    private void changeFlightDestination() {
    }

    //TODO: finish method body
    private void changeFlightDate() {
    }

    //TODO: finish method body
    private void changeFlightID() {
    }

    //TODO: finish method body
    private void changeFlightPrice() {
    }

    //TODO: finish method body
    private void changeFlightTime() {
    }

    //TODO: finish method body
    private void changeAllFlight() {
    }

    //TODO: finish method body
    private void veiwFlightDetails() {
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
    private void processListOfActivityCommand(String command) {
        if (command.equals("v")) {
            veiwAllActivities();
        } else if (command.equals("s")) {
            selectActivity();
        } else if (command.equals("a")) {
            addActivity();
        } else if (command.equals("r")) {
            removeActivity();
        } else {
            System.out.println("Selection is not valid");
        }
    }

    //TODO: finish method body
    private void removeActivity() {
    }

    //TODO: finish method body
    private void addActivity() {
    }

    //TODO: finish method body
    private void selectActivity() {
    }

    //TODO: finish method body
    private void veiwAllActivities() {
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
    private void processActivityCommand(String command) {
        if (command.equals("v")) {
            veiwActivityDetails();
        } else if (command.equals("n")) {
            changeActivityName();
        } else if (command.equals("p")) {
            changeActivityPrice();
        } else if (command.equals("t")) {
            changeActivityTime();
        } else if (command.equals("d")) {
            changeActivitylDate();
        } else if (command.equals("l")) {
            changeActivityLocation();
        } else {
            System.out.println("Selection is not valid");
        }
    }

    //TODO: finish method body
    private void changeActivityLocation() {
    }

    //TODO: finish method body
    private void changeActivitylDate() {
    }

    //TODO: finish method body
    private void changeActivityTime() {
    }

    //TODO: finish method body
    private void changeActivityPrice() {
    }

    //TODO: finish method body
    private void changeActivityName() {
    }

    //TODO: finish method body
    private void veiwActivityDetails() {
    }


}
