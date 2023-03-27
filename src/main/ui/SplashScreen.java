package ui;

import javax.swing.*;
import java.awt.*;

// represents the loading splash screen that displays before the main application is run

public class SplashScreen {
    private ImageIcon plane = new ImageIcon("data/plane.png");
    private JLabel graphics = new JLabel();
    private JFrame frame = new JFrame();

    // MODIFIES: this
    // EFFECTS: creates the splash screen to be run
    public SplashScreen() {
        createImage();

        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.add(graphics);
        frame.setVisible(true);

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        frame.setVisible(false);


    }

    // MODIFIES: this
    // EFFECTS: creates the image that will be displayed on the splash screen
    private void createImage() {
        graphics.setIcon(plane);
        graphics.setIconTextGap(30);
        graphics.setBackground(new Color(243, 243, 243));
        graphics.setOpaque(true);
        graphics.setVerticalAlignment(JLabel.CENTER);
        graphics.setHorizontalAlignment(JLabel.CENTER);
    }
}
