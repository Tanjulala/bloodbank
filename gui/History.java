package gui;

import entity.*;
import emManage.*;
import javax.swing.*;
import javax.swing.table.*;
import IInter.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class History extends JFrame implements ActionListener {

    private JLabel userLabel, user, user2, user3, imgLabel, role, name, mobile, email;
    private JTextField nameT, mobileT, emailT;
    private ImageIcon img;
    private JButton exitBtn, homBtn, addBtn, cBtn, dBtn, updBtn;
    private JComboBox combo;
    private JRadioButton d, r;
    private ButtonGroup bg;
    private JPanel panel, bpanel;
    private Color mycolor, mycolor2;
    private Font myFont, myFont2, myFont3, myFont4;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private String[] columns = { "Role", "Name", "Mobile", "Email" };
    private String[] rows = new String[5];

    public History() {
        super("+Lifeline BLood Bank ");
        // this.setSize(1200, 632);
        this.setBounds(230, 100, 1200, 632);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("resources/gg.png"));
        this.setIconImage(logo.getImage());
        JLabel ob = new JLabel(logo);
        ob.setBounds(0, 0, 64, 70);

        mycolor = new Color(255, 0, 0);
        mycolor2 = new Color(175, 175, 175);
        myFont = new Font("Times New Roman", Font.BOLD, 20);
        myFont2 = new Font("Arial", Font.BOLD, 18);
        myFont3 = new Font("Arial", Font.BOLD, 21);
        myFont4 = new Font("Arial", Font.BOLD, 12);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(mycolor);

        bpanel = new JPanel();
        bpanel.setLayout(null);
        bpanel.setBounds(205, 0, 1200, 40);
        bpanel.setBackground(mycolor2);
        this.add(bpanel);

        userLabel = new JLabel("    ''THE GIFT ");
        userLabel.setBounds(0, 80, 400, 300);
        userLabel.setBackground(Color.white);
        userLabel.setOpaque(false);
        userLabel.setForeground(Color.white);
        userLabel.setFont(myFont);
        panel.add(userLabel);

        user = new JLabel("        OF BLOOD");
        user.setBounds(0, 120, 400, 300);
        user.setBackground(Color.white);
        user.setOpaque(false);
        user.setForeground(Color.black);
        user.setFont(myFont);
        panel.add(user);

        user2 = new JLabel("    IS THE GIFT");
        user2.setBounds(0, 160, 400, 300);
        user2.setBackground(Color.white);
        user2.setOpaque(false);
        user2.setForeground(Color.black);
        user2.setFont(myFont);
        panel.add(user2);

        user3 = new JLabel("           OF LIFE''");
        user3.setBounds(0, 200, 400, 300);
        user3.setBackground(Color.white);
        user3.setOpaque(false);
        user3.setForeground(Color.black);
        user3.setFont(myFont);
        panel.add(user3);

        homBtn = new JButton("Home");
        homBtn.setBounds(700, 0, 100, 40);
        homBtn.setBackground(mycolor2);
        homBtn.setFont(myFont2);
        homBtn.addActionListener(this);
        bpanel.add(homBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(820, 0, 100, 40);
        exitBtn.setBackground(mycolor2);
        exitBtn.setFont(myFont2);
        exitBtn.addActionListener(this);
        bpanel.add(exitBtn);

        addBtn = new JButton("ADD");
        addBtn.setBounds(300, 400, 90, 30);
        addBtn.setBackground(Color.red);
        addBtn.setForeground(Color.white);
        panel.add(addBtn);

        updBtn = new JButton("UPDATE");
        updBtn.setBounds(300, 450, 90, 30);
        updBtn.setBackground(Color.red);
        updBtn.setForeground(Color.white);
        panel.add(updBtn);

        cBtn = new JButton("CLEAR");
        cBtn.setBounds(400, 400, 90, 30);
        cBtn.setBackground(Color.red);
        cBtn.setForeground(Color.white);
        panel.add(cBtn);

        dBtn = new JButton("DELETE");
        dBtn.setBounds(400, 450, 90, 30);
        dBtn.setBackground(Color.red);
        dBtn.setForeground(Color.white);
        panel.add(dBtn);

        //////////////////////////////////////
        role = new JLabel("Role:");
        role.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 20));
        role.setBounds(250, 220, 200, 30);
        this.add(role);

        d = new JRadioButton("Donar");
        d.setOpaque(false);
        d.setForeground(Color.black);
        d.setBounds(350, 220, 90, 30);
        panel.add(d);

        r = new JRadioButton("Receiver");
        r.setOpaque(false);
        r.setForeground(Color.BLACK);
        r.setBounds(450, 220, 90, 30);
        panel.add(r);

        bg = new ButtonGroup();
        bg.add(d);
        bg.add(r);

        name = new JLabel("Name:");
        name.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 20));
        name.setBounds(250, 180, 200, 30);
        this.add(name);

        nameT = new JTextField();
        nameT.setBounds(350, 180, 200, 30);
        nameT.setBackground(Color.WHITE);
        panel.add(nameT);

        mobile = new JLabel("Mobile:");
        mobile.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 20));
        mobile.setBounds(250, 262, 200, 30);
        this.add(mobile);

        mobileT = new JTextField();
        mobileT.setBounds(350, 262, 200, 30);
        mobileT.setBackground(Color.WHITE);
        panel.add(mobileT);

        email = new JLabel("Email:");
        email.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 20));
        email.setBounds(250, 310, 200, 30);
        this.add(email);

        emailT = new JTextField();
        emailT.setBounds(350, 310, 200, 30);
        emailT.setBackground(Color.WHITE);
        panel.add(emailT);

        JLabel headline = new JLabel("              User Information  ");
        headline.setBounds(250, 100, 400, 40);
        headline.setBackground(Color.white);
        headline.setOpaque(false);
        headline.setForeground(Color.black);
        headline.setFont(myFont3);
        panel.add(headline);

        JLabel userLabel2 = new JLabel("  +Lifeline Blood Bank >>>>");
        userLabel2.setBounds(0, 0, 500, 40);
        userLabel2.setOpaque(false);
        userLabel2.setForeground(Color.BLACK);
        userLabel2.setFont(myFont2);
        bpanel.add(userLabel2);

        /// image////////////////////////////
        img = new ImageIcon("resources/history.png");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(205, 0, 983, 612);
        panel.add(imgLabel);

        table = new JTable();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBounds(650, 90, 500, 250);
        table.setBackground(Color.white);
        table.setSelectionBackground(Color.gray);
        table.setFont(myFont4);
        table.setRowHeight(30);

        scroll = new JScrollPane();
        scroll.setBounds(650, 90, 500, 250);
        this.add(scroll);
        scroll.setViewportView(table);
        addBtn.addActionListener(this);
        cBtn.addActionListener(this);
        dBtn.addActionListener(this);
        updBtn.addActionListener(this);
        this.add(panel);
        loadDataFromFile();

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                int numberofRow = table.getSelectedRow();

                String r1 = model.getValueAt(numberofRow, 0).toString();
                String uname = model.getValueAt(numberofRow, 1).toString();
                String umobile = model.getValueAt(numberofRow, 2).toString();
                String uemail = model.getValueAt(numberofRow, 3).toString();

                nameT.setText(uname);
                mobileT.setText(umobile);
                if (r1.equals("Donar")) {
                    d.setSelected(true);
                } else if (r1.equals("Receiver")) {
                    r.setSelected(true);
                }
                mobileT.setText(umobile);
                emailT.setText(uemail);
            }
        });

    }

    private void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("login.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length >= 6) {

                    String[] displayFields = new String[4];
                    displayFields[0] = fields[0];
                    displayFields[1] = fields[1];
                    displayFields[2] = fields[4];
                    displayFields[3] = fields[5];

                    model.addRow(displayFields);
                    // model.addRow(fields);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            if (nameT.getText().isEmpty() || mobileT.getText().isEmpty()
                    || emailT.getText().isEmpty() || (!d.isSelected() && !r.isSelected())) {
                JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (d.isSelected()) {
                rows[0] = "Donar";
            } else if (r.isSelected()) {
                rows[0] = "Receiver";
            }
            rows[1] = nameT.getText();
            rows[2] = mobileT.getText();
            rows[3] = emailT.getText();

            model.addRow(rows);

            bg.clearSelection();
            nameT.setText("");
            mobileT.setText("");
            emailT.setText("");

        } else if (e.getSource() == cBtn) {

            bg.clearSelection();
            nameT.setText("");
            mobileT.setText("");
            emailT.setText("");

        } else if (e.getSource() == dBtn) {

            int numberofRow = table.getSelectedRow();

            if (numberofRow >= 0) {
                model.removeRow(numberofRow);
            } else {
                JOptionPane.showMessageDialog(this, "No row has been selected", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == updBtn) {
            int numberOfRow = table.getSelectedRow();
            if (numberOfRow != -1) {
                String uname = nameT.getText();
                String roleT = "";
                if (d.isSelected()) {
                    roleT = "Donar";
                } else if (r.isSelected()) {
                    roleT = "Receiver";
                }
                String umobile = mobileT.getText();
                String uemail = emailT.getText();

                // Update the values in the selected row
                model.setValueAt(roleT, numberOfRow, 0);
                model.setValueAt(uname, numberOfRow, 1);
                model.setValueAt(umobile, numberOfRow, 2);
                model.setValueAt(uemail, numberOfRow, 3);

                bg.clearSelection();
                nameT.setText("");
                mobileT.setText("");
                emailT.setText("");

            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to update.", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == homBtn) {

            EmployeeList employeeList = new EmployeeList();
            BloodList bloodList = new BloodList();
            Homepg p = new Homepg(employeeList, bloodList);
            p.setVisible(true);
            this.setVisible(false);
        }

        else if (e.getSource() == exitBtn) {

            System.exit(0);
        }

    }

}
