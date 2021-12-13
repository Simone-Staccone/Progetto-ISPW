package GUI;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class StatsInterfaceController extends GenericInterface{
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
    private Pane statsImagePane;
    @FXML
    public TextField Username;
    @FXML
    public TextField Password;


    @FXML
    public void SwapToPlay() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("StatsInterfaceUse.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage)mainPane.getScene().getWindow();
        window.setScene(scene);
        window.show();
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

    @FXML
    public void HighlightOnD(){
        HighlightOn(statsImagePane);
    }
    @FXML
    public void HighlightOffD(){
        HighlightOff(statsImagePane);
    }

    @FXML
    public void LoginI()
    {
        try {
            Login(Username.getText(),Password.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
