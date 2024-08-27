package emManage;

import IInter.*;
import java.lang.*;
import entity.*;

public class userList implements IUser {

    User users[] = new User[100];

    public userList() {
    };

    public void addCustomer(User a) {
        int flag = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = a;
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

    public void removeCustomer(User a) {

        int flag = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == a) {

                users[i] = null;
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

    public User getUser(String name) {
        User a = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (users[i].getName() == name) {
                    a = users[i];
                    break;
                }
            }
        }
        return a;
    }

    public void showInfo() {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                System.out.println("----------------------------");
                users[i].showInfo();
                System.out.println();
            }
        }
    }

    public User[] getAllusers() {
        return users;
    }

    public void setAllusers(User[] users2) {
        users = users2;
    }

}
