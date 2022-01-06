package logic.entity;

import logic.control.FileManager;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CourtList {
    private static final List<Court> courtList = new ArrayList<>();

    public CourtList(String name){
        FileManager fm = new FileManager(Paths.get("").toAbsolutePath() + "\\src\\main\\java\\data\\court\\" + name + ".txt");
        String s;
        while(!fm.checkEnd()){
            s = fm.readLine();
            courtList.add(new Court(s));
        }
    }
    public int size(){
        return courtList.size();
    }

    public Court get(int i) {
        Court c = null;
        if(courtList.size() > i)
            c = courtList.get(i);
        return c;
    }

    public static List<Court> getCourts(){
        return CourtList.courtList;
    }

    public static void setCourts(String name){
        courtList.clear();
        FileManager fm = new FileManager(Paths.get("").toAbsolutePath() + "\\src\\main\\java\\data\\court\\" + name + "\\" + name + ".txt");
        try {
            fm.exist();
            String s;
            while (!fm.checkEnd()) {
                s = fm.readLine();
                courtList.add(new Court(s.substring(0,s.indexOf("$"))));
            }
        } catch (Exception e) {
            System.out.println("File non esiste");
        }
    }
}
