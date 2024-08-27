package reg;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import entity.*;

public class AddReceiverFrame extends JFrame {

    private JButton submitButton;

    // Text fields for input
    private JTextField idField;
    private JTextField nameField;
    private JTextField fatherNameField;
    private JTextField motherNameField;
    private JTextField dobField;
    private JTextField mobileNoField;
    private JComboBox<String> genderComboBox; // Changed to JComboBox
    private JTextField emailField;
    private JComboBox<String> bloodGroupComboBox; // Changed to JComboBox
    private JTextField cityField;
    private JTextField addressField;

    public AddReceiverFrame() {
        super("Add Receiver");

        // Adding background image and header
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("./resources/history.png");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());
        add(backgroundPanel);

        JLabel headerLabel = new JLabel("Add Blood Receiver's Request");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 40));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setOpaque(false);
        addFormFields(formPanel);
        backgroundPanel.add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);
        backgroundPanel.add(buttonPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(e -> saveReceiverDetails());

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void addFormFields(JPanel formPanel) {
        formPanel.setLayout(new GridLayout(11, 2));

        formPanel.add(new JLabel("ID:"));
        idField = new JTextField(20);
        formPanel.add(idField);

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField(20);
        formPanel.add(nameField);

        formPanel.add(new JLabel("Father's Name:"));
        fatherNameField = new JTextField(20);
        formPanel.add(fatherNameField);

        formPanel.add(new JLabel("Mother's Name:"));
        motherNameField = new JTextField(20);
        formPanel.add(motherNameField);

        formPanel.add(new JLabel("Date of Birth:"));
        dobField = new JTextField(20);
        formPanel.add(dobField);

        formPanel.add(new JLabel("Mobile No:"));
        mobileNoField = new JTextField(20);
        formPanel.add(mobileNoField);

        formPanel.add(new JLabel("Gender:"));
        String[] genders = { "Male", "Female", "Other" }; // Options for gender
        genderComboBox = new JComboBox<>(genders);
        formPanel.add(genderComboBox);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField(20);
        formPanel.add(emailField);

        formPanel.add(new JLabel("Blood Group:"));
        String[] bloodGroups = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }; // Options for blood group
        bloodGroupComboBox = new JComboBox<>(bloodGroups);
        formPanel.add(bloodGroupComboBox);

        formPanel.add(new JLabel("City:"));
        cityField = new JTextField(20);
        formPanel.add(cityField);

        formPanel.add(new JLabel("Address:"));
        addressField = new JTextField(20);
        formPanel.add(addressField);
    }

    private void saveReceiverDetails() {
        // Validate input fields before saving
        if (validateFields()) {
            ReceiverEntity receiver = new ReceiverEntity(
                    idField.getText(), nameField.getText(), fatherNameField.getText(),
                    motherNameField.getText(), dobField.getText(), mobileNoField.getText(),
                    genderComboBox.getSelectedItem().toString(), emailField.getText(),
                    bloodGroupComboBox.getSelectedItem().toString(), cityField.getText(),
                    addressField.getText());

            try {
                receiver.saveToFile();
                JOptionPane.showMessageDialog(this, "Receiver details saved successfully!");
                clearFields();
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving receiver details.");
            }
        }
    }

    private boolean validateFields() {
        // Validate each input field
        if (idField.getText().isEmpty() || nameField.getText().isEmpty() ||
                dobField.getText().isEmpty() || mobileNoField.getText().isEmpty() ||
                emailField.getText().isEmpty() || cityField.getText().isEmpty() ||
                addressField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the required fields.");
            return false;
        }

        // Add more validation logic for specific fields if needed

        return true;
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        fatherNameField.setText("");
        motherNameField.setText("");
        dobField.setText("");
        mobileNoField.setText("");
        emailField.setText("");
        cityField.setText("");
        addressField.setText("");
    }

    public static void main(String[] args) {
        new AddReceiverFrame();
    }
}
