package guicontroller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.bean.BeanCourt;
import logic.other.FactoryScrollList;
import logic.other.ScrollList;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CourtController extends GenericInterface implements Initializable {
    @FXML
    private Text label;
    @FXML
    private Text owner;
    @FXML
    private Text phone;
    @FXML
    private Text money;
    @FXML
    private Text location;
    @FXML
    private VBox scrollList;
    @FXML
    private AnchorPane container;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ScrollList scL;
        List<HBox> bList = null;


        label.setText(BeanCourt.getCurrentName());
        owner.setText(BeanCourt.getCurrentOwner());
        money.setText(BeanCourt.getCurrentMoney());
        phone.setText(BeanCourt.getCurrentPhone());
        location.setText(BeanCourt.getCurrentLocation());

        FactoryScrollList factory = new FactoryScrollList();

        try {
            scL = factory.createList(2);
            bList = scL.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            container.setMinHeight(bList.size()*40);
            for (HBox hBox : bList)
                scrollList.getChildren().add(hBox);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
