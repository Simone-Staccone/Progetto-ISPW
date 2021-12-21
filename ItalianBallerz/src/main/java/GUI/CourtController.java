package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class CourtController extends GenericInterface{
    @FXML
    public ImageView userIcon;
    @FXML
    public AnchorPane mainPane;
    @FXML
    public Label homeLabel;
    @FXML
    public Label playgroundLabel;
    @FXML
    public Label statsLabel;
    @FXML
    public TextField Username;
    @FXML
    public TextField Password;



    @FXML
    public void PassOnInstance(){
        super.PassOn(userIcon,null);
    }
    @FXML
    public void PassOffInstance(){
        super.PassOff(userIcon,null);
    }

    @FXML
    public void PassOnS(){
        super.PassOn(null,statsLabel);
    }
    @FXML
    public void PassOffS(){
        super.PassOff(null,statsLabel);
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
    public void PassOnH(){
        PassOn(null,homeLabel);
    }
    @FXML
    public void PassOffH(){
        PassOff(null,homeLabel);
    }





}
