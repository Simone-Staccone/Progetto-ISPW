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
    public static void setCache(String name){
        GetPlaygroundListController gp = new GetPlaygroundListController();
        gp.setCache(name);
    }
}
