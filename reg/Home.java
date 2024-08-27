package reg;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame {

    Container c;
    ImageIcon icon, logo;
    JLabel label1, imgLabel;
    Font f1, f2;
    JButton btn1, btn2, btn3, btn4, nBtn;
    Cursor cursor;

    public Home() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Blood Donation System");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("images/blood-drop.png"));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource("images/blood-drop.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(30, 82, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);

        // Fonts
        f1 = new Font("Tahoma", Font.BOLD, 48);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Title
        label1 = new JLabel();
        label1.setText("Give Blood");
        label1.setBounds(420, 55, 500, 65);
        label1.setFont(f1);
        c.add(label1);

        label1 = new JLabel();
        label1.setText("Save Life");
        label1.setBounds(420, 120, 500, 65);
        label1.setFont(f1);
        c.add(label1);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Refresh");
        btn1.setBounds(418, 214, 195, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2E75B6"));
        c.add(btn1);

        btn2 = new JButton("Register");
        btn2.setBounds(634, 214, 195, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        c.add(btn2);

        btn3 = new JButton("Exit");
        btn3.setBounds(418, 288, 195, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#C00000"));
        c.add(btn3);

        btn4 = new JButton("Donor Login");
        btn4.setBounds(634, 288, 195, 50);
        btn4.setFont(f2);
        btn4.setCursor(cursor);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#2E75B6"));
        c.add(btn4);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Refresh
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                setVisible(true);
            }
        });

        // Register
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                Registration frame = new Registration();
                frame.setVisible(true);
                setVisible(false);
            }
        });

        // Exit
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Admin Login
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                DLogin frame = new DLogin();
                frame.setVisible(true);

            }
        });
    }

}
