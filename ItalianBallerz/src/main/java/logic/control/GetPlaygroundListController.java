package logic.control;

import errorlogic.MyException;
import javafx.scene.layout.HBox;
import logic.entity.CourtCache;
import logic.entity.CourtList;
import logic.other.FactoryScrollList;
import logic.other.ScrollList;
import org.apache.log4j.Logger;

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

    public String getOwner() throws MyException{
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
            Logger log = Logger.getRootLogger();
            log.debug("File per il proprietario non trovato!");
        }
        CourtCache.setOwner(owner);
    }

    public String getMoney() {
        return CourtCache.getMoney();
    }

    public void setCacheMoney(String name) {
        String money = "";
        try{
            money = CourtCache.findMoney(name);
        }catch (FileNotFoundException f){
            Logger log = Logger.getRootLogger();
            log.debug("File per il prezzo non trovato!");
        }
        CourtCache.setMoney(money);
    }

    public String getPhone() {
        return CourtCache.getPhone();
    }

    public void setCachePhone(String name) {
        String phone = "";
        try{
            phone = CourtCache.findPhone(name);
        }catch (FileNotFoundException f){
            Logger log = Logger.getRootLogger();
            log.debug("File per il numero di telefono non trovato");
        }
        CourtCache.setPhone(phone);
    }
}
