package Logic.Bean;

import Logic.Control.CourtController;
import javafx.scene.layout.HBox;

import java.util.List;

public class BeanCourt {
    public static List<HBox> search(String s) {
        return null;
    }

    public static void addCourt(String name,String location){
        CourtController cc = new CourtController();
        cc.addCourt(name,location);
    }
}
