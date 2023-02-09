package ui;

import java.util.Scanner;

public class ListOfTripApp {
    private Scanner input;

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
    private void processListOfTripCommand(String command) {
        if (command.equals("v")) {
            veiwAllTrips();
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
            veiwTripDetails();
        } else if (command.equals("h")) {
            veiwHotel();
        } else if (command.equals("f")) {
            viewFlight();
        } else if (command.equals("a")) {
            viewActivities();
        } else {
            System.out.println("Selection is not valid");
        }
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
    private void processHotelCommand(String command) {
        if (command.equals("v")) {
            veiwHotelDetails();
        } else if (command.equals("a")) {
            changeAllHotel();
        } else if (command.equals("du")) {
            changeHotelDuration();
        } else if (command.equals("p")) {
            changeHotelPrice();
        } else if (command.equals("n")) {
            changeHotelName();
        } else if (command.equals("da")) {
            changeHotelDate();
        } else if (command.equals("l")) {
            changeHotelLocation();
        } else {
            System.out.println("Selection is not valid");
        }
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






}
