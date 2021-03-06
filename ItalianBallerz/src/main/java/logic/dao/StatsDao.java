package logic.dao;

import errorlogic.MyException;
import logic.other.CourtConst;
import logic.other.SingletonPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Dao per la comunicazione con il file system
 */
public class StatsDao {
    private String actually;

    public StatsDao(){
        this.actually = CourtConst.USER_PACKAGE + File.separator + SingletonPlayer.getLoginInstance().getUsername() + File.separator;
    }

    public List<Float> getAverege(String str) throws FileNotFoundException {
        List<Float> list = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        String s;

        FileManager fm;
        fm = new FileManager(actually + str + CourtConst.EXTENSION);
        while(!fm.checkEnd()) {
            buffer.delete(0, buffer.length());
            buffer.append(fm.readLine());
            s = buffer.toString();
            list.add(Float.parseFloat(s));
        }
        return list;
    }

    public void write(float points, float assists, float rebounds, float minutes) throws MyException {
        FileManager fm = new FileManager(actually );

        fm.writeAppend(Float.toString(points),CourtConst.POINTS + CourtConst.EXTENSION);
        fm.writeAppend(Float.toString(assists),CourtConst.ASSISTS + CourtConst.EXTENSION);
        fm.writeAppend(Float.toString(rebounds),CourtConst.REBOUNDS + CourtConst.EXTENSION);
        fm.writeAppend(Float.toString(minutes),CourtConst.MINUTES + CourtConst.EXTENSION);
    }

    public void delete(int number) throws IOException {
        FileManager fm = new FileManager(actually  + CourtConst.POINTS + CourtConst.EXTENSION);
        FileManager fm2 = new FileManager(actually  + CourtConst.ASSISTS + CourtConst.EXTENSION);
        FileManager fm3 = new FileManager(actually  + CourtConst.REBOUNDS + CourtConst.EXTENSION);
        FileManager fm4 = new FileManager(actually  + CourtConst.MINUTES + CourtConst.EXTENSION);
        try{
            fm.deleteLine(number);
            fm2.deleteLine(number);
            fm3.deleteLine(number);
            fm4.deleteLine(number);
        } catch (Exception e) {
            throw new IOException();

        }
    }
}
