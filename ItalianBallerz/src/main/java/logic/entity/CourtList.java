package logic.entity;

import logic.control.FileManager;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CourtList {
    private List<Court> courtList = new ArrayList<>();

    public CourtList(String name){
        FileManager fm = new FileManager(Paths.get("").toAbsolutePath() + "\\src\\main\\java\\data\\court\\" + name + ".txt");
        String s;
        while(!fm.checkEnd()){
            s = fm.readLine();
            courtList.add(new Court(s));
            System.out.println(s);
        }
    }
    public int size(){
        return this.courtList.size();
    }

    public Court get(int i) {
        Court c = null;
        if(this.courtList.size() > i)
            c = this.courtList.get(i);
        return c;
    }
}
