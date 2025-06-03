package Registration_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener {
    private static final int WINDOW_WIDTH = 930;
    private static final int WINDOW_HEIGHT = 650;
    private static final int WINDOW_X_ORIGIN = 240;
    private static final int WINDOW_Y_ORIGIN = 40;

    private String cTitle = "";
    private final JLabel enteredTitle;

    public Window() {
        //set the Window (frame) properties
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_X_ORIGIN, WINDOW_Y_ORIGIN);
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //register 'Exit upon closing' as a default close operation

        //set the layout manager
        Container contentPane = getContentPane();
        contentPane.setBackground(new Color(224, 224, 224));
        contentPane.setLayout(null);

        enteredTitle = new JLabel(cTitle);
        enteredTitle.setFont(new Font("Arial", Font.BOLD, 28));
        enteredTitle.setSize(250, 50);
        enteredTitle.setLocation(340, 20);
        contentPane.add(enteredTitle);
    }

    public void set_cTitle(String cTitle) {
        this.cTitle = cTitle;
        if (enteredTitle != null) {
            enteredTitle.setText(cTitle);
        }
    }


    @Override
    public void actionPerformed(ActionEvent event) {

    }
}
