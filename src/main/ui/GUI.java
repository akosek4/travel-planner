package ui;

import model.Trip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 900;
    private ListOfTripApp app;
    private JDesktopPane desktop;

    public GUI() {

        desktop = new JDesktopPane();

        setContentPane(desktop);
        setTitle("List Of Trips");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        addMenu();
        setVisible(true);

        app = new ListOfTripApp();
        addTripsDisplay();

    }

    private void addTripsDisplay() {
        TripsUi tripsUi = new TripsUi();
        //desktop.add(tripsUi);
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
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    }

    private class AddTripAction extends AbstractAction {
        AddTripAction() {
            super("Add trip");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            app.processListOfTripCommand("a");
        }
    }

    private class RemoveTripAction extends AbstractAction {
        RemoveTripAction() {
            super("Remove trip");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            app.processListOfTripCommand("r");
        }
    }

    private class LoadTripsAction extends AbstractAction {
        LoadTripsAction() {
            super("Load trips");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            app.processListOfTripCommand("l");
        }
    }

    private class SaveTripsAction extends AbstractAction {
        SaveTripsAction() {
            super("Save trips");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            app.processListOfTripCommand("save");
        }
    }
}
