package logic.bean;

import logic.control.LoginControl;
import logic.other.SingletonPlayer;

import java.io.FileNotFoundException;

/**
 * Classe bean che fa comunicare i controller grafici con le classi control relative alla gestione del login
 */
public class BeanLogin {
    private BeanLogin(){
    }

    public static int verifyUser(String username, String password,Boolean owner) throws FileNotFoundException {
        LoginControl lg = new LoginControl();
        int ret  = 0;
        boolean b = false;

        if(username.compareTo("") == 0)
        {
            ret = -1;
        }
        else if(password.compareTo("") == 0)
        {
            ret = -2;
        }
        else{
            try{
                b = lg.searchUserU(username,owner);
            } catch (Exception e) {
                b = true;
            }
            if(!b)
            {
                ret = 1;
            }
            else
            {
                b = lg.searchUser(username,password,owner);
                if(b){
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
            b = 2;
            LoginControl lg = new LoginControl();
            try {
                if (!lg.searchUserU(user, owner)) {
                    lg.writePlayerUser(user, password, email, owner);
                }
            }catch (FileNotFoundException e) {
                b = 0;
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
