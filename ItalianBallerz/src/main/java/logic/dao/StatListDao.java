package logic.dao;

import logic.control.StatsController;
import logic.entity.Stat;
import logic.other.CourtConst;
import logic.other.SingletonPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Dao per la comunicazione con il file system
 */
public class StatListDao {
    public List<Stat> setStatsList() throws FileNotFoundException {
        List<Stat> stlst = new ArrayList<>();
        String path = CourtConst.USER_PACKAGE + File.separator + SingletonPlayer.getLoginInstance().getUsername();
        FileManager fm = new FileManager(path + File.separator + CourtConst.POINTS + CourtConst.EXTENSION);
        FileManager fm2 = new FileManager(path + File.separator + CourtConst.ASSISTS + CourtConst.EXTENSION);
        FileManager fm3 = new FileManager(path + File.separator + CourtConst.REBOUNDS + CourtConst.EXTENSION);
        FileManager fm4 = new FileManager(path + File.separator + CourtConst.MINUTES + CourtConst.EXTENSION);
        StatsController st = new StatsController();
        Stat s;
        try {
            while (!fm.checkEnd()) {
                s = st.create(Float.parseFloat(fm.readLine()), Float.parseFloat(fm2.readLine()), Float.parseFloat(fm3.readLine()), Float.parseFloat(fm4.readLine()));
                stlst.add(s);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        return stlst;
    }

}
