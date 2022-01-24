package logic.entity;

import errorlogic.NotLoggedException;
import logic.control.FileManager;
import logic.other.SingletonPlayer;

import java.io.File;

public class Court {
    private String name;
    public Court(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void addReservation(int start) throws NotLoggedException {
        FileManager fm = new FileManager();
        String who;

        if(SingletonPlayer.getLoginInstance() == null)
            throw new NotLoggedException("Not logged",null);
        else
            who = SingletonPlayer.getLoginInstance().getUsername();

        fm.writeAppend(start + "-" + who,"schedule" + File.separator + this.name);
    }
}
