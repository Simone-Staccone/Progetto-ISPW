package logic.entity;

import logic.control.FileManager;
import logic.control.StatsController;
import logic.other.SingletonPlayer;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StatsList {
    private final List<Stat> stlst = new ArrayList<>();

    public StatsList() {
        String path = Paths.get("").toAbsolutePath() + "\\src\\main\\java\\data\\users\\"
                + SingletonPlayer.getLoginInstance().getUsername() + "\\";
        FileManager fm = new FileManager(path + "points.txt");
        FileManager fm2 = new FileManager(path + "assists.txt");
        FileManager fm3 = new FileManager(path + "rebounds.txt");
        FileManager fm4 = new FileManager(path + "minutes.txt");
        StatsController st = new StatsController();
        Stat s;
        while(!fm.checkEnd()){
            s = st.create(Float.parseFloat(fm.readLine()),Float.parseFloat(fm2.readLine()),Float.parseFloat(fm3.readLine()),Float.parseFloat(fm4.readLine()));
            stlst.add(s);
        }
    }

    public List<Stat> getStlst() {
        return stlst;
    }

    public void print() {
        System.out.println(stlst.size());
        Stat s;
        for (Stat stat : stlst) {
            s = stat;
            System.out.println(s.getPoints() + "-" + s.getAssists() + "-" + s.getRebounds() + "-" + s.getMinutes());
        }
    }
}