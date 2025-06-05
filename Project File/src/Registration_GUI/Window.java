package Registration_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Window extends JFrame implements ActionListener {

    // Window dimensions and position constants
    private static final int WINDOW_WIDTH = 930;
    private static final int WINDOW_HEIGHT = 650;
    private static final int WINDOW_X_ORIGIN = 310;
    private static final int WINDOW_Y_ORIGIN = 110;

    public Window() {
        //set the basic Window (frame) properties
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_X_ORIGIN, WINDOW_Y_ORIGIN);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //register 'Exit upon closing' as a default close operation

        //Get content pane and set layout
        Container contentPane = getContentPane();
        contentPane.setBackground(bgColor);
        contentPane.setLayout(null); // Using absolute positioning

        // Main title label
        JLabel cTitle = new JLabel("Registration Form");
        cTitle.setFont(new Font("Arial", Font.BOLD, 28));
        cTitle.setBounds(340, 20, 250, 50); // setBounds(x, y, width, height)
        contentPane.add(cTitle);
}
