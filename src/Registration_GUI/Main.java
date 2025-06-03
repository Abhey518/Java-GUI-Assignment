package Registration_GUI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Font labelFont = new Font("Arial", Font.PLAIN, 20);
        Font fieldFont = new Font("Arial", Font.PLAIN, 15);

        Window regWindow = new Window();
        regWindow.setTitle("User Registration");


        String title = "Registration Form";
        regWindow.set_cTitle(title);

        // panel for showing user details that user has input
        JPanel userInfo = new JPanel();
        userInfo.setBackground(Color.white);
        userInfo.setBounds(530, 100, 300, 440); // setBounds(x, y, width, height)
        userInfo.setLayout(new BoxLayout(userInfo, BoxLayout.Y_AXIS));
        regWindow.add(userInfo);


        // label for name to show it in the window
        Label nameLabel = new Label("Name");
        nameLabel.setFont(labelFont);
        nameLabel.setBounds(100, 100, 55, 20); // setBounds(x, y, width, height)
        regWindow.add(nameLabel);

        // Text Field for input the name
        JTextField nameTextField = new JTextField();
        nameTextField.setFont(fieldFont);
        nameTextField.setBounds(200, 100, 200, 20); // setBounds(x, y, width, height)
        regWindow.add(nameTextField);

        JLabel labelMobile = new JLabel("Mobile");
        labelMobile.setFont(labelFont);
        labelMobile.setBounds(100, 155, 60, 20); // setBounds(x, y, width, height)
        regWindow.add(labelMobile);

        JTextField mobileTextField = new JTextField();
        mobileTextField.setFont(fieldFont);
        mobileTextField.setBounds(200, 155, 150, 20); // setBounds(x, y, width, height)
        regWindow.add(mobileTextField);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(labelFont);
        genderLabel.setBounds(100, 210, 70, 20); // setBounds(x, y, width, height)
        regWindow.add(genderLabel);

        JRadioButton male = new JRadioButton("Male");
        male.setFont(fieldFont);
        male.setBackground(new Color(224, 224, 224));
        male.setSelected(true);
        male.setBounds(200, 210, 80, 20); // setBounds(x, y, width, height)
        regWindow.add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setFont(fieldFont);
        female.setBackground(new Color(224, 224, 224));
        female.setBounds(300, 210, 80, 20); // setBounds(x, y, width, height)
        regWindow.add(female);

        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);

        JLabel labelDOB = new JLabel("DOB");
        labelDOB.setFont(labelFont);
        labelDOB.setBounds(100, 265, 50, 20); // setBounds(x, y, width, height)
        regWindow.add(labelDOB);

        // ComboBox for choose the year of DOB
        String[] years = new String[26];
        for (int j = 0; j <= 25; j++) {
            years[j] = String.valueOf(1995 + j); // "1995" to "2020"
        }

        JComboBox<String> yearCombo = new JComboBox<>(years);
        yearCombo.setBounds(200, 265, 60, 20); // setBounds(x, y, width, height)
        yearCombo.setFont(fieldFont);
        regWindow.add(yearCombo);

        // ComboBox for choose the month of DOB
        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        JComboBox<String> monthCombo = new JComboBox<>(months);
        monthCombo.setBounds(270, 265, 55, 20); // setBounds(x, y, width, height)
        monthCombo.setFont(fieldFont);
        regWindow.add(monthCombo);

        // ComboBox for choose the day of DOB
        String[] days = new String[30];
        for (int i = 0; i < 30; i++) {
            days[i] = String.valueOf(i + 1); // "1" to "30"
        }

        JComboBox<String> dayCombo = new JComboBox<>(days);
        dayCombo.setBounds(330, 265, 45, 20); // setBounds(x, y, width, height)
        dayCombo.setFont(fieldFont);
        //dayCombo.setBackground(new Color(224, 224, 224));
        regWindow.add(dayCombo);

        JLabel labelAddress = new JLabel("Address");
        labelAddress.setFont(labelFont);
        labelAddress.setBounds(100, 320, 80, 20); // setBounds(x, y, width, height)
        regWindow.add(labelAddress);

        // TExtArea for the address input
        JTextArea addressTextArea = new JTextArea();
        addressTextArea.setFont(fieldFont);
        addressTextArea.setBounds(200, 320, 200, 75); // setBounds(x, y, width, height)
        addressTextArea.setLineWrap(true);
        regWindow.add(addressTextArea);

        JCheckBox checkBox = new JCheckBox("Accept Terms And Conditions.");
        checkBox.setFont(fieldFont);
        checkBox.setBackground(new Color(224, 224, 224));
        checkBox.setBounds(155, 425, 235, 20); // setBounds(x, y, width, height)
        regWindow.add(checkBox);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(fieldFont);
        submitButton.setBounds(160, 480, 100, 20); // setBounds(x, y, width, height)
        regWindow.add(submitButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(fieldFont);
        resetButton.setBounds(295, 480, 100, 20); // setBounds(x, y, width, height)
        regWindow.add(resetButton);

        JLabel messageText = new JLabel("");
        messageText.setFont(labelFont);
        messageText.setBounds(100, 535, 400, 20); // setBounds(x, y, width, height)
        messageText.setVisible(false);
        regWindow.add(messageText);

        regWindow.setVisible(true);



        submitButton.addActionListener(e -> {
            messageText.setText("");
            messageText.setVisible(false);
            String name = nameTextField.getText().trim();
            String mobile = mobileTextField.getText().trim();
            String genderText = male.isSelected() ? "Male" : "Female";
            String dob = dayCombo.getSelectedItem() + " " + monthCombo.getSelectedItem() + " " + yearCombo.getSelectedItem();
            String address = addressTextArea.getText().trim();

            // Basic validation
            if (name.isEmpty() || mobile.isEmpty() || address.isEmpty()) {
                messageText.setText("Please fill all required fields.");
                messageText.setVisible(true);

                return;
            }

            if (!mobile.matches("\\d{10}")) {
                messageText.setText("Enter a valid 10-digit mobile number.");
                messageText.setVisible(true);
                return;
            }

            if (!checkBox.isSelected()) {
                messageText.setText("Please accept the terms & conditions..");
                messageText.setVisible(true);
                return;
            }

            // Display entered info
            userInfo.removeAll();
            userInfo.add(new JLabel("Name: " + name));
            userInfo.add(new JLabel("Mobile: " + mobile));
            userInfo.add(new JLabel("Gender: " + genderText));
            userInfo.add(new JLabel("DOB: " + dob));
            userInfo.add(new JLabel("Address: " + address));


            userInfo.revalidate();
            userInfo.repaint();

            // Show success message
            messageText.setText("Registration Successfully..");
            messageText.setVisible(true);


        });

        resetButton.addActionListener(e -> {
            messageText.setText("");
            messageText.setVisible(false);
            nameTextField.setText("");
            mobileTextField.setText("");
            male.setSelected(true);
            yearCombo.setSelectedIndex(0);
            monthCombo.setSelectedIndex(0);
            dayCombo.setSelectedIndex(0);
            addressTextArea.setText("");
            checkBox.setSelected(false);
            userInfo.removeAll();
            userInfo.repaint();
        });

    }
}
