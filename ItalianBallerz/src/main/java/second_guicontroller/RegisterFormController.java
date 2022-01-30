package second_guicontroller;

import guicontroller.GenericInterface;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import logic.bean.BeanLogin;
import logic.other.Swap2;

/**
 * Controller grafico che si occupa della gestione del form che permette la registrazione nel sistema
 */
public class RegisterFormController extends GenericInterface {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmPassword;
    @FXML
    private TextField email;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Text returnText;
    @FXML
    private CheckBox owner;



    @FXML
    private void register(){
        int b = 0;
        returnText.setText("");

        try {
            b = BeanLogin.addUser(username.getText(), password.getText(), confirmPassword.getText(), email.getText(),owner.isSelected());
        } catch (Exception e) {
            b = 5;
        }
        switch (b) {
            case -1 -> {
                returnText.setText("Every field is required!");
                returnText.setStyle("-fx-fill: RED");
            }
            case 0 -> {
                returnText.setText("*Username already used!");
                confirmPassword.setText("");
            }
            case 1 -> {
                returnText.setText("Password and confirm password doesn't match");
                returnText.setStyle("-fx-fill: RED");
            }
            case 2 -> Swap2.goTo("LoginForm.fxml", mainPane);
            default -> throw new IllegalStateException("Unexpected value: " + b);
        }

    }
}
