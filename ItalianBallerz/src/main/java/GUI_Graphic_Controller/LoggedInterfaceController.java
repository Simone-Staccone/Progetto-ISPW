package GUI_Graphic_Controller;

import Logic.Other.Swap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInterfaceController extends GenericInterface implements Initializable {
    @FXML
    private Text text;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text.setText(Swap.user);
    }
}

