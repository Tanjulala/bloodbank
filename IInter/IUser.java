package IInter;

import emManage.*;
import entity.*;
import java.lang.*;

public interface IUser {

    void addCustomer(User a);

    void removeCustomer(User a);

    User getUser(String name);

    void showInfo();

}