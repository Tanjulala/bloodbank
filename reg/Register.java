package reg;

import gui.*;
import entity.*;
import emManage.*;
import IInter.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static javax.swing.JOptionPane.showMessageDialog;

public class Register extends JFrame implements ActionListener {

    private Container c;
    private JLabel title;
    private ImageIcon img;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel pass;
    private JPasswordField tpass;
    private JLabel role;
    private JRadioButton male, d, r;
    private JRadioButton female;
    private ButtonGroup gengp, uggp;
    private JLabel dob, imgLabel;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JButton login;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    int s = 0;
    EmployeeList employeeList;
    BloodList bloodlList;

    private String dates[] = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[] = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[] = { "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019", "2020" };

    public Register(EmployeeList employeeList, BloodList bloodlList) {

        this.setTitle("Registration Form");
        this.setBounds(350, 100, 900, 660);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("resources/gg.png"));
        this.setIconImage(logo.getImage());
        JLabel ob = new JLabel(logo);
        ob.setBounds(0, 0, 64, 70);

        this.employeeList = employeeList;
        this.bloodlList = bloodlList;

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.lightGray);

        title = new JLabel("       <<Registration Form>>");
        title.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 30));
        title.setOpaque(true);
        title.setForeground(Color.white);
        title.setBackground(Color.gray);
        title.setSize(470, 40);
        title.setLocation(0, 25);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 20));
        name.setSize(100, 30);
        name.setLocation(50, 150);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 15));
        tname.setSize(200, 30);
        tname.setLocation(150, 150);
        c.add(tname);

        pass = new JLabel("Password");
        pass.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 20));
        pass.setSize(100, 30);
        pass.setLocation(50, 200);
        c.add(pass);

        tpass = new JPasswordField();
        tpass.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 15));
        tpass.setSize(200, 30);
        tpass.setLocation(150, 200);
        c.add(tpass);

        role = new JLabel("Role");
        role.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 20));
        role.setSize(100, 20);
        role.setLocation(50, 250);
        c.add(role);

        male = new JRadioButton("Donar");
        male.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(150, 250);
        c.add(male);

        female = new JRadioButton("Reciever");
        female.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 15));
        female.setSelected(false);
        female.setSize(100, 20);
        female.setLocation(235, 250);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("DOB");
        dob.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 20));
        dob.setSize(100, 20);
        dob.setLocation(50, 300);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 15));
        date.setSize(50, 20);
        date.setLocation(150, 300);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 15));
        month.setSize(60, 20);
        month.setLocation(210, 300);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 15));
        year.setSize(60, 20);
        year.setLocation(280, 300);
        c.add(year);

        mno = new JLabel("Mobile");
        mno.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 20));
        mno.setSize(100, 30);
        mno.setLocation(50, 350);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 15));
        tmno.setSize(200, 30);
        tmno.setLocation(150, 350);
        c.add(tmno);

        add = new JLabel("Email");
        add.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 20));
        add.setSize(100, 30);
        add.setLocation(50, 400);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 15));
        tadd.setSize(200, 30);
        tadd.setLocation(150, 400);
        tadd.setLineWrap(true);
        c.add(tadd);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 15));
        term.setSize(280, 20);
        term.setLocation(560, 500);
        term.setForeground(Color.white);
        term.setOpaque(false);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 15));
        sub.setSize(100, 25);
        sub.setLocation(580, 540);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 15));
        reset.setSize(100, 25);
        reset.setLocation(700, 540);
        reset.addActionListener(this);
        c.add(reset);

        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.PLAIN + Font.BOLD, 15));
        login.setSize(100, 25);
        login.setLocation(640, 580);
        login.addActionListener(this);
        c.add(login);

        img = new ImageIcon("resources/user.png");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(470, 0, 664, 660);
        c.add(imgLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sub) {

            if (tname.getText().isEmpty() || tpass.getPassword().length == 0 || tadd.getText().isEmpty()
                    || tmno.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill up all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method to prevent further execution
            }

            String data = "";

            // Get the role
            String role = "Donar";
            if (female.isSelected())
                role = "Receiver";
            data += role + ",";

            // Get other details
            data += tname.getText() + "," + tpass.getText() + ",";
            data += (String) date.getSelectedItem() + "/" + (String) month.getSelectedItem() + "/"
                    + (String) year.getSelectedItem() + ",";
            data += tadd.getText() + "," + tmno.getText();

            try {
                File file = new File("login.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.append(data + "\n"); // Use consistent delimiter
                bw.close();

                JOptionPane.showMessageDialog(this, "Registration Successful! You can now login.");

            } catch (Exception ex) {
                System.out.print(ex);
                JOptionPane.showMessageDialog(this, "Error occurred while registering.");
            }
            tname.setText("");
            tadd.setText("");
            tmno.setText("");
            tpass.setText("");
            gengp.clearSelection();
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);

        }

        else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tadd.setText(def);
            tmno.setText(def);
            tpass.setText(def);
            gengp.clearSelection();
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);

        } else if (e.getSource() == login) {

            Login on = new Login(employeeList, bloodlList);
            on.setVisible(true);
            this.setVisible(false);
        }
    }

}
