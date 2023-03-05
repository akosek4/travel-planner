package ui;

import model.*;
import persistence.Reader;
import persistence.Writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//Code is based on TellerApp
// represents a trip application that alters, saves, and loads lists of trips

public class ListOfTripApp {
    private static final String data = "./data/listoftrip.json";
    private Scanner input;
    private ListOfTrips trips;
    private Trip trip;
    private Hotel hotel;
    private Flight flight;
    private String tripName;
    private String tripDate;
    private String hotelName;
    private int hotelPrice;
    private String hotelDate;
    private int hotelDuration;
    private String hotelLocation;
    private int flightPrice;
    private String flightDate;
    private int flightTime;
    private String flightID;
    private String flightDes;
    private String flightDep;
    private Reader reader;
    private Writer writer;

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
        displayNamePrompt();
        String tripsName = input.next();
        trips = new ListOfTrips(tripsName);
        reader = new Reader(data);
        writer = new Writer(data);
    }

    // EFFECTS: displays menu of options to user
    private void displayMainMenu() {
        System.out.println("\n Select from:");
        System.out.println("\tv -> view all trips");
        System.out.println("\tsel -> select a trip");
        System.out.println("\ta -> add a trip");
        System.out.println("\tr -> remove a trip");
        System.out.println("\tsave -> save list of trips to file");
        System.out.println("\tl -> load list of trips from file");
        System.out.println("\tq -> quit");
    }

    //EFFECTS: displays prompt for user to input name selection
    private void displayNamePrompt() {
        System.out.println("\n Write name/ID: ");
    }

    //EFFECTS: displays prompt for user to input date selection
    private void displayDatePrompt() {
        System.out.println("\n Write date (in word format): ");
    }

    //EFFECTS: displays prompt for user to input price selection
    private void displayPricePrompt() {
        System.out.println("\n Write price (int): ");
    }

    //EFFECTS: displays prompt for user to input duration selection
    private void displayDurationPrompt() {
        System.out.println("\n Write duration (int): ");
    }

    //EFFECTS: displays prompt for user to input location selection
    private void displayLocationPrompt() {
        System.out.println("\n Write location: ");
    }

    //EFFECTS: displays prompt for user to input time selection
    private void displayTimePrompt() {
        System.out.println("\n Write time (int): ");
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
            viewTrips();
        } else if (command.equals("sel")) {
            displayNamePrompt();
            String tripName = input.next();
            selectTrip(tripName);
        } else if (command.equals("a")) {
            createTrip();
            makeHotel();
            makeFlight();

            addTrip(tripName, tripDate, hotelName, hotelPrice, hotelDate, hotelDuration, hotelLocation, flightPrice,
                    flightDate, flightTime, flightID, flightDes, flightDep);
        } else if (command.equals("r")) {
            displayNamePrompt();
            String tripName = input.next();
            removeTrip(tripName);
        } else if (command.equals("save")) {
            saveTrips();
        } else if (command.equals("l")) {
            loadTrips();
        } else {
            System.out.println("Selection is not valid");
        }
    }

    //MODIFIES: this
    //EFFECTS: makes a trip to user specifications
    private void createTrip() {
        displayTripPrompt();
        displayNamePrompt();
        tripName = input.next();
        displayDatePrompt();
        tripDate = input.next();
    }

    //MODIFIES: this
    //EFFECTS: makes a hotel to user specifications
    private void makeHotel() {
        displayHotelPrompt();
        displayNamePrompt();
        hotelName = input.next();
        displayPricePrompt();
        hotelPrice = input.nextInt();
        displayDatePrompt();
        hotelDate = input.next();
        displayDurationPrompt();
        hotelDuration = input.nextInt();
        displayLocationPrompt();
        hotelLocation = input.next();
    }

    //MODIFIES: this
    //EFFECTS: makes a flight to user specifications
    private void makeFlight() {
        displayFLightPrompt();
        displayPricePrompt();
        flightPrice = input.nextInt();
        displayDatePrompt();
        flightDate = input.next();
        displayTimePrompt();
        flightTime = input.nextInt();
        displayNamePrompt();
        flightID = input.next();
        displayDestinationPrompt();
        flightDes = input.next();
        displayDeparturePrompt();
        flightDep = input.next();
    }

    //MODIFIES: this
    //EFFECTS: removes a trip from trips
    private void removeTrip(String name) {
        this.trip = trips.getTrip(name);
        trips.removeTrip(this.trip);
        displayMainMenu();
        processListOfTripCommand(input.next());
    }

    //MODIFIES: this
    //EFFECTS: adds a trip to trips
    private void addTrip(String name, String date, String hotelName, int hotelPrice, String hotelDate,
                         int hotelDuration, String hotelLocation, int flightPrice, String flightDate, int flightTime,
                         String flightID, String flightDes, String flightDep) {
        Flight flight = new Flight(flightPrice, flightDate, flightTime, flightID, flightDes, flightDep);
        Hotel hotel = new Hotel(hotelName, hotelPrice, hotelDate, hotelDuration, hotelLocation);
        Trip trip = new Trip(name, date, flight, hotel);
        trips.addTrip(trip);
    }

    //EFFECTS: selects a trip from trips and gives further options for the trip
    private void selectTrip(String name) {
        if (trips.getTrip(name) == null) {
            System.out.println("Not a valid trip");
        } else {
            this.trip = trips.getTrip(name);
            displayTripMenu();
            processTripCommand(input.next());
        }
    }

    //EFFECTS: prints out a list of all trip names
    private void viewTrips() {
        displayViewMenu();
        processView(input.next());
    }

    //EFFECTS: displays menu of view options for user
    private void displayViewMenu() {
        System.out.println("\n Select from:");
        System.out.println("\tall -> view all trips");
        System.out.println("\tjan -> view all trips in january");
        System.out.println("\tfeb -> view all trips in february");
        System.out.println("\tmar -> view all trips in march");
        System.out.println("\tapr -> view all trips in april");
        System.out.println("\tmay -> view all trips in may");
        System.out.println("\tjun -> view all trips in june");
        System.out.println("\tjul -> view all trips in july");
        System.out.println("\taug -> view all trips in august");
        System.out.println("\tsep -> view all trips in september");
        System.out.println("\toct -> view all trips in october");
        System.out.println("\tnov -> view all trips in november");
        System.out.println("\tdec -> view all trips in december");
    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processView(String command) {
        if (command.equals("all")) {
            System.out.println(trips.printAllTrips());
        } else {
            trips.groupTripsByMonth();
            printGroup(command);
            trips.eraseGroups();
        }

    }

    //EFFECTS: prints out list of trips with given month
    private void printGroup(String command) {
        printJanToJun(command);
    }

    //EFFECTS: prints out list of trips with given months january to june
    private void printJanToJun(String command) {
        if (command.equals("jan")) {
            System.out.println(trips.printJanTrips());
        } else if (command.equals("feb")) {
            System.out.println(trips.printFebTrips());
        } else if (command.equals("mar")) {
            System.out.println(trips.printMarTrips());
        } else if (command.equals("apr")) {
            System.out.println(trips.printAprTrips());
        } else if (command.equals("may")) {
            System.out.println(trips.printMayTrips());
        } else if (command.equals("jun")) {
            System.out.println(trips.printJunTrips());
        } else {
            printJulToDec(command);
        }
    }

    //EFFECTS: prints out list of trips with given months july to december
    private void printJulToDec(String command) {
        if (command.equals("jul")) {
            System.out.println(trips.printJulTrips());
        } else if (command.equals("aug")) {
            System.out.println(trips.printAugTrips());
        } else if (command.equals("sep")) {
            System.out.println(trips.printSepTrips());
        } else if (command.equals("oct")) {
            System.out.println(trips.printOctTrips());
        } else if (command.equals("nov")) {
            System.out.println(trips.printNovTrips());
        } else if (command.equals("dec")) {
            System.out.println(trips.printDecTrips());
        }
    }

    // EFFECTS: displays menu of options to user
    private void displayTripMenu() {
        System.out.println("\n Select from:");
        System.out.println("\tv -> view all details");
        System.out.println("\td -> view date");
        System.out.println("\tp -> view price");
        System.out.println("\th -> view hotel");
        System.out.println("\tf -> view flight");
        System.out.println("\tm -> main menu");
    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processTripCommand(String command) {
        if (command.equals("v")) {
            viewTripDetails();
        } else if (command.equals("d")) {
            viewDate();
        } else if (command.equals("p")) {
            viewPrice();
        } else if (command.equals("h")) {
            viewHotel();
        } else if (command.equals("f")) {
            viewFlight();
        } else {
            System.out.println("Selection is not valid");
        }
    }

    //EFFECTS: displays trip price
    private void viewPrice() {
        System.out.println(trip.getTripPrice());
    }

    //EFFECTS: displays trip date
    private void viewDate() {
        System.out.println(trip.getTripDate());
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
        System.out.println("\tm -> main menu");
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


    // EFFECTS: displays menu of options to user
    private void displayFlightMenu() {
        System.out.println("\n Select from:");
        System.out.println("\tv -> view all details");
        System.out.println("\tt -> change time");
        System.out.println("\tp -> change price");
        System.out.println("\ti -> change ID");
        System.out.println("\tda -> change date");
        System.out.println("\tdes -> change destination location");
        System.out.println("\tdep -> change departure location");
        System.out.println("\tm -> main menu");
    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processFlightCommand(String command) {
        if (command.equals("v")) {
            viewFlightDetails();
        } else if (command.equals("t")) {
            displayTimePrompt();
            changeFlightTime(input.nextInt());
        } else if (command.equals("p")) {
            displayPricePrompt();
            changeFlightPrice(input.nextInt());
        } else if (command.equals("i")) {
            displayNamePrompt();
            changeFlightID(input.next());
        } else if (command.equals("d")) {
            displayDatePrompt();
            changeFlightDate(input.next());
        } else if (command.equals("des")) {
            displayDestinationPrompt();
            changeFlightDestination(input.next());
        } else if (command.equals("dep")) {
            displayDeparturePrompt();
            changeFlightDeparture(input.next());
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

    //MODIFIES: this
    //EFFECTS: loads trips from file
    private void loadTrips() {
        try {
            trips = reader.read();
            System.out.println("Loaded " + trips.getTripsName() + " from " + data);
        } catch (IOException e) {
            System.out.println("Unable to read from " + data);
        }
    }

    // EFFECTS: saves trips to file
    private void saveTrips() {
        try {
            writer.open();
            writer.write(trips);
            writer.close();
            System.out.println("Saved " + trips.getTripsName() + " to " + data);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + data);
        }
    }
}
