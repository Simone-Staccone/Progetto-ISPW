package logic.control;

import errorlogic.MyException;
import javafx.scene.layout.HBox;
import logic.entity.CourtCache;
import logic.entity.CourtList;
import logic.other.FactoryScrollList;
import logic.other.ScrollList;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class GetPlaygroundListController {
    public List<HBox> get(String name){
        List<HBox> bList = new ArrayList<>();
        ScrollList scr;

        CourtList.setCourts(name);

        FactoryScrollList factory = new FactoryScrollList();

        try {
            scr = factory.createList(2);
            bList = scr.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bList;
    }
    public String getCurrentName(){
        return CourtCache.getName();
    }

    public void setCacheName(String name) {
        CourtCache.setName(name);
    }

    public void setCacheLocation(String name) {
        CourtCache.setLocation(name);
    }

    public String getOwner() throws Exception{
        String s;
        try{
            s = CourtCache.getOwner();
        } catch (Exception e) {
            throw new MyException(e.getMessage(),e);
        }
        return s;
    }

    public String getLocation() {
        return CourtCache.getLocation();
    }

    public void setCacheOwner(String name) {
        String owner = "";
        try{
            owner = CourtCache.findOwner(name);
        }catch (FileNotFoundException f){
            System.err.println("File not found!");
        }
        CourtCache.setOwner(owner);
    }
}
