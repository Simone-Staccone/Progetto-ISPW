package logic.bean;

import logic.control.LoginControl;
import logic.other.SingletonPlayer;

public class BeanLogin {
    public static int verifyUser(String Username, String Password,Boolean owner)
    {
        LoginControl lg = new LoginControl();
        int ret  = 0;
        Boolean b = false;

        if(Username.compareTo("") == 0)
        {
            System.out.println("Empty username");
            ret = -1;
        }
        else if(Password.compareTo("") == 0)
        {
            System.out.println("Empty password");
            ret = -2;
        }
        else{
            try{
                b = lg.searchUserU(Username,owner);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(!b)
            {
                System.out.println("User not found");
                ret = 1;
            }
            else
            {
                b = lg.searchUser(Username,Password,owner);
                if(b){
                    System.out.println("User found!");
                    ret = 2;
                }
            }

        }
        return ret;
    }

    public static int addUser(String user,String password,String passwordConf,String email,Boolean owner){
        int b = 0;
        if(user.compareTo("") == 0 || password.compareTo("") == 0 ||
                passwordConf.compareTo("") == 0 || email.compareTo("") == 0){
            b = -1;
        }
        else if(password.compareTo(passwordConf) != 0)
        {
            b = 1;
        }
        else{
            LoginControl lg = new LoginControl();
            if(!lg.searchUserU(user,owner))
            {
                lg.writePlayerUser(user,password,email,owner);
                b = 2;
            }
        }
        return b;
    }

    public static String getUsername(){
        LoginControl lg = new LoginControl();
        return lg.getUsername();
    }

    public static void logOut(){
        LoginControl.logOut();
    }
    public static Boolean isOwner(){
        SingletonPlayer sp = SingletonPlayer.getLoginInstance();
        return sp.getOwner();
    }


}
