package ui;

import javax.swing.*;
import java.awt.*;

public class SplashScreen {
    private ImageIcon plane = new ImageIcon("data/plane.png");
    private JLabel graphics = new JLabel();
    private JFrame frame = new JFrame();

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

    private void createImage() {
        graphics.setText("Loading...");
        graphics.setIcon(plane);
        graphics.setVerticalTextPosition(JLabel.TOP);
        graphics.setHorizontalTextPosition(JLabel.CENTER);
        graphics.setForeground(Color.BLACK);
        graphics.setFont(new Font("Title", 20, 30));
        graphics.setIconTextGap(30);
        graphics.setBackground(new Color(243, 243, 243));
        graphics.setOpaque(true);
        graphics.setVerticalAlignment(JLabel.CENTER);
        graphics.setHorizontalAlignment(JLabel.CENTER);
    }
}
