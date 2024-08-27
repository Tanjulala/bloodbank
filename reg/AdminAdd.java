package reg;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;

public class AdminAdd extends JFrame {

    Container c;
    ImageIcon icon;
    JLabel label1, labelq, gender;
    Font f1, f2, f3, f4, f5, f6;
    JTextField tf1, tf2, tf3, tf4;
    JComboBox securityQsn, bloodgroup;
    JButton btn1, btn2, nBtn;
    Cursor cursor;
    JRadioButton male, female, others;

    public AdminAdd() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Blood Donation System");
        this.setSize(610, 550);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("images/blood-drop.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 35);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.PLAIN, 25);
        f5 = new Font("Segoe UI", Font.PLAIN, 19);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

        // Title
        label1 = new JLabel();
        label1.setText("Enter Information");
        label1.setBounds(160, 25, 500, 50);
        label1.setFont(f1);
        c.add(label1);

        // Donor Name
        label1 = new JLabel();
        label1.setText("Donor Name");
        label1.setBounds(45, 75, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(200, 85, 260, 30);
        tf1.setFont(f5);
        c.add(tf1);

        // Donor Age
        label1 = new JLabel();
        label1.setText("Donor Age");
        label1.setBounds(45, 110, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf2 = new JTextField();
        tf2.setBounds(200, 120, 260, 30);
        tf2.setFont(f5);
        c.add(tf2);

        // Mobile
        label1 = new JLabel();
        label1.setText("Mobile No");
        label1.setBounds(45, 145, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf3 = new JTextField();
        tf3.setBounds(200, 155, 260, 30);
        tf3.setFont(f2);
        c.add(tf3);

        // Blood Group
        label1 = new JLabel();
        label1.setText("Blood Group");
        label1.setBounds(45, 180, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        String[] b = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
        bloodgroup = new JComboBox(b);
        bloodgroup.setBounds(200, 190, 259, 30);
        bloodgroup.setSelectedIndex(0);
        bloodgroup.setFont(f5);
        bloodgroup.setBackground(Color.white);
        c.add(bloodgroup);

        // Question
        labelq = new JLabel();
        labelq.setText("Question");
        labelq.setBounds(45, 215, 500, 50);
        labelq.setFont(f4);
        c.add(labelq);

        String[] secQsn = { "Choose a Security Question...", "Your dream job?", "Your favorite song?",
                "First pet's name?", "Your favorite hobby?" };
        securityQsn = new JComboBox(secQsn);
        securityQsn.setBounds(200, 225, 259, 30);
        securityQsn.setSelectedIndex(0);
        securityQsn.setFont(f5);
        securityQsn.setBackground(Color.white);
        c.add(securityQsn);

        // Answer
        label1 = new JLabel();
        label1.setText("Answer");
        label1.setBounds(45, 255, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf4 = new JTextField();
        tf4.setBounds(200, 265, 260, 30);
        tf4.setFont(f5);
        c.add(tf4);

        gender = new JLabel();
        gender.setText("Gender");
        gender.setBounds(45, 290, 500, 50);
        gender.setFont(f4);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(200, 303, 120, 20);
        male.setFont(f4);
        c.add(male);

        female = new JRadioButton("Female");
        female.setBounds(320, 303, 120, 20);
        female.setFont(f4);
        c.add(female);

        others = new JRadioButton("Others");
        others.setBounds(440, 303, 120, 20);
        others.setFont(f4);
        c.add(others);

        ButtonGroup gp = new ButtonGroup();
        gp.add(male);
        gp.add(female);
        gp.add(others);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Back");
        btn1.setBounds(80, 370, 183, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2E75B6"));
        c.add(btn1);

        btn2 = new JButton("Confirm");
        btn2.setBounds(290, 370, 183, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        c.add(btn2);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Back Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                UserData frame = new UserData();
                frame.setVisible(true);
            }
        });

        // Confirm Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String textField1 = tf1.getText().toLowerCase(); // Donor Name
                String textField2 = tf2.getText(); // Donor Age
                String textField3 = tf3.getText(); // Mobile
                String textField4 = tf4.getText(); // Security Question Answer
                String secQsn = String.valueOf(securityQsn.getSelectedItem()); // Security Question
                String blg = String.valueOf(bloodgroup.getSelectedItem());

                if (textField1.isEmpty() || textField2.isEmpty() || textField3.isEmpty() || textField4.isEmpty()
                        || ((securityQsn.getSelectedIndex()) == 0)) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);

                } else {

                    if (male.isSelected() || female.isSelected() || others.isSelected()) {
                        try {
                            File file = new File(".\\Data\\donor_info.txt");
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            FileWriter fw = new FileWriter(file, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);

                            LocalDateTime myDateObj = LocalDateTime.now();
                            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                            String timeAndDate = myDateObj.format(myFormatObj);

                            pw.println("             ## Added by Donor ##");
                            pw.println("Donor Name : " + textField1);
                            pw.println("Mobile No : " + textField3);
                            pw.println("Age : " + textField2);
                            pw.println("Blood Group: " + blg);
                            pw.println("Security Question : " + secQsn);
                            pw.println("Answer : " + textField4);
                            pw.println("Time & Date : " + timeAndDate);
                            if (male.isSelected()) {
                                pw.println("Gender : " + "Male");
                            } else if (female.isSelected()) {
                                pw.println("Gender : " + "Female");
                            } else {
                                pw.println("Gender : " + "Other");
                            }
                            pw.println("===============================================");
                            pw.close();

                        } catch (Exception ex) {
                            System.out.print(ex);
                        }

                    }

                    if (male.isSelected() || female.isSelected() || others.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Donor has been added.", "Donor Added",
                                JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                        AdminAdd frame = new AdminAdd();
                        frame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Gender is required", "Error",
                                JOptionPane.WARNING_MESSAGE);

                    }
                }
            }
        });
    }

}
