package gui;

import reg.*;
import java.lang.*;
import javax.swing.*;

import emManage.BloodList;
import emManage.EmployeeList;

import java.awt.*;
import java.awt.event.*;

public class ALogin extends JFrame implements ActionListener {

    JLabel userLabel, passLabel, imgLabel;
    JTextField userTF;
    JPasswordField passPF;
    ImageIcon img;
    JButton loginBtn, bBtn;
    JRadioButton r1, r2, r3;
    JCheckBox c1, c2, c3;
    ButtonGroup bg1;
    JComboBox combo;
    JPanel panel;
    Color mycolor;
    Font myFont;
    EmployeeList employeeList;
    BloodList bloodList;

    public ALogin(EmployeeList employeeList, BloodList bloodList) {

        super("Lifeline Blood Bank ");
        this.setBounds(300, 70, 950, 653);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("resources/gg.png"));
        this.setIconImage(logo.getImage());
        JLabel ob = new JLabel(logo);
        ob.setBounds(0, 0, 64, 70);

        this.employeeList = employeeList;
        this.bloodList = bloodList;

        mycolor = new Color(210, 230, 135);
        myFont = new Font("Times New Roman", Font.BOLD, 31);
        Font myFont2 = new Font("Arial", Font.BOLD + Font.ITALIC, 28);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(mycolor);

        userLabel = new JLabel("User Name: ");
        userLabel.setBounds(530, 150, 170, 40);
        userLabel.setOpaque(false);
        userLabel.setForeground(Color.white);
        userLabel.setFont(myFont);
        panel.add(userLabel);

        JLabel userLabel2 = new JLabel("+Lifeline Blood Bank");
        userLabel2.setBounds(10, 550, 500, 40);
        userLabel2.setOpaque(false);
        userLabel2.setForeground(Color.cyan);
        userLabel2.setFont(myFont2);
        panel.add(userLabel2);

        userTF = new JTextField();
        userTF.setBounds(730, 150, 170, 40);
        userTF.setBackground(Color.WHITE);
        panel.add(userTF);

        passLabel = new JLabel("Password  : ");
        passLabel.setBounds(530, 200, 160, 40);
        // passLabel.setBackground(Color.GRAY);
        passLabel.setOpaque(false);
        passLabel.setForeground(Color.white);
        passLabel.setFont(myFont);
        panel.add(passLabel);

        passPF = new JPasswordField();
        passPF.setBounds(730, 200, 170, 40);
        passPF.setBackground(Color.WHITE);
        passPF.setEchoChar('*');
        panel.add(passPF);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(600, 300, 90, 30);
        loginBtn.addActionListener(this);
        panel.add(loginBtn);

        bBtn = new JButton("Back");
        bBtn.setBounds(700, 300, 90, 30);
        bBtn.addActionListener(this);
        panel.add(bBtn);

        img = new ImageIcon("lo.png");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, 948, 618);
        panel.add(imgLabel);

        this.add(panel);// sobr last e alwys
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (loginBtn.getText().equals(command)) {

            String s1 = userTF.getText();
            String s2 = passPF.getText();

            if (s1.equals("admin") && s2.equals("123")) {
                BloodList bloodList = new BloodList();

                Homepg sf = new Homepg(employeeList, bloodList);
                sf.setVisible(true);

                this.setVisible(false);
            }
        } else if (bBtn.getText().equals(command)) {

            EmployeeList employeeList = new EmployeeList();
            BloodList bloodList = new BloodList();
            Login r2 = new Login(employeeList, bloodList);
            r2.setVisible(true);
            this.setVisible(false);
        }

    }

}
