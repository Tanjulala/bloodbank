package reg;

import java.lang.*;
import java.util.Scanner;
import javax.swing.*;
import entity.*;
import emManage.*;
import entity.User;
import gui.*;
import Staff.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Privacy extends JFrame implements ActionListener {
    JLabel imgLabel, user, userLabel, user2, user3;
    ImageIcon img;
    JButton backBtn;
    JPanel panel;
    Color mycolor, mycolor2;
    Font myFont, myFont2, myFont3;

    public Privacy() {
        super("Lifeline Blood Bank ");

        this.setBounds(400, 100, 706, 570);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("resources/gg.png"));
        this.setIconImage(logo.getImage());
        JLabel ob = new JLabel(logo);
        ob.setBounds(0, 0, 64, 70);

        mycolor = new Color(10, 150, 225);
        Font myFont = new Font("Arial", Font.BOLD, 16);
        Font myFont2 = new Font("Arial", Font.BOLD, 31);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);

        user = new JLabel("'' Blood Type Compatibility ''");
        user.setBounds(130, 30, 600, 40);
        user.setBackground(Color.white);
        user.setOpaque(false);
        user.setForeground(Color.black);
        user.setFont(myFont2);
        panel.add(user);

        backBtn = new JButton("Back");
        backBtn.setBounds(300, 490, 90, 30);
        // backBtn.setBackground(mycolor);
        // backBtn.setFont(myFont);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        img = new ImageIcon("resources/info.png");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(60, 60, 549, 416);
        panel.add(imgLabel);

        this.add(panel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backBtn) {

            EmployeeList employeeList = new EmployeeList();
            BloodList bloodList = new BloodList();

            Login ob = new Login(employeeList, bloodList);

            ob.setVisible(true);

            this.setVisible(false);

        }

    }

}