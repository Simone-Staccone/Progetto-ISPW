package StatsLogic.Boundary;

import GUI.GenericInterface;
import GUI.StatsInterface;
import GUI.StatsInterfaceController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GUIBoundary extends GenericInterface {
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
    public TextField pointsField;
    @FXML
    public TextField assistsField;
    @FXML
    public TextField reboundsField;
    @FXML
    public TextField minutesField;

    @FXML
    public void PassOnS(){
        PassOn(null,statsLabel);
    }
    @FXML
    public void PassOffS(){
        PassOff(null,statsLabel);
    }

    @FXML
    public void PassOnInstance(){
        PassOn(userIcon,null);
    }
    @FXML
    public void PassOffInstance(){
        PassOff(userIcon,null);
    }

    @FXML
    public void addStats() throws IOException {
        BoundaryAddstats.addStats(pointsField.getText(),assistsField.getText(),reboundsField.getText(),minutesField.getText());
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

    public void BringUP() {
        BringUP(userIcon);
    }

}
