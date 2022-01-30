package guicontroller;

import javafx.scene.text.Text;
import logic.other.FactoryScrollList;
import logic.other.ScrollList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Gestisce il display di tutte le statistiche di un utente.
 */
public class MyStatsControl extends GenericInterface implements Initializable {
    @FXML
    private AnchorPane ancPane;
    @FXML
    private VBox box;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ScrollList scL;
        List<HBox> bList;

        FactoryScrollList factory = new FactoryScrollList();

        try {
            scL = factory.createList(1);
            bList = scL.getList();

            ancPane.setMinHeight(bList.size()*40);
            for (HBox hBox : bList)
                box.getChildren().add(hBox);
        } catch (Exception e) {
            box.getChildren().add(new HBox(new Text("Ancora nessuna statistica")));
        }
    }
}
