package gui_Graphic_Controller;

import Logic.Other.FactoryScrollList;
import Logic.Other.ScrollList;
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

    private ScrollList scL;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<HBox> bList;

        FactoryScrollList factory = new FactoryScrollList();

        try {
            this.scL = factory.createList(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        bList = this.scL.getList();

        try{
            ancPane.setMinHeight(bList.size()*40);
            for (HBox hBox : bList)
                box.getChildren().add(hBox);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
