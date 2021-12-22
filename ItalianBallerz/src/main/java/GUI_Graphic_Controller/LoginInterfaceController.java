package GUI_Graphic_Controller;

import Logic.Bean.BeanLogin;
import Logic.Other.Swap;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginInterfaceController extends GenericInterface{
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private AnchorPane mainPane;

    @FXML
    private void Login(){
        BeanLogin.verifyUser(username.getText(),password.getText());
        username.setText("");
        password.setText("");
        Swap.goTo("LoggedInterface.fxml",mainPane);
    }
}

