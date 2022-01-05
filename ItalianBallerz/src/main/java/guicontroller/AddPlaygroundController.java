package guicontroller;

import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import logic.bean.BeanCourt;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;



public class AddPlaygroundController extends GenericInterface {
    @FXML
    private TextField nameField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField moneyField;
    @FXML
    private Text errorText;

    @FXML
    private void addCourt() {
        try {
            BeanCourt.addCourt(nameField.getText(),locationField.getText(),phoneField.getText(),moneyField.getText());
        } catch (Exception e) {
            errorText.setText("*Empty field");
            errorText.setStyle("-fx-fill : RED");
            errorText.toFront();
        } finally {
            nameField.setText("");
            locationField.setText("");
            phoneField.setText("");
            moneyField.setText("");
        }
    }

    @FXML
    private void tryAdd(KeyEvent k){
        if(k.getCode().toString().compareTo("ENTER") == 0)
            addCourt();
    }
}
