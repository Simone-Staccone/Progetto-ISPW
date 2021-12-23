package Logic.Entity;

import java.util.List;

public class PlayerUser {
    private List<Stat> playerstats;
    private static String name;


    public static String getUsername() {
        return PlayerUser.name;
    }
    public static void setUsername(String s) {
        PlayerUser.name = s;
    }

}
