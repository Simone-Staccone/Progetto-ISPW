package guicontroller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import logic.bean.BeanCourt;

import java.net.URL;
import java.util.ResourceBundle;

public class CourtController extends GenericInterface implements Initializable {
    @FXML
    private Text label;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText(BeanCourt.getCurrent());
    }
}
