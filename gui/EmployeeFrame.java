package gui;

import entity.*;
import emManage.*;
import javax.swing.*;
import javax.swing.table.*;
import IInter.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class EmployeeFrame extends JFrame implements ActionListener {

    JLabel userLabel, passLabel, imgLabel, userLabel2, userLabel3, userLabel4, userLabel5, userLabel6, userg, admin;
    JTextField userTF, userTF2, userage, users, usernum;
    JPasswordField passPF;
    ImageIcon img;
    JButton loginBtn, hBtn, exitBtn, homBtn, addBtn, cBtn, updBtn, dBtn, iBtn;
    JRadioButton r1, r2, r3;
    JCheckBox c1, c2, c3;
    ButtonGroup bg1;
    JComboBox combo;
    JPanel panel, bpanel, cpanel;
    Color mycolor, mycolor2, mycolor3;
    Font myFont, myFont2, myFont3, myFont4;
    JTable table;
    DefaultTableModel model;
    EmployeeList emp;
    BloodList bloodList;

    public EmployeeFrame(EmployeeList emp, BloodList bloodList) {

        super("Employee Details ");
        this.setBounds(200, 30, 1200, 730);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.emp = emp;
        this.bloodList = bloodList;

        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("resources/gg.png"));
        this.setIconImage(logo.getImage());
        JLabel ob = new JLabel(logo);
        ob.setBounds(0, 0, 64, 70);

        mycolor = new Color(128, 175, 175);
        mycolor2 = new Color(192, 192, 192);
        mycolor3 = new Color(175, 175, 225);
        myFont = new Font("Arial", Font.PLAIN + Font.BOLD, 31);
        myFont2 = new Font("Arial", Font.BOLD, 20);
        myFont3 = new Font("Times New Roman", Font.PLAIN + Font.BOLD, 22);
        myFont4 = new Font("Arial", Font.BOLD, 18);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(mycolor);

        bpanel = new JPanel();
        bpanel.setLayout(null);
        bpanel.setBackground(mycolor);
        bpanel.setBounds(470, 20, 500, 400);

        cpanel = new JPanel();
        cpanel.setLayout(null);
        cpanel.setBackground(mycolor);
        cpanel.setBounds(950, 20, 200, 400);

        this.add(cpanel);
        this.add(bpanel);
        this.add(panel);

        initializeForm();
        createTable();
        loadEmployeeData();
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                int numberofRow = table.getSelectedRow();

                String uId = model.getValueAt(numberofRow, 0).toString();
                String uName = model.getValueAt(numberofRow, 1).toString();
                String uageText = model.getValueAt(numberofRow, 2).toString();
                String up = model.getValueAt(numberofRow, 3).toString();
                String ugender = model.getValueAt(numberofRow, 3).toString();
                String ucnum = model.getValueAt(numberofRow, 4).toString();
                String usalText = model.getValueAt(numberofRow, 5).toString();

                userTF2.setText(uId);
                userTF.setText(uName);
                userage.setText(uageText);
                combo.setSelectedItem(up);
                if (ugender.equals("Male")) {
                    r1.setSelected(true);
                } else if (ugender.equals("Female")) {
                    r2.setSelected(true);
                }
                usernum.setText(ucnum);
                users.setText(usalText);
            }
        });
    }

    private void initializeForm() {
        JLabel user = new JLabel("             EMPLOYEE  INFORMATION ");
        user.setBounds(80, 5, 400, 40);
        user.setBackground(Color.white);
        user.setOpaque(false);
        user.setForeground(Color.black);
        user.setFont(myFont2);
        bpanel.add(user);

        userLabel = new JLabel("Employee Name: ");
        userLabel.setBounds(5, 63, 190, 40);
        userLabel.setBackground(Color.white);
        userLabel.setOpaque(false);
        userLabel.setForeground(Color.white);
        userLabel.setFont(myFont2);
        bpanel.add(userLabel);

        userTF = new JTextField();
        userTF.setBounds(200, 63, 220, 40);
        userTF.setBackground(Color.WHITE);
        // userTF.setFont(myFont2);
        bpanel.add(userTF);

        userLabel2 = new JLabel("Employee ID: ");
        userLabel2.setBounds(5, 110, 190, 40);
        userLabel2.setBackground(Color.white);
        userLabel2.setOpaque(false);
        userLabel2.setForeground(Color.white);
        userLabel2.setFont(myFont2);
        bpanel.add(userLabel2);

        userTF2 = new JTextField();
        userTF2.setBounds(200, 110, 220, 40);
        userTF2.setBackground(Color.WHITE);
        bpanel.add(userTF2);

        userLabel3 = new JLabel("Employee age: ");
        userLabel3.setBounds(5, 160, 190, 40);
        userLabel3.setBackground(Color.white);
        userLabel3.setOpaque(false);
        userLabel3.setForeground(Color.white);
        userLabel3.setFont(myFont2);
        bpanel.add(userLabel3);

        userage = new JTextField();
        userage.setBounds(200, 160, 220, 40);
        userage.setBackground(Color.WHITE);
        bpanel.add(userage);

        userLabel4 = new JLabel("Employee Salary: ");
        userLabel4.setBounds(5, 210, 190, 40);
        userLabel4.setBackground(Color.white);
        userLabel4.setOpaque(false);
        userLabel4.setForeground(Color.white);
        userLabel4.setFont(myFont2);
        bpanel.add(userLabel4);

        users = new JTextField();
        users.setBounds(200, 210, 220, 40);
        users.setBackground(Color.WHITE);
        bpanel.add(users);

        userLabel5 = new JLabel("Contact Number: ");
        userLabel5.setBounds(5, 260, 190, 40);
        userLabel5.setBackground(Color.white);
        userLabel5.setOpaque(false);
        userLabel5.setForeground(Color.white);
        userLabel5.setFont(myFont2);
        bpanel.add(userLabel5);

        usernum = new JTextField();
        usernum.setBounds(200, 260, 220, 40);
        usernum.setBackground(Color.WHITE);
        bpanel.add(usernum);

        userg = new JLabel("Gender: ");
        userg.setBounds(5, 350, 170, 40);
        userg.setBackground(Color.white);
        userg.setOpaque(false);
        userg.setForeground(Color.white);
        userg.setFont(myFont2);
        bpanel.add(userg);

        r1 = new JRadioButton("Male");
        r1.setOpaque(true);
        r1.setForeground(Color.black);
        r1.setBounds(210, 356, 90, 30);
        bpanel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setOpaque(true);
        r2.setForeground(Color.BLACK);
        r2.setBounds(320, 356, 90, 30);
        bpanel.add(r2);

        bg1 = new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);

        userLabel6 = new JLabel("Position: ");
        userLabel6.setBounds(5, 309, 190, 40);
        userLabel6.setBackground(Color.white);
        userLabel6.setOpaque(false);
        userLabel6.setForeground(Color.white);
        userLabel6.setFont(myFont2);
        bpanel.add(userLabel6);

        String[] items = { " ", "Blood Collector", "Donar Recruitment Coordinator", "Lab Techniaian", "Quality Checker",
                "Tranfusion Specialist", "Blood Doctor" };
        combo = new JComboBox(items);
        combo.setBounds(200, 310, 220, 30);
        bpanel.add(combo);

        // right button////////

        addBtn = new JButton("ADD");
        addBtn.setBounds(50, 100, 90, 30);
        cpanel.add(addBtn);

        updBtn = new JButton("UPDATE");
        updBtn.setBounds(50, 170, 90, 30);
        cpanel.add(updBtn);

        cBtn = new JButton("CLEAR");
        cBtn.setBounds(50, 250, 90, 30);
        cpanel.add(cBtn);

        dBtn = new JButton("DELETE");
        dBtn.setBounds(50, 330, 90, 30);
        cpanel.add(dBtn);

        // left button////////////////////////////////

        admin = new JLabel("        <<ADMIN PAGE>> ");
        admin.setBounds(0, 20, 500, 45);
        admin.setBackground(mycolor);
        admin.setOpaque(true);
        admin.setForeground(Color.black);
        admin.setFont(myFont);
        panel.add(admin);

        homBtn = new JButton("HOME");
        homBtn.setBounds(130, 550, 150, 35);
        homBtn.setFont(myFont4);
        homBtn.setBackground(mycolor);
        homBtn.setForeground(Color.black);
        homBtn.addActionListener(this);
        panel.add(homBtn);

        exitBtn = new JButton("EXIT");
        exitBtn.setBounds(130, 600, 150, 35);
        exitBtn.setFont(myFont4);
        exitBtn.setBackground(mycolor);
        exitBtn.setForeground(Color.black);
        exitBtn.addActionListener(this);
        panel.add(exitBtn);

        // image//////////////////////////////////////////
        img = new ImageIcon("untitled.png");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, 450, 690);
        panel.add(imgLabel);

        addBtn.addActionListener(this);
        updBtn.addActionListener(this);
        cBtn.addActionListener(this);
        dBtn.addActionListener(this);
        users.addActionListener(this);

    }

    private void createTable() {
        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Employee Name");
        model.addColumn("Age");
        model.addColumn("Position");
        model.addColumn("Gender");
        model.addColumn("Contact Number");
        model.addColumn("Salary");

        Employee[] employees = emp.getAllEmployees();

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                model.addRow(new Object[] {
                        employees[i].getEmpId(),
                        employees[i].getName(),
                        employees[i].getAge(),
                        employees[i].getPosition(),
                        employees[i].getGender(),
                        employees[i].getNum(),
                        employees[i].getEmpSalary(),

                });
            }

        }

        table = new JTable(model);
        table.setSelectionBackground(new Color(175, 175, 175));
        table.setBounds(470, 440, 700, 200);
        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBounds(470, 440, 700, 200);
        panel.add(scrollPane);

    }

    public void clearAll() {
        userTF.setText("");
        userTF2.setText("");
        userage.setText("");
        users.setText("");
        usernum.setText("");
        combo.setSelectedIndex(0);
        bg1.clearSelection();
    }

    private void loadEmployeeData() {
        try (BufferedReader br = new BufferedReader(new FileReader("empInfo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] employeeData = line.split(",");
                model.addRow(employeeData);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading employee data from file", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn) {
            String eId = userTF2.getText();
            String eName = userTF.getText();
            String eageText = userage.getText();
            String p = (String) combo.getSelectedItem();
            String egender = "";
            if (r1.isSelected()) {
                egender = "Male";
            } else if (r2.isSelected()) {
                egender = "Female";
            }
            String cnum = usernum.getText();
            String salText = users.getText();

            if (eId.isEmpty() || eName.isEmpty() || eageText.isEmpty() || p.isEmpty() || egender.isEmpty()
                    || cnum.isEmpty() || salText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill out all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int eage = Integer.parseInt(eageText);
                    int sal = Integer.parseInt(salText);
                    int empId = Integer.parseInt(eId);

                    if (sal < 0 || eage < 0) {
                        JOptionPane.showMessageDialog(this, "Age and salary must be positive integers.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        Employee m = new Employee(eName, eage, egender, empId, sal, cnum, p);
                        emp.addEmployee(m);

                        String data = m.getEmpId() + "," + m.getName() + "," + m.getAge() + "," + m.getPosition() + ","
                                + m.getGender() + "," + m.getNum() + "," + m.getEmpSalary();

                        try {
                            File file = new File("empInfo.txt");
                            if (!file.exists()) {
                                file.createNewFile();
                            }

                            FileWriter fw = new FileWriter(file, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.append(data);
                            bw.newLine();
                            bw.close();
                        } catch (IOException e) {
                            System.out.println(e);
                        }

                        model.addRow(new Object[] {
                                m.getEmpId(),
                                m.getName(),
                                m.getAge(),
                                m.getPosition(),
                                m.getGender(),
                                m.getNum(),
                                m.getEmpSalary()
                        });
                        clearAll();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid age,id or salary format. Please enter valid integers.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (ae.getSource() == cBtn) {

            clearAll();

        } else if (ae.getSource() == dBtn) {
            int selectedRows[] = table.getSelectedRows();
            if (selectedRows.length >= 1) {
                Arrays.sort(selectedRows);

                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    int emId = Integer.parseInt(table.getModel().getValueAt(selectedRows[i], 0).toString());
                    Employee a = emp.getEmployee(emId);
                    if (a != null) {
                        model.removeRow(selectedRows[i]);
                        emp.removeEmployee(a);
                        try {
                            File file = new File("empInfo.txt");
                            FileWriter fw = new FileWriter(file, true);
                            BufferedWriter bw = new BufferedWriter(fw);

                            bw.append("Employee ID: " + emId + " was deleted.\n");

                            bw.close();

                            System.out.println("Employee with ID " + emId + " was successfully deleted from the file.");

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                    if (i == 0) {

                        JOptionPane.showMessageDialog(this, "Successfully Deleted.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Select Rows to Delete. ", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else if (ae.getSource() == updBtn) {
            int numberofRow = table.getSelectedRow();
            if (numberofRow != -1) {
                String uId = userTF2.getText();
                String uName = userTF.getText();
                String uageText = userage.getText();
                String up = (String) combo.getSelectedItem();
                String ugender = "";
                if (r1.isSelected()) {
                    ugender = "Male";
                } else if (r2.isSelected()) {
                    ugender = "Female";
                }
                String ucnum = usernum.getText();
                String usalText = users.getText();

                // Update table model
                model.setValueAt(uId, numberofRow, 0);
                model.setValueAt(uName, numberofRow, 1);
                model.setValueAt(uageText, numberofRow, 2);
                model.setValueAt(up, numberofRow, 3);
                model.setValueAt(ugender, numberofRow, 4);
                model.setValueAt(ucnum, numberofRow, 5);
                model.setValueAt(usalText, numberofRow, 6);

                try {
                    File file = new File("empInfo.txt");
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    String data = uId + "," + uName + "," + uageText + "," + up + "," + ugender + "," + ucnum + ","
                            + usalText;
                    bw.append(data);
                    bw.newLine();
                    bw.close();

                    System.out.println("Data updated successfully.");
                    JOptionPane.showMessageDialog(this, "Data updated successfully");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to update.", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
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
