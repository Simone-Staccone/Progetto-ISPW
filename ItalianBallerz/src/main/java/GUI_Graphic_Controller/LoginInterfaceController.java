package GUI_Graphic_Controller;

import Logic.Bean.BeanLogin;
import Logic.Other.Swap;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;


public class LoginInterfaceController extends GenericInterface{
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private AnchorPane mainPane;

    @FXML
    private void login(){
        Boolean b;
        b = BeanLogin.verifyUser(username.getText(),password.getText());
        username.setText("");
        password.setText("");
        if(b)
            Swap.goTo("LoggedInterface.fxml",mainPane);
    }

    @FXML
    private void Try(KeyEvent k){
        if(k.getCode().toString().compareTo("ENTER") == 0)
            login();
        else if(k.getCode().toString().compareTo("DOWN") == 0)
        {
            password.onMouseClickedProperty();
        }
    }
}

