package guicontroller;

import logic.bean.BeanLogin;
import logic.other.Swap;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class LoginInterfaceController extends GenericInterface{
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Text errorText;
    @FXML
    private RadioButton owner;

    @FXML
    private void login(){
        int ret;
        errorText.setText("");
        errorText.setStyle("-fx-fill: RED");
        ret = BeanLogin.verifyUser(username.getText(),password.getText(),owner.isSelected());

        switch (ret){
            case -1:
                errorText.setText("*Username field is empty!");
                break;
            case -2:
                errorText.setText("*Password field is empty!");
                break;
            case 0:
                errorText.setText("*Wrong password!");
                password.setText("");
                break;
            case 1:
                errorText.setText("*Username not found!");
                username.setText("");
                password.setText("");
                break;
            case 2:
                Swap.goTo("LoggedInterface.fxml",mainPane);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ret);
        }
    }

    @FXML
    private void Try(KeyEvent k){
        if(k.getCode().toString().compareTo("ENTER") == 0)
            login();
    }
}

