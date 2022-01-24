package logic.control;

/* La classe deve essere resa singleton per gestire il numero degli ID degli utenti*/

import logic.entity.PlayerUser;
import logic.other.CourtConst;
import logic.other.SingletonPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoginControl{
    public void writePlayerUser(String name, String password,String email,Boolean owner) throws FileNotFoundException {
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath() + "\\src\\main\\java\\data" + File.separator;
        if(owner)
            path = path + "owner.txt";
        else
            path = path + "log.txt";


        FileManager fm = new FileManager(path);
        fm.writeAppendE(name + "$" + password + "%" + email);
    }

    public Boolean searchUser(String user,String password,Boolean owner){
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath() + "\\src\\main\\java\\data" + File.separator;

        if(owner)
            path = path + "owner.txt";
        else
            path = path + "log.txt";


        String name;
        String psw;
        boolean b = false;

        FileManager fm = new FileManager(path);

        try {
            while (!fm.checkEnd()) {
                name = fm.readLine();

                psw = name.substring(name.indexOf("$") + 1, name.indexOf("%"));
                name = name.substring(0, name.indexOf("$"));
                System.out.println(name + " " + psw);
                if (name.compareTo(user) == 0 && psw.compareTo(password) == 0) {
                    PlayerUser.setUsernameP(user);
                    PlayerUser.setOwner(owner);
                    SingletonPlayer.getLoginInstance();
                    b = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return b;
    }


    public Boolean searchUserU(String user,boolean owner){
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath() + File.separator + "src\\main\\java\\data" + File.separator;
        String name;
        boolean b = false;

        if(owner)
            path = path + CourtConst.getOWNER();
        else
            path = path + CourtConst.getLOG();



        FileManager fm = new FileManager(path);

        try {
            while (!fm.checkEnd()) {
                name = fm.readLine();
                name = name.substring(0, name.indexOf("$"));
                if (name.compareTo(user) == 0) {
                    b = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return b;
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
