package Logic.Control;

/* La classe deve essere resa singleton per gestire il numero degli ID degli utenti*/

import Logic.Entity.PlayerUser;
import Logic.Other.SingletonPlayer;

public class LoginControl{
    public void writePlayerUser(String name, String password)
    {
        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\log.txt";
        FileManager fm = new FileManager(path);
        fm.writeAppendE(name + "$" + password );
    }

    public Boolean searchUser(String user,String password){
        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\log.txt";

        String name;
        String psw;
        boolean b = false;

        FileManager fm = new FileManager(path);

        while(!fm.checkEnd()) {
            name = fm.readLine();

            psw = name.substring(name.indexOf("$")+1);
            name = name.substring(0,name.indexOf("$"));
            System.out.println(name + " " + psw);
            if(name.compareTo(user) == 0 && psw.compareTo(password) == 0){
                PlayerUser.setUsername(user);
                SingletonPlayer.getLoginInstance();
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
        } catch (NullPointerException n) {
        }
        return s;
    }

    public static void logOut(){
        SingletonPlayer sp = SingletonPlayer.getLoginInstance();
        try{
            sp.deleteInstance();
        } catch (NullPointerException n) {
        }
    }

}
