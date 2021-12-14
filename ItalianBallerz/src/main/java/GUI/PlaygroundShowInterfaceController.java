package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;


public class PlaygroundShowInterfaceController extends GenericInterface{
    @FXML
    public ImageView userIcon;
    @FXML
    public Label homeLabel;
    @FXML
    public Label statsLabel;
    @FXML
    public Label playgroundLabel;
    @FXML
    public TextField Username;
    @FXML
    public TextField Password;
    @FXML
    public TextField serachList;

    private boolean first = true;

    @FXML
    public void tryClear()
    {
        if(first)
        {
            serachList.setText("");
        }
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
    public void SwaptoPlay() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Court.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage)mainPane.getScene().getWindow();
        window.setScene(scene);
        window.show();
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
