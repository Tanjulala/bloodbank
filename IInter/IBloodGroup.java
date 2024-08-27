package IInter;

import emManage.*;
import entity.*;
import java.lang.*;

public interface IBloodGroup {

    void addBlood(BloodGroup a);

    void removeBlood(BloodGroup a);

    BloodGroup getBloodGroup(String Bd_g);

    void showDetails();

}
