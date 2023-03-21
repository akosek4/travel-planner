package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TripsUi extends JFrame implements ActionListener {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 900;
    private ListOfTripApp app;
    private JLabel title;
    private JPanel menuPanel;
    private JPanel listPanel;
    private JPanel titlePanel;
    private JButton add;
    private JButton remove;
    private JButton load;
    private JButton save;
    

    public TripsUi() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);

        createTitle();

        app = new ListOfTripApp(); //TODO: make it so that you don't need to quit before use

        titlePanel = new JPanel();
        titlePanel.setBackground(Color.pink);
        titlePanel.setPreferredSize(new Dimension(WIDTH, 100));
        titlePanel.add(title);

        listPanel = new JPanel();
        listPanel.setBackground(Color.white);
        listPanel.setPreferredSize(new Dimension(WIDTH, 800));
        addListOfTrips();

        menuPanel = new JPanel();
        menuPanel.setBackground(Color.gray);
        menuPanel.setPreferredSize(new Dimension(150, 50));
        addButtons();
        addTextBox();

        this.add(menuPanel, BorderLayout.WEST);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(listPanel, BorderLayout.CENTER);
    }

    private void createTitle() {
        title = new JLabel();
        title.setText(app.trips.getTripsName());
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setFont(new Font("Title", 20, 60));
    }

    private void addListOfTrips() { //TODO: make it so that list is visible
    }

    private void addTextBox() { //TODO: allow user to type in GUI
    }


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

    private void updateAdd() {
        add = new JButton();
        add.setBounds(0, 0, 20, 20);
        add.setText("Add Trip");
        add.addActionListener(this);
    }

    private void updateRemove() {
        remove = new JButton();
        remove.setBounds(0, 40, 20, 20);
        remove.setText("Remove Trip");
        remove.addActionListener(this);
    }

    private void updateSave() {
        save = new JButton();
        save.setBounds(0, 80, 20, 20);
        save.setText("Save Trips");
        save.addActionListener(this);
    }

    private void updateLoad() {
        load = new JButton();
        load.setBounds(0, 120, 20, 20);
        load.setText("Load Trips");
        load.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            app.processListOfTripCommand("a");
        }
        if (e.getSource() == remove) {
            app.processListOfTripCommand("r");
        }
        if (e.getSource() == save) {
            app.processListOfTripCommand("save");
        }
        if (e.getSource() == load) {
            app.processListOfTripCommand("l");
        }
    }
}
