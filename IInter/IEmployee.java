package IInter;

import emManage.*;
import entity.*;
import java.lang.*;

public interface IEmployee {

    public abstract void addEmployee(Employee a);

    void removeEmployee(Employee a);

    Employee getEmployee(int emp_Id);

    void showInfo();

}
