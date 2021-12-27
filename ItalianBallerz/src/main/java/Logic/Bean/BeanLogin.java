package Logic.Bean;

import Logic.Control.LoginControl;
import Logic.Other.SingletonPlayer;

public class BeanLogin {
    public static Boolean verifyUser(String Username, String Password)
    {
        LoginControl lg = new LoginControl();
        Boolean b = false;

        if(Username.compareTo("") == 0)
        {
            System.out.println("Empty username");
        }
        else if(Password.compareTo("") == 0)
        {
            System.out.println("Empty password");
        }
        else{
            try{
                b = lg.searchUser(Username,Password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(!b)
            {
                System.out.println("User not found");
            }
            else
            {
                System.out.println("User found!");
            }

        }
        return b;
    }

    public static void addUser(String user,String password){
        LoginControl lg = new LoginControl();
        if(!lg.searchUser(user,password))
        {
            lg.writePlayerUser(user,password);
        }
    }

    public static String getUsername(){
        LoginControl lg = new LoginControl();
        return lg.getUsername();
    }

    public static void logOut(){
        LoginControl lg = new LoginControl();
        lg.logOut();
    }
}
