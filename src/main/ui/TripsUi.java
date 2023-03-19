package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TripsUi extends JFrame {
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

        this.add(menuPanel, BorderLayout.WEST);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(listPanel, BorderLayout.CENTER);
    }

    private void createTitle() {
        title = new JLabel();
        title.setText("List of Trips"); //TODO: make it so that its the lists name
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setFont(new Font("Title", 20, 60));
    }

    private void addListOfTrips() { //TODO: make it so that list is visible
    }

    private void addButtons() {
        updateAdd(); //TODO: make it so that they do the intended action
        updateRemove();
        updateSave();
        updateLoad();
        menuPanel.add(add, KeyStroke.getKeyStroke("control A"));
        menuPanel.add(remove, KeyStroke.getKeyStroke("control A"));
        menuPanel.add(save, KeyStroke.getKeyStroke("control A"));
        menuPanel.add(load, KeyStroke.getKeyStroke("control A"));
    }

    private void updateAdd() {
        add = new JButton();
        add.setBounds(0, 0, 20, 20);
        add.setText("Add Trip");
    }

    private void updateRemove() {
        remove = new JButton();
        remove.setBounds(0, 40, 20, 20);
        remove.setText("Remove Trip");
    }

    private void updateSave() {
        save = new JButton();
        save.setBounds(0, 80, 20, 20);
        save.setText("Save Trips");
    }

    private void updateLoad() {
        load = new JButton();
        load.setBounds(0, 120, 20, 20);
        load.setText("Load Trips");
    }


}
