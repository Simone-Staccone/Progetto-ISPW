package logic.entity;

import logic.other.SingletonPlayer;

import java.util.ArrayList;
import java.util.List;

public class PlayerUser extends SingletonPlayer {
    private List<Stat> playerStats = new ArrayList<>();
    private static String name;
    private static Boolean owner;

    protected PlayerUser(String init) {
        super(init,owner);
    }


    public static String getUsernameP() {
        return PlayerUser.name;
    }
    public static void setUsernameP(String s) {
        PlayerUser.name = s;
    }

    public static void setOwner(Boolean owner) {
        PlayerUser.owner = owner;
    }
    public static Boolean getOwnerP() {
        return PlayerUser.owner;
    }
}
