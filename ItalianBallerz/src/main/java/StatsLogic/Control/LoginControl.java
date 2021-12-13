package StatsLogic.Control;

/* La classe deve essere resa singleton per gestire il numero degli ID degli utenti*/

import StatsLogic.Entity.PlayerUser;

import java.util.List;

public class LoginControl {
    private static int PlayerID = 0;
    private List<PlayerUser> PlayerInst;

    public static int getPlayerID() {
        return PlayerID;
    }

    private static void addPlayerUser(String name) {
        PlayerUser p = new PlayerUser(name, ++PlayerID);
    }
    public PlayerUser searchUser(int ID){
        int i;
        PlayerUser p = null;
        boolean flag = false;

        for(i=0;i<PlayerInst.size();i++)
        {
            PlayerUser actual = PlayerInst.get(i);
            if(actual.getID() == ID){
                p = actual;
                flag = true;
                break;
            }
        }

        if(flag)
        {
            p = new PlayerUser("nome",ID);
        }


        return p;
    }
}
