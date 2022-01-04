package logic.bean;

import logic.control.AddPlaygroundController;
import javafx.scene.layout.HBox;
import logic.control.GetPlaygroundListController;

import java.util.List;

public class BeanCourt {
    public static List<HBox> search(String s) {
        return BeanCourt.getCourtList(s);
    }

    public static void addCourt(String name,String location){
        AddPlaygroundController cc = new AddPlaygroundController();
        cc.addCourt(location,name);
    }

    public static List<HBox> getCourtList(String name) {
        GetPlaygroundListController gpl = new GetPlaygroundListController();
        return gpl.get(name);
    }
}
