package Logic.Entity;

import Logic.Control.FileManager;
import Logic.Control.StatsController;

import java.util.ArrayList;
import java.util.List;

public class StatsList {
    private List<Stat> stlst = new ArrayList<>();

    public StatsList() {
        String path = "C:\\Users\\simon\\IdeaProjects\\ItalianBallerz\\src\\main\\java\\Data\\";
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

    private void setStlst(List<Stat> stlst) {
        this.stlst = stlst;
    }

    public void print() {
        System.out.println(stlst.size());
        Stat s;
        for(int i=0;i<stlst.size();i++){
            s = stlst.get(i);
            System.out.println(s.getPoints() + "-" + s.getAssists() + "-" + s.getRebounds() + "-" + s.getMinutes());
        }
    }
}
