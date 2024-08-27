package entity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiverEntity {
    private String id;
    private String name;
    private String fatherName;
    private String motherName;
    private String dob;
    private String mobileNo;
    private String gender;
    private String email;
    private String bloodGroup;
    private String city;
    private String address;

    // Constructor
    public ReceiverEntity(String id, String name, String fatherName, String motherName, String dob,
            String mobileNo, String gender, String email, String bloodGroup,
            String city, String address) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.dob = dob;
        this.mobileNo = mobileNo;
        this.gender = gender;
        this.email = email;
        this.bloodGroup = bloodGroup;
        this.city = city;
        this.address = address;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getDob() {
        return dob;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    // Save receiver details to file
    public void saveToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("receivers.txt", true))) {
            writer.write(String.join(",", id, name, fatherName, motherName, dob, mobileNo, gender, email, bloodGroup,
                    city, address));
            writer.newLine();
        }
    }
}
