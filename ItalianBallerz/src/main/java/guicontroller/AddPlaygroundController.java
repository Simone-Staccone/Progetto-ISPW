package guicontroller;

import javafx.scene.input.KeyEvent;
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

    public void showM(String s){
        System.out.println("Interaction returned: " + s);
    }
    @FXML
    private void addCourt() {
        try {
            BeanCourt.addCourt(nameField.getText(),locationField.getText());
        } catch (Exception e) {
            System.out.println("Wrong input");
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
