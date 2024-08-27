package emManage;

import IInter.*;
import java.lang.*;
import entity.*;

public class EmployeeList implements IEmployee {

    Employee employees[] = new Employee[100];

    public EmployeeList() {
    };

    public void addEmployee(Employee a) {
        int flag = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = a;
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("Added");
        } else {
            System.out.println("Can Not Added ");
        }
    }

    public void removeEmployee(Employee a) {

        int flag = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == a) {

                employees[i] = null;
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("-----------Removed-------------------");
        } else {
            System.out.println("-------Can Not Removed---------------");
        }

    }

    public Employee getEmployee(int emp_Id) {
        Employee a = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getEmpId() == emp_Id) {
                    a = employees[i];
                    break;
                }
            }
        }
        return a;
    }

    public void showInfo() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println("----------------------------");
                employees[i].showInfo();
                System.out.println();
            }
        }
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public void setAllEmployees(Employee[] employees2) {
        employees = employees2;
    }

}
