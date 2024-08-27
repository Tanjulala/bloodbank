package reg;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import entity.*;
import receiver.*;

public class ReceiverHistoryFrame extends Base {

    public ReceiverHistoryFrame() {
        super("Receiver History");

        // Initialize the table model with column names
        String[] columnNames = { "Receiver ID", "Name", "Father's Name", "Mother's Name", "DOB", "Mobile No", "Gender",
                "Email", "Blood Group", "City", "Address" };
        tableModel = new DefaultTableModel(columnNames, 0);
        historyTable = new JTable(tableModel);

        // Reduce the height of each row
        historyTable.setRowHeight(25);

        // Enclosing the table within a JScrollPane to make it scrollable
        JScrollPane scrollPane = new JScrollPane(historyTable);
        scrollPane.setPreferredSize(new Dimension(200, 200)); // Set preferred size with reduced height

        // Add labels and text fields for adding/updating receiver information
        JPanel inputPanel = new JPanel();
        addFormFields(inputPanel);

        // Add buttons for functionalities
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Set layout for the frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Load the receiver history from file
        loadReceiverHistory();

        // Add action listeners for buttons
        addButton.addActionListener(e -> addReceiver());
        updateButton.addActionListener(e -> updateReceiver());
        deleteButton.addActionListener(e -> deleteReceiver());

        // Set preferred frame size
        setSize(800, 700);
    }

    // Adjusted method to add labels and text fields with smaller size
    protected void addFormFields(JPanel panel) {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        panel.add(new JLabel("Receiver ID:"), gbc);
        gbc.gridx++;
        panel.add(idField = new JTextField(30), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx++;
        panel.add(nameField = new JTextField(30), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Father's Name:"), gbc);
        gbc.gridx++;
        panel.add(fatherNameField = new JTextField(30), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Mother's Name:"), gbc);
        gbc.gridx++;
        panel.add(motherNameField = new JTextField(30), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("DOB:"), gbc);
        gbc.gridx++;
        panel.add(dobField = new JTextField(30), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Mobile No:"), gbc);
        gbc.gridx++;
        panel.add(mobileNoField = new JTextField(30), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Gender:"), gbc);
        gbc.gridx++;
        panel.add(genderComboBox = new JComboBox<>(new String[] { "Male", "Female", "Other" }), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx++;
        panel.add(emailField = new JTextField(30), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Blood Group:"), gbc);
        gbc.gridx++;
        panel.add(
                bloodGroupComboBox = new JComboBox<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }),
                gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("City:"), gbc);
        gbc.gridx++;
        panel.add(cityField = new JTextField(30), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Address:"), gbc);
        gbc.gridx++;
        gbc.gridwidth = 2; // Address field spans 2 columns
        panel.add(addressTextArea = new JTextArea(5, 30), gbc);
    }

    private void addReceiver() {
        String[] receiverData = {
                idField.getText(),
                nameField.getText(),
                fatherNameField.getText(),
                motherNameField.getText(),
                dobField.getText(),
                mobileNoField.getText(),
                (String) genderComboBox.getSelectedItem(), // Using combo box selection
                emailField.getText(),
                (String) bloodGroupComboBox.getSelectedItem(), // Using combo box selection
                cityField.getText(),
                addressTextArea.getText() // Using multi-line text area
        };

        tableModel.addRow(receiverData);

        // Create a ReceiverEntity object
        ReceiverEntity receiverEntity = new ReceiverEntity(
                receiverData[0], receiverData[1], receiverData[2], receiverData[3],
                receiverData[4], receiverData[5], receiverData[6], receiverData[7],
                receiverData[8], receiverData[9], receiverData[10]);

        // Save the receiver entity to file
        try {
            receiverEntity.saveToFile();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save receiver information to file.");
        }
    }

    private void updateReceiver() {
        int selectedRowIndex = historyTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            String[] receiverData = {
                    idField.getText(),
                    nameField.getText(),
                    fatherNameField.getText(),
                    motherNameField.getText(),
                    dobField.getText(),
                    mobileNoField.getText(),
                    (String) genderComboBox.getSelectedItem(), // Using combo box selection
                    emailField.getText(),
                    (String) bloodGroupComboBox.getSelectedItem(), // Using combo box selection
                    cityField.getText(),
                    addressTextArea.getText() // Using multi-line text area
            };

            // Update table model
            for (int i = 0; i < receiverData.length; i++) {
                tableModel.setValueAt(receiverData[i], selectedRowIndex, i);
            }

            // Save updated receiver history to file
            saveReceiverHistory();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
        }
    }

    private void deleteReceiver() {
        int selectedRowIndex = historyTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            tableModel.removeRow(selectedRowIndex);
            saveReceiverHistory();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }

}
