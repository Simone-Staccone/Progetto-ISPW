package second_guicontroller;

import guicontroller.GenericInterface;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import logic.bean.BeanLogin;
import logic.other.Swap2;

import java.io.FileNotFoundException;

/**
 * Controller grafico che si occupa della gestione del form che permette il login
 */
public class LoginFormController extends GenericInterface {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Text returnText;
    @FXML
    private CheckBox owner;




    @FXML
    private void swaptoR2(){
        Swap2.goTo("RegisterForm.fxml",mainPane);
    }

    @FXML
    private void logIn(){
        int ret = 0;
        returnText.setText("");
        returnText.setStyle("-fx-fill: RED");
        try {
            ret = BeanLogin.verifyUser(username.getText(),password.getText(),owner.isSelected());
        } catch (FileNotFoundException e) {
            returnText.setText("Wrong password!");
            password.setText("");
        }

        switch (ret) {
            case -1 -> returnText.setText("Username field is empty!");
            case -2 -> returnText.setText("Password field is empty!");
            case 0 -> {
                returnText.setText("Wrong password!");
                password.setText("");
            }
            case 1 -> {
                returnText.setText("*Username not found!");
                username.setText("");
                password.setText("");
            }
            case 2 -> Swap2.goTo("Home.fxml", mainPane);
            default -> throw new IllegalStateException("Unexpected value: " + ret);
        }
    }

    @FXML
    private void tryL(KeyEvent k){
        if(k.getCode().toString().compareTo("ENTER") == 0)
            logIn();
    }

}
