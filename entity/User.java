package entity;

import java.lang.*;

public class User extends Person {

    private String role;
    private String dob;

    public User() {
    }

    public User(String name, int age, String gender, String role, String dob) {

        super(name, age, gender);
        this.role = role;
        this.dob = dob;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void showInfo() {

        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Dob: " + getDob());
        System.out.println("role: " + getRole());
    }
}
