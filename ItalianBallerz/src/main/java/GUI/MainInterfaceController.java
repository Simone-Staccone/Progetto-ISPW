package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;



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
    public void PassOnInstance() {
        super.PassOn(userIcon,null);
    }
    @FXML
    public void PassOffInstance(){
        super.PassOff(userIcon,null);
    }



    @FXML
    public void PassOnP(){
        super.PassOn(null,playgroundLabel);
    }
    @FXML
    public void PassOffP(){
        super.PassOff(null,playgroundLabel);
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
    public void HighlightOnL(){
        super.HighlightOn(playgroundImagePane);
    }
    @FXML
    public void HighlightOffL(){
        super.HighlightOff(playgroundImagePane);
    }

    @FXML
    public void HighlightOnD(){
        super.HighlightOn(statsImagePane);
    }
    @FXML
    public void HighlightOffD(){
        super.HighlightOff(statsImagePane);
    }

}

