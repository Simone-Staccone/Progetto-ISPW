package logic.control;

import errorlogic.MyException;
import logic.entity.Court;
import logic.entity.CourtCache;
import logic.entity.CourtList;

import java.io.FileNotFoundException;
import java.util.List;


public class GetPlaygroundListController {
    public void set(String name){
        CourtList.setCourts(name);
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
            f.printStackTrace();
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
            f.printStackTrace();
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
            f.printStackTrace();
        }
        CourtCache.setPhone(phone);
    }

    public List<Court> getCourtList() {
        return CourtList.getCourts();
    }
}
