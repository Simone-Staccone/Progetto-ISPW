package logic.entity;

import logic.dao.CourtListDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Model relativo ad una loista di campetti
 */
public class CourtList {
    private static List<Court> courts = new ArrayList<>();

    public CourtList(String name){
        CourtListDao cld = new CourtListDao();
        cld.setCourtList(name);
    }
    public int size(){
        return courts.size();
    }

    public Court get(int i) {
        Court c = null;
        if(courts.size() > i)
            c = courts.get(i);
        return c;
    }

    public static List<Court> getCourts(){
        return CourtList.courts;
    }

    public static void setCourts(String name){
        CourtListDao cld = new CourtListDao();
        courts.clear();
        courts = cld.setCourts(name);
    }
}
