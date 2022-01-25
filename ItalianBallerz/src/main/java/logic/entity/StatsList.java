package logic.entity;

import logic.control.FileManager;
import logic.control.StatsController;
import logic.other.CourtConst;
import logic.other.SingletonPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StatsList {
    private final List<Stat> stlst = new ArrayList<>();

    public StatsList() throws FileNotFoundException {
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
    }

    public List<Stat> getStlst() {
        return stlst;
    }
}
