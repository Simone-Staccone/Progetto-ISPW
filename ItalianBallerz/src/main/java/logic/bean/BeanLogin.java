package logic.bean;

import logic.control.LoginControl;
import logic.other.SingletonPlayer;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;

public class BeanLogin {
    private BeanLogin(){
    }

    public static int verifyUser(String username, String password,Boolean owner)
    {
        LoginControl lg = new LoginControl();
        int ret  = 0;
        boolean b = false;

        if(username.compareTo("") == 0)
        {
            Logger log = Logger.getRootLogger();
            log.debug("Empty username!");
            ret = -1;
        }
        else if(password.compareTo("") == 0)
        {
            Logger log = Logger.getRootLogger();
            log.debug("Empty password!");
            ret = -2;
        }
        else{
            try{
                b = lg.searchUserU(username,owner);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(!b)
            {
                Logger log = Logger.getRootLogger();
                log.debug("User not found!");
                ret = 1;
            }
            else
            {
                b = lg.searchUser(username,password,owner);
                if(b){
                    Logger log = Logger.getRootLogger();
                    log.debug("User found!");
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
                try {
                    lg.writePlayerUser(user,password,email,owner);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
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
