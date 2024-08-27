package entity;

import java.lang.*;

public class BloodGroup {

    private String Bd_g;
    private int Bd_Q;
    private String status;

    public BloodGroup(String Bd_g, int Bd_Q, String status) {
        this.Bd_g = Bd_g;
        this.Bd_Q = Bd_Q;
        this.status = status;

    }

    public void setBloodGroup(String Bd_g) {

        this.Bd_g = Bd_g;
    }

    public String getBloodGroup() {
        return Bd_g;
    }

    public void setQuantity(int Bd_Q) {
        this.Bd_Q = Bd_Q;
    }

    public int getQuantity() {
        return Bd_Q;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public String getstatus() {
        return status;
    }

    public void showDetails() {

        System.out.println("Blood Group: " + getBloodGroup());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Expiry status: " + getstatus());

    }

}
