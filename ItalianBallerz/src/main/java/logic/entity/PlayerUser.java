package logic.entity;


import logic.dao.PlayerDao;

import java.io.FileNotFoundException;

/**
 * Model relativo all'utente
 */
public class PlayerUser {
    private String name;
    private boolean owner;

    public PlayerUser(String init) {
        this.name = init;
        this.owner = false;
    }

    public PlayerUser(String init, boolean owner) {
        this.name = init;
        this.owner = owner;
    }


    public String getUsername() {
        return this.name;
    }
    public void setUsername(String s) {
        this.name = s;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }


    public boolean getOwner() {
        return this.owner;
    }

    public boolean searchUserU() throws FileNotFoundException {
        PlayerDao pd = new PlayerDao();
        PlayerCache.setUsername(this.name);
        PlayerCache.setOwner(this.owner);
        return pd.searchUserU(this.name,this.owner);
    }

    public void writePlayerUser(String password,String email) throws FileNotFoundException {
        PlayerDao pd = new PlayerDao();
        pd.writePlayerUser(this.name,password,email,this.owner);
    }


    public boolean searchUser(String password) throws FileNotFoundException {
        PlayerDao pd = new PlayerDao();
        return pd.searchUser(this.name,password,this.owner);
    }
}
