package logic.dao;

import logic.entity.Court;
import logic.other.CourtConst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Dao per la comunicazione con il file system
 */
public class CourtListDao {
    private static final List<Court> courts = new ArrayList<>();

    public List<Court> setCourtList(String name){
        FileManager fm = new FileManager("court" + File.separator + name);
        String s;
        try {
            while (!fm.checkEnd()) {
                s = fm.readLine();
                courts.add(new Court(s));
            }
        } catch (FileNotFoundException e) {
            courts.add(new Court("Non trovato"));
        }
        return courts;
    }


    public List<Court> setCourts(String name){
        courts.clear();
        FileManager fm = new FileManager("court" + File.separator + name + File.separator + name + CourtConst.EXTENSION);
        try {
            String s;
            while (!fm.checkEnd()) {
                s = fm.readLine();
                courts.add(new Court(s.substring(0,s.indexOf("$"))));
            }
        } catch (Exception e) {
            courts.add(new Court("Non trovato"));
        }
        return courts;
    }
}
