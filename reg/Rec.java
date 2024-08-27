package reg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import entity.ReceiverEntity; // Import ReceiverEntity class
import java.text.SimpleDateFormat;
import java.util.Date;
import receiver.*;

public class Rec extends Base {

    private JButton addReceiverButton;
    private JButton receiverHistoryButton;

    public Rec() {
        super("Blood Receiver Management");
        setSize(1200, 730);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Load the background image
                    Image backgroundImage = ImageIO.read(new File("./resources/2706868.jpg"));
                    // Draw the background image
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        panel.setLayout(null);
        add(panel);

        // Headline label
        JLabel titleLabel = new JLabel("Blood Receiver");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(450, 50, 300, 50);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        // Centered buttons
        addReceiverButton = new JButton("Add Receiver");
        addReceiverButton.setBounds(500, 300, 200, 50);
        panel.add(addReceiverButton);

        receiverHistoryButton = new JButton("Receiver History");
        receiverHistoryButton.setBounds(500, 400, 200, 50);
        panel.add(receiverHistoryButton);

        addReceiverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open AddReceiverFrame
                new AddReceiverFrame().setVisible(true);

                // Create a ReceiverEntity object and save to file
                String id = generateId(); // You need to implement this method to generate unique IDs
                String name = ""; // Get name from AddReceiverFrame
                String fatherName = ""; // Get father's name from AddReceiverFrame
                String motherName = ""; // Get mother's name from AddReceiverFrame
                String dob = ""; // Get date of birth from AddReceiverFrame
                String mobileNo = ""; // Get mobile number from AddReceiverFrame
                String gender = ""; // Get gender from AddReceiverFrame
                String email = ""; // Get email from AddReceiverFrame
                String bloodGroup = ""; // Get blood group from AddReceiverFrame
                String city = ""; // Get city from AddReceiverFrame
                String address = ""; // Get address from AddReceiverFrame

                // Create ReceiverEntity object
                ReceiverEntity receiver = new ReceiverEntity(id, name, fatherName, motherName, dob, mobileNo, gender,
                        email, bloodGroup, city, address);
                try {
                    // Save receiver details to file
                    receiver.saveToFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    // Handle exception
                }
            }
        });

        receiverHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReceiverHistoryFrame().setVisible(true);
            }
        });
    }

    // Method to generate unique IDs (You need to implement this)
    private String generateId() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return "R" + dateFormat.format(new Date());
    }

}
