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
    private JButton add;
    private JButton remove;
    private JButton load;
    private JButton save;
    private JButton submit;
    private JTextField textBox;


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
    private void addListOfTrips() { //TODO: make it so that list with multiple is not ugly
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

    private void addTextBox() { //TODO: allow user to type in GUI
        submit = new JButton("Submit");
        submit.addActionListener(this);

        textBox = new JTextField();
        textBox.setPreferredSize(new Dimension((WIDTH - 150), 100));
        textBox.setFont(new Font("Title", 20, 15));


        textPanel.add(submit);
        textPanel.add(textBox);
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
    private void updateAdd() {
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


    //MODIFIES: ListOfTripsApp
    //EFFECTS: alters list of trips by calling correct trip action command
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            app.processListOfTripCommand("a");
            createTrip(e);
            addListOfTrips();
        }
        if (e.getSource() == remove) {
            app.processListOfTripCommand("r");
            textBox.setText("Enter trip name to remove: ");
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

    private void createTrip(ActionEvent e) {
        textBox.setText("Enter trip name: ");
        if (e.getSource() == submit) {
            app.tripName = textBox.getText();
        }
        textBox.setText("Enter trip date: ");
        if (e.getSource() == submit) {
            app.tripDate = textBox.getText();
        }
        createHotel(e);
        createFlight(e);
    }

    private void createFlight(ActionEvent e) {
        textBox.setText("Enter flight price: ");
        if (e.getSource() == submit) {
            app.flightPrice = Integer.parseInt(textBox.getText());
        }
        textBox.setText("Enter flight date: ");
        if (e.getSource() == submit) {
            app.flightDate = textBox.getText();
        }
        textBox.setText("Enter flight time: ");
        if (e.getSource() == submit) {
            app.flightTime = Integer.parseInt(textBox.getText());
        }
        textBox.setText("Enter flight name: ");
        if (e.getSource() == submit) {
            app.flightName = textBox.getText();
        }
        textBox.setText("Enter flight location: ");
        if (e.getSource() == submit) {
            app.flightLocation = textBox.getText();
        }
    }

    private void createHotel(ActionEvent e) {
        textBox.setText("Enter hotel name: ");
        if (e.getSource() == submit) {
            app.hotelName = textBox.getText();
        }
        textBox.setText("Enter hotel price: ");
        if (e.getSource() == submit) {
            app.hotelPrice = Integer.parseInt(textBox.getText());
        }
        textBox.setText("Enter hotel date: ");
        if (e.getSource() == submit) {
            app.hotelDate = textBox.getText();
        }
        textBox.setText("Enter hotel location: ");
        if (e.getSource() == submit) {
            app.hotelLocation = textBox.getText();
        }
    }
}
