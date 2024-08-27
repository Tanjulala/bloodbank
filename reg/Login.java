package reg;

import gui.*;

import java.lang.*;
import java.util.Scanner;

import javax.swing.*;

import emManage.*;
import entity.User;
import entity.*;
import Staff.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Login extends JFrame implements ActionListener {

    JLabel userLabel, passLabel, imgLabel, userLabel2;
    JTextField userTF;
    JPasswordField passPF;
    ImageIcon img;
    JButton loginBtn, registerBtn, exitBtn, adminBtn, stfBtn, pBtn;
    JRadioButton r1, r2, r3;
    JCheckBox c1, c2, c3;
    ButtonGroup bg1;
    JComboBox combo;
    JPanel panel, bpanel;
    Color mycolor, mycolor2;
    Font myFont, myFont2, myFont3;
    EmployeeList employeeList;
    BloodList bloodList;

    public Login(EmployeeList employeeList, BloodList bloodlList) {

        super("Lifeline Blood Bank ");
        this.setBounds(280, 70, 1052, 642);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("resources/gg.png"));
        this.setIconImage(logo.getImage());
        JLabel ob = new JLabel(logo);
        ob.setBounds(0, 0, 64, 70);

        this.employeeList = employeeList;
        this.bloodList = bloodList;

        mycolor = new Color(175, 175, 225);
        mycolor2 = new Color(128, 175, 175);
        myFont = new Font("Times New Roman", Font.BOLD, 31);
        myFont2 = new Font("Arial", Font.BOLD + Font.ITALIC, 18);
        myFont3 = new Font("Arial", Font.BOLD, 16);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(mycolor);

        bpanel = new JPanel();
        bpanel.setLayout(null);
        bpanel.setBounds(0, 0, 1062, 30);
        bpanel.setBackground(mycolor2);
        this.add(bpanel);

        userLabel = new JLabel("User Name: ");
        userLabel.setBounds(100, 200, 170, 40);
        userLabel.setOpaque(false);
        userLabel.setForeground(Color.black);
        userLabel.setFont(myFont);
        panel.add(userLabel);

        userTF = new JTextField();
        userTF.setBounds(290, 200, 170, 40);
        userTF.setBackground(Color.white);
        panel.add(userTF);

        userLabel2 = new JLabel("+Lifeline Blood Bank >>>>");
        userLabel2.setBounds(0, 0, 500, 40);
        userLabel2.setOpaque(false);
        userLabel2.setForeground(Color.BLACK);
        userLabel2.setFont(myFont2);
        bpanel.add(userLabel2);

        passLabel = new JLabel("Password  : ");
        passLabel.setBounds(100, 250, 160, 40);
        passLabel.setOpaque(false);
        passLabel.setForeground(Color.black);
        passLabel.setFont(myFont);
        panel.add(passLabel);

        passPF = new JPasswordField();
        passPF.setBounds(290, 250, 170, 40);
        passPF.setBackground(Color.white);
        passPF.setEchoChar('*');
        panel.add(passPF);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(160, 340, 90, 30);
        loginBtn.setBackground(mycolor);
        loginBtn.setFont(myFont3);
        loginBtn.addActionListener(this);
        panel.add(loginBtn);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(280, 340, 100, 30);
        registerBtn.addActionListener(this);
        registerBtn.setFont(myFont3);
        panel.add(registerBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(210, 400, 90, 30);
        // exitBtn.setBackground(mycolor);
        exitBtn.setFont(myFont3);
        exitBtn.addActionListener(this);
        panel.add(exitBtn);

        /// admin//////
        adminBtn = new JButton("Admin");
        adminBtn.setBounds(680, 0, 150, 30);
        adminBtn.setBackground(mycolor2);
        adminBtn.setFont(myFont3);
        adminBtn.addActionListener(this);
        bpanel.add(adminBtn);

        pBtn = new JButton("Blood Info");
        pBtn.setBounds(850, 0, 150, 30);
        pBtn.setBackground(mycolor2);
        pBtn.setFont(myFont3);
        pBtn.addActionListener(this);
        bpanel.add(pBtn);

        // image//////////////////////////////

        img = new ImageIcon("reg.png");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, 1050, 682);
        panel.add(imgLabel);

        this.add(panel);// sobr last e alwys
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(adminBtn)) {
            BloodList bloodList = new BloodList();
            ALogin ob = new ALogin(employeeList, bloodList);
            ob.setVisible(true);
            this.setVisible(false);

        } else if (registerBtn == e.getSource()) {
            new Register(employeeList, bloodList);
            this.setVisible(false);
        } else if (loginBtn == e.getSource()) {

            String name = userTF.getText();
            String pass = String.valueOf(passPF.getPassword());

            if (name.equals("staff") && pass.equals("123")) {
                // Handle staff login

                staffhome ob = new staffhome();
                ob.setVisible(true);
                this.setVisible(false);

            } else {

                String role = "";
                boolean validCredentials = false;

                try {
                    File file = new File("login.txt");
                    if (!file.exists()) {
                        JOptionPane.showMessageDialog(this, "File doesn't Exist", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Scanner scanner = new Scanner(file);

                    while (scanner.hasNextLine()) {
                        String[] line = scanner.nextLine().trim().split(",");
                        if (line.length == 6 && name.equals(line[1]) && pass.equals(line[2])) {
                            validCredentials = true;
                            role = line[0];
                            break;
                        }
                    }
                    scanner.close();

                    if (validCredentials) {

                        userTF.setText("");
                        passPF.setText("");

                        if (role.equalsIgnoreCase("Donar")) {

                            Welcome frame = new Welcome();
                            frame.setVisible(true);
                            this.setVisible(false);
                        } else if (role.equalsIgnoreCase("Receiver")) {
                            Rec on = new Rec();
                            on.setVisible(true);
                            this.setVisible(false);

                            this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid User Name or Password", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (IOException ae) {
                    System.out.println(ae);
                }
            }
        } else if (e.getSource() == exitBtn) {

            System.exit(0);

        } else if (e.getSource() == pBtn) {

            Privacy ob = new Privacy();
            ob.setVisible(true);

            this.setVisible(false);
        }

    }
}
