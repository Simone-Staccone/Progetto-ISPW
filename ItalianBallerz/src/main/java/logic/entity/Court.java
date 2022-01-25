package logic.entity;

import errorlogic.AlreadyReserved;
import errorlogic.NotLoggedException;
import logic.control.FileManager;
import logic.other.CourtConst;
import logic.other.SingletonPlayer;

import java.io.File;
import java.io.FileNotFoundException;

public class Court {
    private String name;
    private final String path;

    public Court(String name){
        this.name = name;
        this.path = "schedule" + File.separator + this.name;
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

        fm.writeAppend(start + "-" + who,path + CourtConst.EXTENSION);
    }

    public void search(int start) throws FileNotFoundException, AlreadyReserved {
        FileManager fm = new FileManager(path +  CourtConst.EXTENSION);
        String s;

        while(!fm.checkEnd()){
            s = fm.readLine();
            if(SingletonPlayer.getLoginInstance() != null && s.compareTo(start + "-" + SingletonPlayer.getLoginInstance().getUsername()) == 0){
                throw new AlreadyReserved("",null);
            }
        }
    }
}
