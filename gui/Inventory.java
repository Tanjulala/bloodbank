package gui;

import java.lang.*;
import java.util.Collections;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import emManage.BloodList;
import emManage.EmployeeList;
import entity.BloodGroup;
import entity.Employee;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Inventory extends JFrame implements ActionListener {

    JLabel bloodLabel, gLabel, qLabel, sLabel, imgLabel, imgLabel2, admin;
    JTextField gField, qField, sField;
    JPasswordField passPF;
    ImageIcon img, img2, img3;
    JButton updBtn, clrBtn, exitBtn, addBtn, homBtn;
    JComboBox combo, combo2, combo3;
    JPanel panel;
    Color mycolor, mycolor2;
    Font myFont, myFont2;
    JTable table;
    DefaultTableModel model;
    BloodList b;

    public Inventory(BloodList b) {

        super("Lifeline Blood Bank ");
        this.setBounds(150, 30, 1250, 750);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("resources/gg.png"));
        this.setIconImage(logo.getImage());
        this.b = b;

        mycolor = new Color(175, 175, 178);
        mycolor2 = new Color(204, 204, 204);
        myFont = new Font("Times New Roman", Font.BOLD, 31);
        myFont2 = new Font("Arial", Font.BOLD, 16);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(mycolor);

        //////// JLabel?/////////////////////////

        bloodLabel = new JLabel("<< BLOOD STOCK >>");
        bloodLabel.setBounds(700, 35, 350, 50);
        bloodLabel.setBackground(Color.white);
        bloodLabel.setOpaque(false);
        bloodLabel.setForeground(Color.black);
        bloodLabel.setFont(myFont);
        panel.add(bloodLabel);

        admin = new JLabel("            ADMIN PAGE ");
        admin.setBounds(5, 25, 440, 40);
        admin.setBackground(Color.gray);
        admin.setOpaque(true);
        admin.setForeground(Color.white);
        admin.setFont(myFont);
        panel.add(admin);

        /////////// btn//////////////////
        updBtn = new JButton("UPDATE");
        updBtn.setBounds(1050, 180, 100, 30);
        updBtn.addActionListener(this);
        panel.add(updBtn);

        clrBtn = new JButton("CLEAR");
        clrBtn.setBounds(1050, 250, 100, 30);
        clrBtn.addActionListener(this);
        panel.add(clrBtn);

        addBtn = new JButton("ADD");
        addBtn.setBounds(1050, 320, 100, 30);
        addBtn.addActionListener(this);
        panel.add(addBtn);

        homBtn = new JButton("Home");
        homBtn.setBounds(130, 550, 150, 40);
        homBtn.setFont(myFont2);
        homBtn.setBackground(mycolor2);
        homBtn.setForeground(Color.black);
        homBtn.addActionListener(this);
        panel.add(homBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(130, 600, 150, 40);
        exitBtn.setFont(myFont2);
        exitBtn.setForeground(Color.black);
        exitBtn.setBackground(mycolor2);
        exitBtn.addActionListener(this);
        panel.add(exitBtn);

        gLabel = new JLabel("Blood Group: ");
        gLabel.setBounds(900, 500, 150, 40);
        gLabel.setBackground(Color.white);
        gLabel.setOpaque(false);
        gLabel.setForeground(Color.black);
        gLabel.setFont(myFont2);
        panel.add(gLabel);

        String[] items = { "", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
        combo = new JComboBox(items);
        combo.setBounds(1080, 500, 100, 35);
        panel.add(combo);

        qLabel = new JLabel("Quantiity: ");
        qLabel.setBounds(900, 560, 190, 40);
        qLabel.setBackground(Color.white);
        qLabel.setOpaque(false);
        qLabel.setForeground(Color.black);
        qLabel.setFont(myFont2);
        panel.add(qLabel);

        String[] items2 = new String[101];
        items2[0] = "";
        for (int i = 1; i <= 100; i++) {
            items2[i] = String.valueOf(i);
        }

        // Create the combo box
        combo2 = new JComboBox(items2);
        combo2.setBounds(1080, 560, 100, 35);
        panel.add(combo2);

        qLabel = new JLabel("Status: ");
        qLabel.setBounds(900, 620, 190, 40);
        qLabel.setBackground(Color.white);
        qLabel.setOpaque(false);
        qLabel.setForeground(Color.black);
        qLabel.setFont(myFont2);
        panel.add(qLabel);

        String[] items3 = { "", "Available", "Not Available" };
        combo3 = new JComboBox(items3);
        combo3.setBounds(1080, 620, 100, 35);
        panel.add(combo3);

        // image//////////////////////////////////////

        img = new ImageIcon("resources/in.png");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, 450, 705);
        panel.add(imgLabel);

        img2 = new ImageIcon("resources/hand.png");
        imgLabel2 = new JLabel(img2);
        imgLabel2.setBounds(460, 430, 900, 280);
        panel.add(imgLabel2);

        this.add(panel);// sobr last e alwys
        createTable();
        updateFile();
        loadBloodData();
        clearFields();

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                int numberofRow = table.getSelectedRow();

                String Bg = model.getValueAt(numberofRow, 0).toString();
                String Bq = model.getValueAt(numberofRow, 1).toString();
                String Bs = model.getValueAt(numberofRow, 2).toString();

                combo.setSelectedItem(Bg);
                combo2.setSelectedItem(Bq);
                combo3.setSelectedItem(Bs);

            }
        });
    }

    private void loadBloodData() {
        try (BufferedReader br = new BufferedReader(new FileReader("InvInfo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] BloodData = line.split(",");
                model.addRow(BloodData);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading employee data from file", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createTable() {

        model = new DefaultTableModel();

        model.addColumn("Blood Group");
        model.addColumn("Quantity");
        model.addColumn("Status");

        BloodGroup[] bloods = b.getAllBloodGroup();

        for (int i = 0; i < bloods.length; i++) {
            if (bloods[i] != null) {
                model.addRow(new Object[] {
                        bloods[i].getBloodGroup(),
                        bloods[i].getQuantity(),
                        bloods[i].getstatus(),

                });
            }

        }

        table = new JTable(model);
        table.setSelectionBackground(new Color(175, 175, 175));
        table.setFont(myFont2);
        table.setRowHeight(40);
        table.setBounds(500, 140, 400, 230);
        // Create a JScrollPane to contain the table
        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBounds(520, 140, 400, 230);
        panel.add(scrollPane);
    }

    private void saveDataToFile(String Bg, String Bq, String Bs) {
        try {
            File file = new File("InvInfo.txt");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            String data = Bg + "," + Bq + "," + Bs;
            bw.append(data);
            bw.newLine();
            bw.close();

            System.out.println("Data added and saved to file successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void updateFile() {
        try {
            File file = new File("InvInfo.txt");
            FileWriter fw = new FileWriter(file, true); // Change to append mode
            BufferedWriter bw = new BufferedWriter(fw);

            // Write the updated data from the table to the file
            for (int i = 0; i < model.getRowCount(); i++) {
                String Bg = model.getValueAt(i, 0).toString();
                String Bq = model.getValueAt(i, 1).toString();
                String Bs = model.getValueAt(i, 2).toString();
                String data = Bg + "," + Bq + "," + Bs;
                bw.write(data);
                bw.newLine();
            }

            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void clearFields() {
        combo.setSelectedIndex(0);
        combo2.setSelectedIndex(0);
        combo3.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == updBtn) {
            int numberofRow = table.getSelectedRow();
            if (numberofRow != -1) {
                String Bg = (String) combo.getSelectedItem();
                String Bq = (String) combo2.getSelectedItem();
                String Bs = (String) combo3.getSelectedItem();

                model.setValueAt(Bg, numberofRow, 0);
                model.setValueAt(Bq, numberofRow, 1);
                model.setValueAt(Bs, numberofRow, 2);

                try {

                    File file = new File("InvInfo.txt");
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    String data = Bg + "," + Bq + "," + Bs;

                    bw.append(data);
                    bw.newLine();
                    bw.close();

                    System.out.println("Data updated successfully");

                    JOptionPane.showMessageDialog(this, "Data updated successfully");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            } else {
                JOptionPane.showMessageDialog(this, " Please select a row to update.", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }

        } else if (ae.getSource() == addBtn) {
            String Bg = (String) combo.getSelectedItem();
            String Bq = (String) combo2.getSelectedItem();
            String Bs = (String) combo3.getSelectedItem();

            if (Bg.isEmpty() || Bq.isEmpty() || Bs.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                // Create an array containing the data for the new row
                Object[] newRowData = { Bg, Bq, Bs };

                // Add the new row to the table model
                model.addRow(newRowData);

                // Optionally, save the added data to a file
                saveDataToFile(Bg, Bq, Bs);
            }
        } else if (ae.getSource() == clrBtn) {
            clearFields();
        } else if (ae.getSource() == homBtn) {

            EmployeeList employeeList = new EmployeeList();
            BloodList bloodList = new BloodList();
            Homepg p = new Homepg(employeeList, bloodList);
            p.setVisible(true);
            this.setVisible(false);
        }

        else if (ae.getSource() == exitBtn) {

            System.exit(0);
        }

    }
}
