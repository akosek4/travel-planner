package ui;

import model.*;

import java.util.List;
import java.util.Scanner;

public class ListOfTripApp {
    private Scanner input;
    private ListOfTrips trips;
    private Trip trip;
    private Hotel hotel;
    private Flight flight;
    private List<Activity> activities;
    private Activity activity;

    //EFFECTS: runs the list of trip application
    public ListOfTripApp() {
        runListOfTrip();
    }

    //MODIFIES: this
    //EFFECTS: processes user input
    private void runListOfTrip() {
        boolean keepGoing = true;
        String command = null;

        init();

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

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        trips = new ListOfTrips();
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
            String tripName = input.next();
            selectTrip(tripName);
        } else if (command.equals("a")) {
            displayTripPrompt();
            displayNamePrompt();
            String tripName = input.next();
            displayDatePrompt();
            String tripDate = input.next();

            displayHotelPrompt();
            displayNamePrompt();
            String hotelName = input.next();
            displayPricePrompt();
            int hotelPrice = input.nextInt();
            displayDatePrompt();
            String hotelDate = input.next();
            displayDurationPrompt();
            int hotelDuration = input.nextInt();
            displayLocationPrompt();
            String hotelLocation = input.next();

            displayFLightPrompt();
            displayPricePrompt();
            int flightPrice = input.nextInt();
            displayDatePrompt();
            String flightDate = input.next();
            displayTimePrompt();
            int flightTime = input.nextInt();
            displayNamePrompt();
            String flightID = input.next();
            displayDestinationPrompt();
            String flightDes = input.next();
            displayDeparturePrompt();
            String flightDep = input.next();

            addTrip(tripName, tripDate, hotelName, hotelPrice, hotelDate, hotelDuration, hotelLocation, flightPrice,
                    flightDate, flightTime, flightID, flightDes, flightDep);
        } else if (command.equals("r")) {
            displayNamePrompt();
            String tripName = input.next();
            removeTrip(tripName);
        } else {
            System.out.println("Selection is not valid");
        }
    }

    private void removeTrip(String name) {
        this.trip = trips.getTrip(name);
        trips.removeTrip(this.trip);
        displayMainMenu();
        processListOfTripCommand(input.next());
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
        this.trip = trips.getTrip(name);
        displayTripMenu();
        processTripCommand(input.next());
    }

    private void viewAllTrips() {
        if (trips.printAllTrips().equals("")) {
            System.out.println("No trips yet!");
        } else {
            System.out.println(trips.printAllTrips());
        }
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
    private void processTripCommand(String command) {
        if (command.equals("v")) {
            viewTripDetails();
        } else if (command.equals("h")) {
            viewHotel();
        } else if (command.equals("f")) {
            viewFlight();
        } else if (command.equals("a")) {
            viewActivities();
        } else {
            System.out.println("Selection is not valid");
        }
    }

    //MODIFIES: this
    //EFFECTS: displays Activity options
    private void viewActivities() {
        this.activities = trip.getActivities();
        displayListOfActivityMenu();
        String command = null;
        command = input.next();
        command = command.toLowerCase();
        processListOfActivityCommand(command);
    }

    //MODIFIES: this
    //EFFECTS: displays Flight options
    private void viewFlight() {
        this.flight = trip.getFlight();
        displayFlightMenu();
        String command = null;
        command = input.next();
        command = command.toLowerCase();
        processFlightCommand(command);
    }

    //MODIFIES: this
    //EFFECTS: displays Hotel options
    private void viewHotel() {
        this.hotel = trip.getHotel();
        displayHotelMenu();
        String command = null;
        command = input.next();
        command = command.toLowerCase();
        processHotelCommand(command);
    }

    //MODIFIES: this
    //EFFECTS: displays trip date, name, and price
    private void viewTripDetails() {
        System.out.println(trip.getTripDate());
        System.out.println(trip.getTripName());
        System.out.println(trip.getTripPrice());
    }

    //TODO: Fix

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
    private void processHotelCommand(String command) {
        if (command.equals("v")) {
            viewHotelDetails();
        } else if (command.equals("du")) {
            displayDurationPrompt();
            int hotelDuration = input.nextInt();
            changeHotelDuration(hotelDuration);
        } else if (command.equals("p")) {
            displayPricePrompt();
            int hotelPrice = input.nextInt();
            changeHotelPrice(hotelPrice);
        } else if (command.equals("n")) {
            displayNamePrompt();
            String hotelName = input.next();
            changeHotelName(hotelName);
        } else if (command.equals("da")) {
            displayDatePrompt();
            String hotelDate = input.next();
            changeHotelDate(hotelDate);
        } else if (command.equals("l")) {
            displayLocationPrompt();
            String hotelLoc = input.next();
            changeHotelLocation(hotelLoc);
        } else {
            System.out.println("Selection is not valid");
        }
    }

    //MODIFIES: this
    //EFFECTS: changes hotel location
    private void changeHotelLocation(String location) {
        hotel.changeLocation(location);
    }

    //MODIFIES: this
    //EFFECTS: changes hotel date
    private void changeHotelDate(String date) {
        hotel.changeDate(date);
    }

    //MODIFIES: this
    //EFFECTS: changes hotel name
    private void changeHotelName(String name) {
        hotel.changeName(name);
    }

    //MODIFIES: this
    //EFFECTS: changes hotel price
    private void changeHotelPrice(int price) {
        hotel.changePrice(price);
    }

    //MODIFIES: this
    //EFFECTS: changes hotel duration
    private void changeHotelDuration(int duration) {
        hotel.changeDuration(duration);
    }

    //MODIFIES: this
    //EFFECTS: displays hotel price, date, location, duration, and name
    private void viewHotelDetails() {
        System.out.println(hotel.getHotelPrice());
        System.out.println(hotel.getHotelDate());
        System.out.println(hotel.getHotelLocation());
        System.out.println(hotel.getHotelDuration());
        System.out.println(hotel.getHotelName());
    }

    //TODO: Fix

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
            viewFlightDetails();
        } else if (command.equals("t")) {
            displayTimePrompt();
            int flightTime = input.nextInt();
            changeFlightTime(flightTime);
        } else if (command.equals("p")) {
            displayPricePrompt();
            int flightPrice = input.nextInt();
            changeFlightPrice(flightPrice);
        } else if (command.equals("i")) {
            displayNamePrompt();
            String flightName = input.next();
            changeFlightID(flightName);
        } else if (command.equals("d")) {
            displayDatePrompt();
            String flightDate = input.next();
            changeFlightDate(flightDate);
        } else if (command.equals("des")) {
            displayDestinationPrompt();
            String flightDes = input.next();
            changeFlightDestination(flightDes);
        } else if (command.equals("dep")) {
            displayDeparturePrompt();
            String flightDep = input.next();
            changeFlightDeparture(flightDep);
        } else {
            System.out.println("Selection is not valid");
        }
    }

    //MODIFIES: this
    //EFFECTS: changes flight departure location
    private void changeFlightDeparture(String departure) {
        flight.changeDeparture(departure);
    }

    //MODIFIES: this
    //EFFECTS: changes flight destination
    private void changeFlightDestination(String destination) {
        flight.changeDestination(destination);
    }

    //MODIFIES: this
    //EFFECTS: changes flight date
    private void changeFlightDate(String date) {
        flight.changeDate(date);
    }

    //MODIFIES: this
    //EFFECTS: changes flight ID
    private void changeFlightID(String id) {
        flight.changeID(id);
    }

    //MODIFIES: this
    //EFFECTS: changes flight price
    private void changeFlightPrice(int price) {
        flight.changePrice(price);
    }

    //MODIFIES: this
    //EFFECTS: changes flight time
    private void changeFlightTime(int time) {
        flight.changeTime(time);
    }

    //MODIFIES: this
    //EFFECTS: displays flight price, id, date, departure, time, and destination
    private void viewFlightDetails() {
        System.out.println(flight.getFlightPrice());
        System.out.println(flight.getFlightID());
        System.out.println(flight.getFlightDate());
        System.out.println(flight.getFlightDeparture());
        System.out.println(flight.getFlightTime());
        System.out.println(flight.getFLightDestination());
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
            viewAllActivities();
        } else if (command.equals("s")) {
            displayNamePrompt();
            String actName = input.next();
            selectActivity(actName);
        } else if (command.equals("a")) {
            displayNamePrompt();
            String actName = input.next();
            displayPricePrompt();
            int actPrice = input.nextInt();
            displayDatePrompt();
            String actDate = input.next();
            displayTimePrompt();
            int actTime = input.nextInt();
            displayLocationPrompt();
            String actLoc = input.next();
            addActivity(actName, actPrice, actDate, actTime, actLoc);
        } else if (command.equals("r")) {
            displayNamePrompt();
            String actName = input.next();
            removeActivity(actName);
        } else {
            System.out.println("Selection is not valid");
        }
    }

    //MODIFIES: this
    //EFFECTS: removes given activity
    private void removeActivity(String name) {
        this.activity = trip.getActivity(name);
        if (activities.contains(activity)) {
            activities.remove(activity);
        }
    }

    //MODIFIES: this
    //EFFECTS: adds specified activity
    private void addActivity(String name, int price, String date, int time,
                             String location) {
        this.activity = new Activity(name, price, date, time, location);
        activities.add(activity);
    }

    //MODIFIES: this
    //EFFECTS: displays activity options
    private void selectActivity(String name) {
        this.activity = trip.getActivity(name);
        String command = null;
        command = input.next();
        command = command.toLowerCase();
        displayActivityMenu();
        processActivityCommand(command);
    }

    //MODIFIES: this
    //EFFECTS: displays all activities
    private void viewAllActivities() {
        System.out.println(trip.getActivities());
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
            viewActivityDetails();
        } else if (command.equals("n")) {
            displayNamePrompt();
            String actName = input.next();
            changeActivityName(actName);
        } else if (command.equals("p")) {
            displayPricePrompt();
            int actPrice = input.nextInt();
            changeActivityPrice(actPrice);
        } else if (command.equals("t")) {
            displayTimePrompt();
            int actTime = input.nextInt();
            changeActivityTime(actTime);
        } else if (command.equals("d")) {
            displayDatePrompt();
            String actDate = input.next();
            changeActivityDate(actDate);
        } else if (command.equals("l")) {
            displayLocationPrompt();
            String actLoc = input.next();
            changeActivityLocation(actLoc);
        } else {
            System.out.println("Selection is not valid");
        }
    }

    //MODIFIES: this
    //EFFECTS: changes activity location
    private void changeActivityLocation(String location) {
        activity.changeLocation(location);
    }

    //MODIFIES: this
    //EFFECTS: changes activity date
    private void changeActivityDate(String date) {
        activity.changeDate(date);
    }

    //MODIFIES: this
    //EFFECTS: changes activity time
    private void changeActivityTime(int time) {
        activity.changeTime(time);
    }

    //MODIFIES: this
    //EFFECTS: changes activity price
    private void changeActivityPrice(int price) {
        activity.changePrice(price);
    }

    //MODIFIES: this
    //EFFECTS: changes activity name
    private void changeActivityName(String name) {
        activity.changeName(name);
    }

    //MODIFIES: this
    //EFFECTS: displays activity date, location, name, price, and time
    private void viewActivityDetails() {
        System.out.println(activity.getDate());
        System.out.println(activity.getLocation());
        System.out.println(activity.getName());
        System.out.println(activity.getPrice());
        System.out.println(activity.getTime());
    }


}
