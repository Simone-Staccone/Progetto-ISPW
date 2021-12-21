package Logic.Entity;

import java.util.List;

public class PlayerUser {
    private List<Stats> playerstats;
    private final String name;
    private final String password;

    public PlayerUser(String name,String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return this.password;
    }
}
