package entity;

import java.lang.*;

public class Employee extends Person {

    private int emp_Id;
    private int emp_salary;
    private String position;
    private String con_num;

    public Employee() {
    }

    public Employee(String name, int age, String gender, int emp_Id, int emp_salary, String con_num, String position) {

        super(name, age, gender);
        this.emp_Id = emp_Id;
        this.emp_salary = emp_salary;
        this.position = position;
        this.con_num = con_num;
    }

    public void setEmpId(int emp_Id) {

        this.emp_Id = emp_Id;
    }

    public int getEmpId() {
        return emp_Id;
    }

    public void setEmpSalary(int emp_salary) {
        this.emp_salary = emp_salary;
    }

    public int getEmpSalary() {
        return emp_salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setNum(String con_num) {
        this.con_num = con_num;
    }

    public String getNum() {
        return con_num;
    }

    public void showInfo() {

        System.out.println("Id: " + getEmpId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Salary: " + getEmpSalary());
        System.out.println("Contact Number: " + getNum());
        System.out.println("Position: " + getPosition());
    }
}
