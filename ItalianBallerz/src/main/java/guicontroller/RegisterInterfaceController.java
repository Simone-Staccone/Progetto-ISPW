package guicontroller;

import logic.bean.BeanLogin;
import logic.other.Swap;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class RegisterInterfaceController extends GenericInterface{
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField passwordConf;
    @FXML
    private TextField email;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Text errorText;
    @FXML
    private RadioButton owner;


    @FXML
    private void register(){
        int b = 0;
        errorText.setText("");

        try {
            b = BeanLogin.addUser(username.getText(), password.getText(), passwordConf.getText(), email.getText(),owner.isSelected());
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (b) {
            case -1 -> {
                errorText.setText("*Every field is required!");
                errorText.setStyle("-fx-fill: RED");
            }
            case 0 -> {
                errorText.setText("*Username already used!");
                passwordConf.setText("");
            }
            case 1 -> {
                errorText.setText("*Password and confirm password doesn't match");
                errorText.setStyle("-fx-fill: RED");
            }
            case 2 -> Swap.goTo("LoginInterface.fxml", mainPane);
            default -> throw new IllegalStateException("Unexpected value: " + b);
        }

    }
}
