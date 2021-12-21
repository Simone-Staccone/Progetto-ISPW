package GUI;

import Logic.Bean.BeanLogin;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginInterfaceController extends GenericInterface{
    @FXML
    public Label homeLabel;
    @FXML
    public Label playgroundLabel;
    @FXML
    public Label statsLabel;
    @FXML
    private TextField username;
    @FXML
    private TextField password;


    @FXML
    public void Login(){
        BeanLogin.verifyUser(username.getText(),password.getText());
    }


    @FXML
    public void PassOnH(){
        super.PassOn(null,homeLabel);
    }
    @FXML
    public void PassOffH(){
        super.PassOff(null,homeLabel);
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


}

