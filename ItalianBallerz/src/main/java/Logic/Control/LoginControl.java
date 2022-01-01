package logic.control;

/* La classe deve essere resa singleton per gestire il numero degli ID degli utenti*/

import logic.entity.PlayerUser;
import logic.other.SingletonPlayer;

public class LoginControl{
    public void writePlayerUser(String name, String password,String email,Boolean owner)
    {
        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\";
        if(owner)
            path = path + "owner.txt";
        else
            path = path + "log.txt";

        FileManager fm = new FileManager(path);
        fm.writeAppendE(name + "$" + password + "%" + email);
    }

    public Boolean searchUser(String user,String password,Boolean owner){
        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\";

        if(owner)
            path = path + "owner.txt";
        else
            path = path + "log.txt";


        String name;
        String psw;
        boolean b = false;

        FileManager fm = new FileManager(path);

        while(!fm.checkEnd()) {
            name = fm.readLine();

            psw = name.substring(name.indexOf("$")+1, name.indexOf("%"));
            name = name.substring(0,name.indexOf("$"));
            System.out.println(name + " " + psw);
            if(name.compareTo(user) == 0 && psw.compareTo(password) == 0){
                PlayerUser.setUsernameP(user);
                PlayerUser.setOwner(owner);
                SingletonPlayer.getLoginInstance();
                b = true;
                break;
            }
        }
        return b;
    }


    public Boolean searchUserU(String user,Boolean owner){
        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\";
        String name;
        boolean b = false;

        if(owner)
            path = path + "owner.txt";
        else
            path = path + "log.txt";



        FileManager fm = new FileManager(path);

        while(!fm.checkEnd()) {
            name = fm.readLine();
            name = name.substring(0,name.indexOf("$"));
            if(name.compareTo(user) == 0){
                b = true;
                break;
            }
        }
        return b;
    }



    public String getUsername(){
        SingletonPlayer sp = SingletonPlayer.getLoginInstance();
        String s = null;
        try{
            s = sp.getUsername();
        } catch (NullPointerException ignored) {
        }
        return s;
    }

    public static void logOut(){
        SingletonPlayer sp = SingletonPlayer.getLoginInstance();
        try{
            sp.deleteInstance();
        } catch (NullPointerException ignored) {
        }
    }

}
