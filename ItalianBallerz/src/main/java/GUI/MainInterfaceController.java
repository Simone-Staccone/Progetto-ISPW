package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;


public class MainInterfaceController extends GenericInterface{

    @FXML
    public ImageView userIcon;
    @FXML
    public Label homeLabel;
    @FXML
    public Label playgroundLabel;
    @FXML
    public Label statsLabel;
    @FXML
    public Pane playgroundImagePane;
    @FXML
    public Pane statsImagePane;
    @FXML
    public TextField Username;
    @FXML
    public TextField Password;



    @FXML
    public void PassOnInstance() {
        PassOn(userIcon,null);
    }
    @FXML
    public void PassOffInstance(){
        PassOff(userIcon,null);
    }

    @FXML
    public void BringUP(){
        BringUP(userIcon);
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

    @FXML
    public void HighlightOnL(){
        HighlightOn(playgroundImagePane);
    }
    @FXML
    public void HighlightOffL(){
        HighlightOff(playgroundImagePane);
    }

    @FXML
    public void HighlightOnD(){
        HighlightOn(statsImagePane);
    }
    @FXML
    public void HighlightOffD(){
        HighlightOff(statsImagePane);
    }

}

