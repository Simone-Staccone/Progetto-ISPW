package guicontroller;

import logic.other.FactoryScrollList;
import logic.other.ScrollList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;




public class MyStatsControl extends GenericInterface implements Initializable {
    @FXML
    private AnchorPane ancPane;
    @FXML
    private VBox box;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ScrollList scL;
        List<HBox> bList = null;

        FactoryScrollList factory = new FactoryScrollList();

        try {
            scL = factory.createList(1);
            bList = scL.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }



        try{
            ancPane.setMinHeight(bList.size()*40);
            for (HBox hBox : bList)
                box.getChildren().add(hBox);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
