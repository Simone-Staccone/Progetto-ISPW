package logic.bean;

import logic.control.AddPlaygroundController;
import javafx.scene.layout.HBox;
import logic.control.GetPlaygroundListController;

import java.util.List;

public class BeanCourt {
    public static List<HBox> search(String name) {
        GetPlaygroundListController gpl = new GetPlaygroundListController();
        return gpl.get(name);
    }

    public static void addCourt(String name, String location, String phone, String money) throws Exception{
        if(name.compareTo("") == 0 || location.compareTo("") == 0 || phone.compareTo("") == 0 || money.compareTo("") == 0) {
            throw new Exception();
        }
        else {
            AddPlaygroundController cc = new AddPlaygroundController();
            cc.addCourt(name, location, phone, money);
        }
    }

    public static String getCurrentName() {
        GetPlaygroundListController gp = new GetPlaygroundListController();
        return gp.getCurrentName();
    }
    public static void setCacheName(String name){
        GetPlaygroundListController gp = new GetPlaygroundListController();
        gp.setCacheName(name);
        gp.setCacheMoney(name);
        gp.setCachePhone(name);
        try {
            gp.setCacheOwner(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setCacheLocation(String name){
        GetPlaygroundListController gp = new GetPlaygroundListController();
        gp.setCacheLocation(name);
    }

    public static String getCurrentOwner() {
        GetPlaygroundListController gp = new GetPlaygroundListController();
        String s = "";
        try {
            s = gp.getOwner();
        } catch (Exception e) {
            System.err.println("Not found!");
        }
        return s;
    }

    public static String getCurrentLocation() {
        GetPlaygroundListController gr = new GetPlaygroundListController();
        return gr.getLocation();
    }

    public static String getCurrentMoney() {
        GetPlaygroundListController gr = new GetPlaygroundListController();
        return gr.getMoney();
    }

    public static String getCurrentPhone() {
        GetPlaygroundListController gr = new GetPlaygroundListController();
        return gr.getPhone();
    }
}
