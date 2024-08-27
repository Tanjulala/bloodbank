package reg;

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

public class Cover extends JFrame implements ActionListener {
    JLabel imgLabel, user, userLabel, user2, user3, userLabel2;
    ImageIcon img;
    JButton nextBtn;
    JPanel panel;
    Color mycolor, mycolor2;
    Font myFont, myFont2, myFont3;

    public Cover() {
        super("Lifeline Blood Bank ");

        this.setBounds(480, 150, 630, 460);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("resources/gg.png"));
        this.setIconImage(logo.getImage());
        JLabel ob = new JLabel(logo);
        ob.setBounds(0, 0, 64, 70);

        mycolor = new Color(10, 150, 225);
        Font myFont = new Font("Arial", Font.BOLD, 14);
        Font myFont2 = new Font("Arial", Font.BOLD, 31);
        Font myFont3 = new Font("Arial", Font.BOLD, 21);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.red);

        JLabel userLabel2 = new JLabel(" +Lifeline Blood Bank >>");
        userLabel2.setBounds(0, 370, 500, 40);
        userLabel2.setOpaque(false);
        userLabel2.setForeground(Color.black);
        userLabel2.setFont(myFont3);
        panel.add(userLabel2);

        userLabel = new JLabel("   ''BE A HERO ");
        userLabel.setBounds(0, 20, 400, 300);
        userLabel.setBackground(Color.white);
        userLabel.setOpaque(false);
        userLabel.setForeground(Color.red);
        userLabel.setFont(myFont2);
        panel.add(userLabel);

        user = new JLabel("        BE A DONAR''");
        user.setBounds(10, 90, 400, 300);
        user.setBackground(Color.white);
        user.setOpaque(false);
        user.setForeground(Color.gray);
        user.setFont(myFont2);
        panel.add(user);

        img = new ImageIcon("resources/co.jpg");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, 639, 360);
        panel.add(imgLabel);

        nextBtn = new JButton("Continue");
        nextBtn.setBounds(490, 375, 100, 35);
        nextBtn.setFont(myFont);
        nextBtn.setForeground(Color.black);
        nextBtn.addActionListener(this);
        panel.add(nextBtn);

        this.add(panel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == nextBtn) {

            EmployeeList employeeList = new EmployeeList();
            BloodList bloodList = new BloodList();

            Login r = new Login(employeeList, bloodList);
            r.setVisible(true);
            this.setVisible(false);
        }
    }

}