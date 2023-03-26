package ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// represents a list of trips graphical interface

public class TripsUi extends JFrame implements ActionListener {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 900;
    private GUIhelper app;
    private JLabel title;
    private JPanel menuPanel;
    private JPanel listPanel;
    private JPanel titlePanel;
    private JPanel textPanel;
    private JTextField tripNameBox;
    private JTextField tripDateBox;
    private JTextField tripLocationBox;
    private JTextField hotelPriceBox;
    private JTextField hotelNameBox;
    private JTextField flightNameBox;
    private JTextField flightPriceBox;
    private JTextField flightTimeBox;
    private JButton add;
    private JButton remove;
    private JButton load;
    private JButton save;


    //MODIFIES: this and ListOfTripApp
    //EFFECTS: creates a new interface, with a splash screen, title, menu and list of trips
    public TripsUi() {
        new SplashScreen();

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);

        app = new GUIhelper();


        createTitle();

        createTitlePanel();

        createListPanel();

        createTextPanel();
        addTextBox();

        createMenuPanel();
        addButtons();

        this.add(menuPanel, BorderLayout.WEST);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(listPanel, BorderLayout.CENTER);
        this.add(textPanel, BorderLayout.SOUTH);
        addListOfTrips();
    }

    //MODIFIES: this
    //EFFECTS: creates a new menu panel where the options to save, load and alter trips exists
    private void createMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(Color.gray);
        menuPanel.setPreferredSize(new Dimension(150, 50));
    }

    //MODIFIES: this
    //EFFECTS: creates a new text box panel where the user can type in their response
    private void createTextPanel() {
        textPanel = new JPanel();
        textPanel.setBackground(Color.lightGray);
        textPanel.setPreferredSize(new Dimension(WIDTH, 150));
    }

    //MODIFIES: this
    //EFFECTS: creates a new list panel where the image of added trips exists
    private void createListPanel() {
        listPanel = new JPanel();
        listPanel.setBackground(Color.white);
        listPanel.setPreferredSize(new Dimension(WIDTH, 800));
        listPanel.setLayout(new GridLayout(app.getAllTripsInfoForGUI().size(), 1, 0, 10));
    }

    //MODIFIES: this
    //EFFECTS: creates a new title panel that displays the current trips name
    private void createTitlePanel() {
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.pink);
        titlePanel.setPreferredSize(new Dimension(WIDTH, 100));
        titlePanel.add(title);
    }

    //MODIFIES: this
    //EFFECTS: creates a new title to be added to the title panel
    private void createTitle() {
        title = new JLabel();

        title.setText("List Of Trips");
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setFont(new Font("Title", 20, 60));
    }

    //MODIFIES: this
    //EFFECTS: adds the info (date,name, and price) of all trips in list to ListPanel
    private void addListOfTrips() {
        clearPreviousList();
        List<String> info;
        info = app.getAllTripsInfoForGUI();
        for (String s : info) {
            addTripInfo(s);
        }

    }

    //MODIFIES: this
    //EFFECTS: clears listPanel of all current trip information
    private void clearPreviousList() {
        listPanel.removeAll();
    }

    //MODIFIES: this
    //EFFECTS: adds the info (date,name, and price) of a given trip to ListPanel
    private void addTripInfo(String s) {
        JLabel text = new JLabel();
        text.setText(s);
        text.setHorizontalAlignment(JLabel.LEFT);
        text.setVerticalAlignment(JLabel.TOP);
        text.setFont(new Font("Title", 20, 15));
        listPanel.add(text);
    }

    //MODIFIES: this
    //EFFECTS: adds text fields for user to input trip information to add or remove
    private void addTextBox() {
        addTripName();
        addTripDate();
        addTripLocation();
        addHotelName();
        addHotelPrice();
        addFlightName();
        addFlightPrice();
        addFlightTime();
    }

    //MODIFIES: this
    //EFFECTS: adds a text field for user to input flight times
    private void addFlightTime() {
        flightTimeBox = new JTextField();
        flightTimeBox.setPreferredSize(new Dimension((200), 50));
        flightTimeBox.setFont(new Font("Title", 20, 15));
        flightTimeBox.setText("Enter Flight Time");

        textPanel.add(flightTimeBox);
    }

    //MODIFIES: this
    //EFFECTS: adds text fields for user to input flight prices
    private void addFlightPrice() {

        flightPriceBox = new JTextField();
        flightPriceBox.setPreferredSize(new Dimension((200), 50));
        flightPriceBox.setFont(new Font("Title", 20, 15));
        flightPriceBox.setText("Enter Flight Price");

        textPanel.add(flightPriceBox);
    }

    //MODIFIES: this
    //EFFECTS: adds text fields for user to input flight names
    private void addFlightName() {

        flightNameBox = new JTextField();
        flightNameBox.setPreferredSize(new Dimension((200), 50));
        flightNameBox.setFont(new Font("Title", 20, 15));
        flightNameBox.setText("Enter Flight Name");

        textPanel.add(flightNameBox);
    }

    //MODIFIES: this
    //EFFECTS: adds text fields for user to input hotel prices
    private void addHotelPrice() {
        hotelPriceBox = new JTextField();
        hotelPriceBox.setPreferredSize(new Dimension((200), 50));
        hotelPriceBox.setFont(new Font("Title", 20, 15));
        hotelPriceBox.setText("Enter Hotel Price");

        textPanel.add(hotelPriceBox);
    }

    //MODIFIES: this
    //EFFECTS: adds text fields for user to input hotel names
    private void addHotelName() {
        hotelNameBox = new JTextField();
        hotelNameBox.setPreferredSize(new Dimension((200), 50));
        hotelNameBox.setFont(new Font("Title", 20, 15));
        hotelNameBox.setText("Enter Hotel Name");

        textPanel.add(hotelNameBox);
    }

    //MODIFIES: this
    //EFFECTS: adds text fields for user to input trip locations
    private void addTripLocation() {
        tripLocationBox = new JTextField();
        tripLocationBox.setPreferredSize(new Dimension((200), 50));
        tripLocationBox.setFont(new Font("Title", 20, 15));
        tripLocationBox.setText("Enter Trip Location");

        textPanel.add(tripLocationBox);
    }

    //MODIFIES: this
    //EFFECTS: adds text fields for user to input trip dates
    private void addTripDate() {
        tripDateBox = new JTextField();
        tripDateBox.setPreferredSize(new Dimension((200), 50));
        tripDateBox.setFont(new Font("Title", 20, 15));
        tripDateBox.setText("Enter Trip Date");

        textPanel.add(tripDateBox);
    }

    //MODIFIES: this
    //EFFECTS: adds text fields for user to input trip names
    private void addTripName() {

        tripNameBox = new JTextField();
        tripNameBox.setPreferredSize(new Dimension((200), 50));
        tripNameBox.setFont(new Font("Title", 20, 15));
        tripNameBox.setText("Enter Trip Name");

        textPanel.add(tripNameBox);
    }


    //MODIFIES: this
    //EFFECTS: adds trip altering buttons to menu panel
    private void addButtons() {
        updateAdd();
        updateRemove();
        updateSave();
        updateLoad();
        menuPanel.add(add, KeyStroke.getKeyStroke("control A"));
        menuPanel.add(remove, KeyStroke.getKeyStroke("control R"));
        menuPanel.add(save, KeyStroke.getKeyStroke("control S"));
        menuPanel.add(load, KeyStroke.getKeyStroke("control L"));
    }

    //MODIFIES: this
    //EFFECTS: creates a button that adds a trip to the list
    private void updateAdd() {  //TODO: reset textboxes once completed
        add = new JButton();
        add.setBounds(0, 0, 20, 20);
        add.setText("Add Trip");
        add.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: creates a button that removes a trip from the list
    private void updateRemove() {
        remove = new JButton();
        remove.setBounds(0, 40, 20, 20);
        remove.setText("Remove Trip");
        remove.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: creates a button that saves the current trips
    private void updateSave() {
        save = new JButton();
        save.setBounds(0, 80, 20, 20);
        save.setText("Save Trips");
        save.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: creates a button that loads the previously saved trips
    private void updateLoad() {
        load = new JButton();
        load.setBounds(0, 120, 20, 20);
        load.setText("Load Trips");
        load.addActionListener(this);
    }


    //MODIFIES: GUIhelper
    //EFFECTS: alters list of trips by calling correct trip action command
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            //TODO: create popup to ensure trip info has been entered
            createTrip();
            app.processListOfTripCommand("a");
            addListOfTrips();
        }
        if (e.getSource() == remove) {
            //TODO: create popup to ensure trip name has been entered
            app.processListOfTripCommand("r");
            addListOfTrips();
        }
        if (e.getSource() == save) {
            app.processListOfTripCommand("save");
        }
        if (e.getSource() == load) {
            app.processListOfTripCommand("l");
            addListOfTrips();
        }
    }

    //MODIFIES: this and GUIhelper
    //EFFECTS: creates a trip based off of given trip info
    private void createTrip() {
        app.setTripName(tripNameBox.getText());
        app.setTripDate(tripDateBox.getText());
        app.setTripLocation(tripLocationBox.getText());
        createHotel();
        createFlight();
    }

    //MODIFIES: this and GUIhelper
    //EFFECTS: creates a trip based off of given flight info
    private void createFlight() {
        app.setFlightPrice(Integer.parseInt(flightPriceBox.getText()));
        app.setFlightTime(Integer.parseInt(flightTimeBox.getText()));
        app.setFlightName(flightNameBox.getText());
    }

    //MODIFIES: this and GUIhelper
    //EFFECTS: creates a trip based off of given hotel info
    private void createHotel() {
        app.setHotelName(hotelNameBox.getText());
        app.setHotelPrice(Integer.parseInt(hotelPriceBox.getText()));
    }
}
