package logic.control;

/* La classe deve essere resa singleton per gestire il numero degli ID degli utenti*/

import logic.entity.PlayerCache;
import logic.entity.PlayerUser;
import logic.other.SingletonPlayer;

import java.io.FileNotFoundException;


public class LoginControl{
    public void writePlayerUser(String name, String password,String email,boolean owner) throws FileNotFoundException {
        PlayerUser pu = new PlayerUser(name,owner);
        pu.writePlayerUser(password,email);
    }

    public boolean searchUser(String user,String password,boolean owner) throws FileNotFoundException {
        PlayerUser pd = new PlayerUser(user,owner);
        boolean b = pd.searchUser(password);
        PlayerCache.setUsername(user);
        PlayerCache.setOwner(owner);
        SingletonPlayer.getLoginInstance();
        return b;
    }


    public boolean searchUserU(String user,boolean owner){
        PlayerUser pu = new PlayerUser(user,owner);
        return pu.searchUserU();
    }



    public String getUsername(){
        SingletonPlayer sp = SingletonPlayer.getLoginInstance();
        String ret = null;
        if(sp != null)
            ret = sp.getUsername();
        return ret;
    }

    public static void logOut(){
        SingletonPlayer.deleteInstance();
    }

}
