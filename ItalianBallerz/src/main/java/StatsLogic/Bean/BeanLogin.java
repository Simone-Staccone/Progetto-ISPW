package StatsLogic.Bean;

import StatsLogic.Control.LoginControl;
import StatsLogic.Entity.PlayerUser;

public class BeanLogin {
    public static void verifyUser(String Username, String Password)
    {
        LoginControl lg = new LoginControl();
        PlayerUser p = null;
        try{
            p = lg.searchUser(Username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(p == null)
        {
            System.out.println("User not found");
        }
        else
        {
            System.out.println("User found!");
        }
    }
}
