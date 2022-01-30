package logic.entity;

import logic.dao.FileManager;
import logic.other.CourtConst;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CourtList {
    private static final List<Court> COURTS = new ArrayList<>();

    public CourtList(String name){
        FileManager fm = new FileManager("court" + File.separator + name);
        String s;
        try {
            while (!fm.checkEnd()) {
                s = fm.readLine();
                COURTS.add(new Court(s));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public int size(){
        return COURTS.size();
    }

    public Court get(int i) {
        Court c = null;
        if(COURTS.size() > i)
            c = COURTS.get(i);
        return c;
    }

    public static List<Court> getCourts(){
        return CourtList.COURTS;
    }

    public static void setCourts(String name){
        COURTS.clear();
        FileManager fm = new FileManager("court" + File.separator + name + File.separator + name + CourtConst.EXTENSION);
        try {
            String s;
            while (!fm.checkEnd()) {
                s = fm.readLine();
                COURTS.add(new Court(s.substring(0,s.indexOf("$"))));
            }
        } catch (Exception e) {
            Logger log = Logger.getRootLogger();
            log.debug("File non esiste!");
        }
    }
}
