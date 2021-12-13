package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class RegisterInterfaceController extends GenericInterface{

    @FXML
    public Label homeLabel;
    @FXML
    public Label playgroundLabel;
    @FXML
    public Label statsLabel;




    @FXML
    public void PassOnH(){
        PassOn(null,homeLabel);
    }
    @FXML
    public void PassOffH(){
        PassOff(null,homeLabel);
    }



    @FXML
    public void PassOnP(){
        PassOn(null,playgroundLabel);
    }
    @FXML
    public void PassOffP(){
        PassOff(null,playgroundLabel);
    }



    @FXML
    public void PassOnS(){
        PassOn(null,statsLabel);
    }
    @FXML
    public void PassOffS(){
        PassOff(null,statsLabel);
    }


}
