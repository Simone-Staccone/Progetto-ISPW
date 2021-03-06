package logic.dao;

import errorlogic.AlreadyReserved;
import errorlogic.MyException;
import errorlogic.NotLoggedException;
import logic.other.CourtConst;
import logic.other.SingletonPlayer;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Dao per la comunicazione con il file system
 */
public class CourtDao {
    public void add(String name,String location, String phone, String money) throws MyException {
        FileManager fm = new FileManager(CourtConst.COURT + File.separator + location);
        fm.writeAppend((name + CourtConst.FIRST_SYMBOL + phone + CourtConst.SECOND_SYMBOL + money + CourtConst.THIRD_SYMBOL + SingletonPlayer.getLoginInstance().getUsername()),location + CourtConst.EXTENSION);
    }

    public void search(int start,String name) throws FileNotFoundException, AlreadyReserved {
        FileManager fm = new FileManager(CourtConst.SCHEDULE + File.separator + name +  CourtConst.EXTENSION);
        String s;

        while(!fm.checkEnd()){
            s = fm.readLine();
            if(SingletonPlayer.getLoginInstance() != null && s.compareTo(start + "-" + SingletonPlayer.getLoginInstance().getUsername()) == 0){
                throw new AlreadyReserved("",null);
            }
        }
    }

    public void addReservation(int start,String name) throws NotLoggedException, MyException {
        FileManager fm = new FileManager();
        String who;

        if(SingletonPlayer.getLoginInstance() == null)
            throw new NotLoggedException("Not logged",null);
        else
            who = SingletonPlayer.getLoginInstance().getUsername();

        fm.writeAppend(start + "-" + who,CourtConst.SCHEDULE + File.separator + name + CourtConst.EXTENSION);
    }
}
