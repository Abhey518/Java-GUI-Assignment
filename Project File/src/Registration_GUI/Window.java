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
    private static final int WINDOW_Y_ORIGIN = 110;

    // Font and color constants for consistent styling
    Font labelFont = new Font("Arial", Font.PLAIN, 20);
    Font fieldFont = new Font("Arial", Font.PLAIN, 15);
    Color bgColor = new Color(224, 224, 224);

    // Form components that need to be accessed in multiple methods
    private final JTextField nameTextField;
    private final JTextField mobileTextField;
    private final JRadioButton male;
    JRadioButton female;
    private final JComboBox<String> yearCombo;
    private final JComboBox<String> monthCombo;
    private final JComboBox<String> dayCombo;
    private final JTextArea addressTextArea;
    private final JCheckBox checkBox;
    private final JLabel messageText;
    private final JPanel userInfo;
    JButton submitButton;
    JButton resetButton;

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

        // ----- User Information Display Panel -----
        userInfo = new JPanel();
        userInfo.setBackground(Color.white);
        userInfo.setBounds(530, 100, 300, 440); // setBounds(x, y, width, height)
        userInfo.setLayout(new BoxLayout(userInfo, BoxLayout.Y_AXIS)); // Vertical layout
        contentPane.add(userInfo);

        // ----- Name Section ----- : Label for Name
        Label nameLabel = new Label("Name");
        nameLabel.setFont(labelFont);
        nameLabel.setBounds(100, 100, 55, 20); // setBounds(x, y, width, height)
        contentPane.add(nameLabel);

        // ----- Name Section ----- : Text Field for Name (Input)
        nameTextField = new JTextField();
        nameTextField.setFont(fieldFont);
        nameTextField.setBounds(200, 100, 200, 20); // setBounds(x, y, width, height)
        contentPane.add(nameTextField);

        // ----- Mobile Section ----- : Label for Mobile
        JLabel labelMobile = new JLabel("Mobile");
        labelMobile.setFont(labelFont);
        labelMobile.setBounds(100, 155, 60, 20); // setBounds(x, y, width, height)
        contentPane.add(labelMobile);

        // ----- Mobile Section ----- : Text Field for Mobile (Input)
        mobileTextField = new JTextField();
        mobileTextField.setFont(fieldFont);
        mobileTextField.setBounds(200, 155, 150, 20); // setBounds(x, y, width, height)
        contentPane.add(mobileTextField);

        // ----- Gender Section ----- : Label for Gender
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(labelFont);
        genderLabel.setBounds(100, 210, 70, 20); // setBounds(x, y, width, height)
        contentPane.add(genderLabel);

        // ----- Gender Section ----- : Radio Button for Gender (Male)
        male = new JRadioButton("Male");
        male.setFont(fieldFont);
        male.setBackground(bgColor);
        male.setSelected(true);
        male.setBounds(200, 210, 80, 20); // setBounds(x, y, width, height)
        contentPane.add(male);

        // ----- Gender Section ----- : Radio Button for Gender (Female)
        female = new JRadioButton("Female");
        female.setFont(fieldFont);
        female.setBackground(bgColor);
        female.setBounds(300, 210, 80, 20); // setBounds(x, y, width, height)
        contentPane.add(female);

        // ----- Gender Section ----- : Group radio buttons so only one can be selected
        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);

        // ----- Date of Birth Section ----- : Label for DOB
        JLabel labelDOB = new JLabel("DOB");
        labelDOB.setFont(labelFont);
        labelDOB.setBounds(100, 265, 50, 20); // setBounds(x, y, width, height)
        contentPane.add(labelDOB);

        // ----- Date of Birth Section ----- : Day selection combo box
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1); // "1" to "30"
        }

        dayCombo = new JComboBox<>(days);
        dayCombo.setBounds(200, 265, 45, 20); // setBounds(x, y, width, height)
        dayCombo.setFont(fieldFont);
        contentPane.add(dayCombo);

        // ----- Date of Birth Section ----- : Month selection combo box
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        monthCombo = new JComboBox<>(months);
        monthCombo.setBounds(246, 265, 55, 20); // setBounds(x, y, width, height)
        monthCombo.setFont(fieldFont);
        contentPane.add(monthCombo);

        // ----- Date of Birth Section ----- : Year selection combo box
        String[] years = new String[26];
        for (int j = 0; j <= 25; j++) {
            years[j] = String.valueOf(1995 + j); // "1995" to "2020"
        }

        yearCombo = new JComboBox<>(years);
        yearCombo.setBounds(320, 265, 60, 20); // setBounds(x, y, width, height)
        yearCombo.setFont(fieldFont);
        contentPane.add(yearCombo);

        // ----- Address Section ----- : Label for Address
        JLabel labelAddress = new JLabel("Address");
        labelAddress.setFont(labelFont);
        labelAddress.setBounds(100, 320, 80, 20); // setBounds(x, y, width, height)
        contentPane.add(labelAddress);

        // ----- Address Section ----- : Text Area for Address (Input)
        addressTextArea = new JTextArea();
        addressTextArea.setFont(fieldFont);
        addressTextArea.setBounds(200, 320, 200, 75); // setBounds(x, y, width, height)
        addressTextArea.setLineWrap(true);
        contentPane.add(addressTextArea);

        // ----- Terms and Conditions -----
        checkBox = new JCheckBox("Accept Terms And Conditions.");
        checkBox.setFont(fieldFont);
        checkBox.setBackground(bgColor);
        checkBox.setBounds(155, 425, 235, 20); // setBounds(x, y, width, height)
        contentPane.add(checkBox);

        // ----- Action Buttons ----- : Submit Button
        submitButton = new JButton("Submit");
        submitButton.setFont(fieldFont);
        submitButton.setBounds(160, 480, 100, 20); // setBounds(x, y, width, height)
        contentPane.add(submitButton);

        // ----- Action Buttons ----- : Submit Button
        resetButton = new JButton("Reset");
        resetButton.setFont(fieldFont);
        resetButton.setBounds(295, 480, 100, 20); // setBounds(x, y, width, height)
        contentPane.add(resetButton);

        // ----- Status Message Label -----
        messageText = new JLabel("");
        messageText.setFont(labelFont);
        messageText.setBounds(120, 535, 400, 22); // setBounds(x, y, width, height)
        messageText.setVisible(false);
        contentPane.add(messageText);

        setVisible(true);

        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    private boolean validateDOB() {
        int day = Integer.parseInt(Objects.requireNonNull(dayCombo.getSelectedItem()).toString());
        String month = Objects.requireNonNull(monthCombo.getSelectedItem()).toString();
        int year = Integer.parseInt(Objects.requireNonNull(yearCombo.getSelectedItem()).toString());

        // Validate days based on month
        if (month.equals("Feb")) {
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (day > (isLeapYear ? 29 : 28)) {
                showErrorMessage("Invalid date for " + month + " " + year);
                return false;
            }
        } else if (month.equals("Apr") || month.equals("Jun") || month.equals("Sep") || month.equals("Nov")) {
            if (day > 30) {
                showErrorMessage("Invalid date for " + month + " (max 30 days)");
                return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // Determine which button was clicked
        String command = event.getActionCommand();

        if (command.equals("Submit")) {
            handleSubmit();
        } else if (command.equals("Reset")) {
            handleReset();
        }
    }

     // Handles the submit button click event
     // Validates input and displays data in the info panel
    private void handleSubmit() {
        // Clear previous messages
        messageText.setText("");
        messageText.setVisible(false);

        // Get all input values
        String name = nameTextField.getText().trim();
        String mobile = mobileTextField.getText().trim();
        String gender = male.isSelected() ? "Male" : "Female";
        String dob = dayCombo.getSelectedItem() + "/" +
                monthCombo.getSelectedItem() + "/" +
                yearCombo.getSelectedItem();
        String address = addressTextArea.getText().trim();

        // Validate required fields
        if (name.isEmpty() || mobile.isEmpty() || address.isEmpty()) {
            showErrorMessage("Please fill all required fields..");
            return;
        }

        // Validate mobile number format (10 digits)
        if (!mobile.matches("\\d{10}")) {
            showErrorMessage("Enter a valid 10-digit mobile number..");
            return;
        }

        // Validate date of birth
        if (!validateDOB()) {
            return;
        }

        // Check if terms are accepted
        if (!checkBox.isSelected()) {
            showErrorMessage("Please accept the terms & conditions..");
            return;
        }

        // Clear previous user info
        userInfo.removeAll();

        // Display all entered information in the panel
        addInfoToPanel("Name: " + name);
        addInfoToPanel("Mobile: " + mobile);
        addInfoToPanel("Gender: " + gender);
        addInfoToPanel("Date of Birth: " + dob);
        addInfoToPanel("Address: " + address);

        // Update the panel
        userInfo.revalidate();
        userInfo.repaint();

        // Show success message
        messageText.setText("Registration Successful!..");
        messageText.setVisible(true);
    }

     // Handles the reset button click event
     // Resets all fields to their default values
    private void handleReset() {
        // Clear all input fields
        nameTextField.setText("");
        mobileTextField.setText("");
        male.setSelected(true);
        yearCombo.setSelectedIndex(0);
        monthCombo.setSelectedIndex(0);
        dayCombo.setSelectedIndex(0);
        addressTextArea.setText("");
        checkBox.setSelected(false);

        // Clear user info panel
        userInfo.removeAll();
        userInfo.revalidate();
        userInfo.repaint();

        // Hide any message
        messageText.setText("");
        messageText.setVisible(false);
    }

     // Adds a label with information to the user info panel
     // @param text The text to display in the panel
    private void addInfoToPanel(String text) {
            JLabel label = new JLabel(text);
            label.setFont(fieldFont);
            label.setAlignmentX(Component.LEFT_ALIGNMENT);

        if (text.startsWith("Address: ")) {
            String addressContent = text.substring("Address: ".length());
            // Replace commas with HTML line breaks for proper display
            String formattedAddress = "<html>Address: " + addressContent.replace(",", ",<br>") + "</html>";
            label.setText(formattedAddress);
        }

        userInfo.add(label);
    }

    // Displays an error message below the buttons
    // @param message The error message to display
    private void showErrorMessage(String message) {
        messageText.setText(message);
        messageText.setVisible(true);
    }
}
