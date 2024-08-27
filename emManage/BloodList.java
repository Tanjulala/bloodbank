package emManage;

import IInter.*;
import java.lang.*;
import entity.*;

public class BloodList implements IBloodGroup {

    BloodGroup bloods[] = new BloodGroup[100];

    public BloodList() {
    }

    public void addBlood(BloodGroup a) {
        int flag = 0;
        for (int i = 0; i < bloods.length; i++) {
            if (bloods[i] == null) {
                bloods[i] = a;
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

    public void removeBlood(BloodGroup a) {

        int flag = 0;
        for (int i = 0; i < bloods.length; i++) {
            if (bloods[i] == a) {

                bloods[i] = null;
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

    public BloodGroup getBloodGroup(String Bd_g) {
        BloodGroup a = null;
        for (int i = 0; i < bloods.length; i++) {
            if (bloods[i] != null) {
                if (bloods[i].getBloodGroup() == Bd_g) {
                    a = bloods[i];
                    break;
                }
            }
        }
        return a;
    }

    public void showDetails() {
        for (int i = 0; i < bloods.length; i++) {
            if (bloods[i] != null) {
                System.out.println("----------------------------");
                bloods[i].showDetails();
                System.out.println();
            }
        }
    }

    public BloodGroup[] getAllBloodGroup() {
        return bloods;
    }

    public void setBloodGroup(BloodGroup[] bloods2) {
        bloods = bloods2;
    }

}
