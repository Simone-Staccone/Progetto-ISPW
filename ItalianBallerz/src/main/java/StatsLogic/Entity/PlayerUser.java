package StatsLogic.Entity;

import java.util.List;

public class PlayerUser {
    private List<Stats> playerstats;
    private final String name;
    private final int ID;

    public PlayerUser(String name,int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }
}
