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
            String flightDate = input.next();;
            displayTimePrompt();
            int flightTime = input.nextInt();
            displayNamePrompt();
            String flightID = input.next();;
            displayDestinationPrompt();
            String flightDes = input.next();;
            displayDeparturePrompt();
            String flightDep = input.next();;

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

    // TODO: fix
    private void removeTrip(String name) {
        Trip trip = trips.getTrip(name);
        trips.removeTrip(trip);
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
        Trip trip = trips.getTrip(name);
        displayTripMenu();
        processTripCommand(input.next(), trip);
    }

    private void viewAllTrips() {
        System.out.println(trips.printAllTrips());
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
        System.out.println(trip.getTripDate());
        System.out.println(trip.getTripName());
        System.out.println(trip.getTripPrice());
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
            int hotelDuration = input.nextInt();
            changeHotelDuration(hotel, hotelDuration);
        } else if (command.equals("p")) {
            displayPricePrompt();
            int hotelPrice = input.nextInt();
            changeHotelPrice(hotel, hotelPrice);
        } else if (command.equals("n")) {
            displayNamePrompt();
            String hotelName = input.next();
            changeHotelName(hotel, hotelName);
        } else if (command.equals("da")) {
            displayDatePrompt();
            String hotelDate = input.next();
            changeHotelDate(hotel, hotelDate);
        } else if (command.equals("l")) {
            displayLocationPrompt();
            String hotelLoc = input.next();
            changeHotelLocation(hotel, hotelLoc);
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
        System.out.println(hotel.getHotelPrice());
        System.out.println(hotel.getHotelDate());
        System.out.println(hotel.getHotelLocation());
        System.out.println(hotel.getHotelDuration());
        System.out.println(hotel.getHotelName());
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
            int flightTime = input.nextInt();
            changeFlightTime(flight, flightTime);
        } else if (command.equals("p")) {
            displayPricePrompt();
            int flightPrice = input.nextInt();
            changeFlightPrice(flight, flightPrice);
        } else if (command.equals("i")) {
            displayNamePrompt();
            String flightName = input.next();
            changeFlightID(flight, flightName);
        } else if (command.equals("d")) {
            displayDatePrompt();
            String flightDate = input.next();
            changeFlightDate(flight, flightDate);
        } else if (command.equals("des")) {
            displayDestinationPrompt();
            String flightDes = input.next();
            changeFlightDestination(flight, flightDes);
        } else if (command.equals("dep")) {
            displayDeparturePrompt();
            String flightDep = input.next();
            changeFlightDeparture(flight, flightDep);
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
    private void processListOfActivityCommand(String command, List<Activity> activities, Trip trip) {
        if (command.equals("v")) {
            viewAllActivities(trip);
        } else if (command.equals("s")) {
            displayNamePrompt();
            String actName = input.next();
            selectActivity(trip, actName);
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
            addActivity(activities, actName, actPrice, actDate, actTime, actLoc);
        } else if (command.equals("r")) {
            displayNamePrompt();
            String actName = input.next();
            removeActivity(activities, trip, actName);
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
    private void processActivityCommand(String command, Activity activity) {
        if (command.equals("v")) {
            viewActivityDetails(activity);
        } else if (command.equals("n")) {
            displayNamePrompt();
            String actName = input.next();
            changeActivityName(activity, actName);
        } else if (command.equals("p")) {
            displayPricePrompt();
            int actPrice = input.nextInt();
            changeActivityPrice(activity, actPrice);
        } else if (command.equals("t")) {
            displayTimePrompt();
            int actTime = input.nextInt();
            changeActivityTime(activity, actTime);
        } else if (command.equals("d")) {
            displayDatePrompt();
            String actDate = input.next();
            changeActivityDate(activity, actDate);
        } else if (command.equals("l")) {
            displayLocationPrompt();
            String actLoc = input.next();
            changeActivityLocation(activity, actLoc);
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
        System.out.println(activity.getDate());
        System.out.println(activity.getLocation());
        System.out.println(activity.getName());
        System.out.println(activity.getPrice());
        System.out.println(activity.getTime());
    }


}
