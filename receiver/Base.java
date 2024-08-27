package receiver;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.Vector;

public class Base extends JFrame {

    protected JTextField idField;
    protected JTextField nameField;
    protected JTextField fatherNameField;
    protected JTextField motherNameField;
    protected JTextField dobField;
    protected JTextField mobileNoField;
    protected JComboBox<String> genderComboBox; // Changed to JComboBox
    protected JTextField emailField;
    protected JComboBox<String> bloodGroupComboBox; // Changed to JComboBox
    protected JTextField cityField;
    protected JTextArea addressTextArea; // Changed to JTextArea
    protected DefaultTableModel tableModel;
    protected JTable historyTable;

    // In the Base class constructor
    public Base(String title) {
        super(title);
        setLayout(new BorderLayout());
        setSize(1600, 1000);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        initCommonComponents();
    }

    protected void initCommonComponents() {
        // Initialize common text fields and combo boxes
        idField = new JTextField();
        nameField = new JTextField();
        fatherNameField = new JTextField();
        motherNameField = new JTextField();
        dobField = new JTextField();
        mobileNoField = new JTextField();
        genderComboBox = new JComboBox<>(new String[] { "Male", "Female", "Other" });
        emailField = new JTextField();
        bloodGroupComboBox = new JComboBox<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" });
        cityField = new JTextField();
        addressTextArea = new JTextArea();
        addressTextArea.setRows(4);

        // Make the combo boxes editable
        genderComboBox.setEditable(true);
        bloodGroupComboBox.setEditable(true);
    }

    protected void addFormFields(JPanel panel) {
        panel.setLayout(new GridLayout(11, 2));
        panel.add(new JLabel("Receiver ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Father's Name:"));
        panel.add(fatherNameField);
        panel.add(new JLabel("Mother's Name:"));
        panel.add(motherNameField);
        panel.add(new JLabel("DOB:"));
        panel.add(dobField);
        panel.add(new JLabel("Mobile No:"));
        panel.add(mobileNoField);
        panel.add(new JLabel("Gender:"));
        panel.add(genderComboBox); // Changed to combo box
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Blood Group:"));
        panel.add(bloodGroupComboBox); // Changed to combo box
        panel.add(new JLabel("City:"));
        panel.add(cityField);
        panel.add(new JLabel("Address:"));
        panel.add(new JScrollPane(addressTextArea)); // Changed to scrollable multi-line text area
    }

    protected void saveReceiverHistory() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("receivers.txt"))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                Vector rowData = (Vector) tableModel.getDataVector().elementAt(i);
                String line = String.join(",", rowData);
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving receiver history.");
        }
    }

    protected void loadReceiverHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader("receivers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                tableModel.addRow(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading receiver history.");
        }
    }
}
