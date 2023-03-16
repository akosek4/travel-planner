package ui;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 900;
    private ListOfTripApp app;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;

    public GUI() {
        app = new ListOfTripApp();

        desktop = new JDesktopPane();
        controlPanel = new JInternalFrame("Control Panel", false, false, false, false);
        controlPanel.setLayout(new BorderLayout());

        setContentPane(desktop);
        setTitle("List Of Trips");
        setSize(WIDTH, HEIGHT);

        addMenu();
        addTripsDisplay();

        controlPanel.pack();
        controlPanel.setVisible(true);
        desktop.add(controlPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);

    }

    private void addTripsDisplay() {
        TripsUi tripsUi = new TripsUi();
        controlPanel.add(tripsUi, BorderLayout.NORTH);
    }

    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu mainMenu = new JMenu("Main");
        mainMenu.setMnemonic('M');
        addMenuItem(mainMenu, new AddTripAction(),
                KeyStroke.getKeyStroke("control A"));
        addMenuItem(mainMenu, new RemoveTripAction(),
                KeyStroke.getKeyStroke("control R"));
        addMenuItem(mainMenu, new LoadTripsAction(),
                KeyStroke.getKeyStroke("control L"));
        addMenuItem(mainMenu, new SaveTripsAction(),
                KeyStroke.getKeyStroke("control S"));
        menuBar.add(mainMenu);

        setJMenuBar(menuBar);
    }

    private void addMenuItem(JMenu theMenu, AbstractAction action, KeyStroke accelerator) {
        JMenuItem menuItem = new JMenuItem(action);
        menuItem.setMnemonic(menuItem.getText().charAt(0));
        menuItem.setAccelerator(accelerator);
        theMenu.add(menuItem);
    }

    private void centreOnScreen() {
    }

    private class AddTripAction {
    }

    private class RemoveTripAction {
    }

    private class LoadTripsAction {
    }

    private class SaveTripsAction {
    }
}
