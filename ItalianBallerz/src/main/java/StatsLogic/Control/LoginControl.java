package StatsLogic.Control;

/* La classe deve essere resa singleton per gestire il numero degli ID degli utenti*/

import StatsLogic.Entity.PlayerUser;

import java.util.ArrayList;
import java.util.List;

public class LoginControl {
    private static int PlayerID = 0;
    private List<PlayerUser> PlayerInst = new ArrayList<>();
    private int actual = 0;


    public LoginControl(){
        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\log.txt";

        StringBuilder buffer = new StringBuilder();
        String s;

        FileManager fm = new FileManager(path);

        while(!fm.checkEnd()) {
            buffer.delete(0,buffer.length());
            buffer.append(fm.readLine());
            s = buffer.toString();

            addPlayerUser(s.substring(0,s.indexOf("$")),s.substring(s.indexOf("$")));
        }
    }


    private void addPlayerUser(String name,String password) {
        PlayerUser p = new PlayerUser(name, password.substring(1));
        PlayerInst.add(p);
    }

    public String getUser()
    {
        String s;
        s = PlayerInst.get(actual).getName();
        actual++;
        return s;
    }


    public void writePlayerUser(String name,String password)
    {
        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\log.txt";

        FileManager fm = new FileManager(path);

        fm.writeAppend(name + "$" + password );
    }

    public PlayerUser searchUser(String name,String password){
        int i;
        PlayerUser p = null;
        boolean flag = false;
        PlayerUser actual = new PlayerUser("","");
        for(i=0;i<PlayerInst.size();i++)
        {
            actual = PlayerInst.get(i);
            if(actual.getName().compareTo(name) == 0){
                p = actual;
                flag = true;
                break;
            }
        }

        if(actual.getPassword().compareTo(password) == 0)
        {
            System.out.println("Verified");
        }
        else
            System.out.println("Wrong"+actual.getPassword()+password);
        if(flag)
        {
            p = new PlayerUser("nome","psw");
        }


        return p;
    }
}
