package logic.control;

import javafx.scene.layout.HBox;
import logic.other.FactoryScrollList;
import logic.other.ScrollList;

import java.util.ArrayList;
import java.util.List;


public class GetPlaygroundListController {
    public List<HBox> get(String name){
        List<HBox> bList = new ArrayList<>();
        ScrollList scr;

        FactoryScrollList factory = new FactoryScrollList();

        try {
            scr = factory.createList(2);
            bList = scr.getList(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bList;
    }
}
