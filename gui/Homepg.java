package gui;

import java.lang.*;
import javax.swing.*;

import emManage.BloodList;
import emManage.EmployeeList;
import entity.BloodGroup;
import entity.Employee;

import java.awt.*;
import java.awt.event.*;

public class Homepg extends JFrame implements ActionListener {

    JLabel userLabel, passLabel, imgLabel;
    JTextField userTF;
    JPasswordField passPF;
    ImageIcon img;
    JButton loginBtn, exitBtn, inv, em, h;
    JRadioButton r1, r2, r3;
    JCheckBox c1, c2, c3;
    ButtonGroup bg1;
    JComboBox combo;
    JPanel panel, bpanel, cpanel;
    Color mycolor;
    Font myFont;
    EmployeeList employeeList;
    BloodList bloodList;

    public Homepg(EmployeeList employeeList, BloodList bloodList) {

        super("Lifeline Blood Bank ");
        this.setBounds(200, 30, 1150, 750);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.employeeList = employeeList;
        this.bloodList = bloodList;

        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("resources/gg.png"));
        this.setIconImage(logo.getImage());
        JLabel ob = new JLabel(logo);
        ob.setBounds(0, 0, 64, 70);

        mycolor = new Color(10, 150, 225);
        Color mycolor2 = new Color(175, 175, 255);
        Color mycolor3 = new Color(175, 175, 175);
        myFont = new Font("Times New Roman", Font.BOLD, 18);
        Font myFont2 = new Font("Arial", Font.BOLD, 16);
        Font myFont3 = new Font("Arial", Font.PLAIN, 27);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.pink);

        JLabel user = new JLabel("ADMIN PAGE >>> ");
        user.setBounds(10, 560, 290, 40);
        user.setBackground(Color.black);
        user.setOpaque(false);
        user.setForeground(Color.black);
        user.setFont(myFont3);
        panel.add(user);

        // button//////////////////////////////////

        em = new JButton("Employee Info");
        em.setBackground(mycolor3);
        em.setForeground(Color.black);
        em.setFont(myFont2);
        em.setBounds(300, 605, 150, 40);
        em.addActionListener(this);
        panel.add(em);

        inv = new JButton("Inventory");
        inv.setBackground(mycolor);
        inv.setForeground(Color.black);
        inv.setFont(myFont2);
        inv.setBounds(510, 605, 150, 40);
        inv.addActionListener(this);
        panel.add(inv);

        h = new JButton("History");
        h.setBackground(Color.red);
        h.setForeground(Color.black);
        h.setFont(myFont2);
        h.setBounds(710, 605, 150, 40);
        h.addActionListener(this);
        panel.add(h);

        exitBtn = new JButton("Logout");
        exitBtn.setBounds(1020, 660, 90, 35);
        exitBtn.setFont(myFont2);
        exitBtn.setBackground(mycolor);
        exitBtn.setForeground(Color.white);
        exitBtn.addActionListener(this);
        panel.add(exitBtn);

        // image/////////////////////////////
        img = new ImageIcon("resources/h.png");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, 1140, 555);
        panel.add(imgLabel);

        this.add(panel);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(em)) {

            Employee a = new Employee("Tanjila", 26, "Female", 101, 1200000, "01700833263", "Blood Collector");
            Employee a2 = new Employee("Sadiaa", 25, "Female", 102, 200000, "01700833264", "Lab Technician");
            Employee a4 = new Employee("Akib", 30, "Male", 103, 2900000, "01700833264", "Blood Doctor");
            Employee ap = new Employee("Samia", 27, "Female", 104, 2800000, "01700833264", "Quality Checker");
            Employee a8 = new Employee("Rehmu", 23, "Female", 105, 200000, "01700833264", "Transfusion Specialist");

            // Add employees to the EmployeeList
            employeeList.addEmployee(a);
            employeeList.addEmployee(a2);
            employeeList.addEmployee(a4);
            employeeList.addEmployee(ap);
            employeeList.addEmployee(a8);
            employeeList.showInfo();

            // Pass employeeList to EmployeeFrame constructor
            EmployeeFrame ob = new EmployeeFrame(employeeList, bloodList);
            ob.setVisible(true);
            this.setVisible(false);

        } else if (ae.getSource().equals(inv)) {

            Inventory in = new Inventory(bloodList);
            in.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource().equals(h)) {

            History his = new History();
            his.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource().equals(exitBtn)) {
            ALogin l = new ALogin(employeeList, bloodList);
            l.setVisible(true);
            this.setVisible(false);

        }
    }

}
