package second_guicontroller;

import errorlogic.MyException;
import guicontroller.GenericInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import logic.bean.BeanCourt2;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller grafico che gestisce la form per aggiungere un nuovo campetto.
 */
public class CourtAddFormController extends GenericInterface implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private TextField location;
    @FXML
    private TextField phone;
    @FXML
    private SplitMenuButton money;
    @FXML
    private Text errorText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i = 0;i<=20;i++)
        {
            MenuItem menu = new MenuItem(String.valueOf(i));
            int finalI = i;
            menu.setOnAction(event -> money.setText(String.valueOf(finalI)));
            money.getItems().add(menu);
        }
    }


    @FXML
    private void add(){
        try {
            BeanCourt2.addCourt(name.getText(),location.getText(),phone.getText(),Integer.parseInt(money.getText()));

            errorText.setText(name.getText() + " aggiunto con successo");
            errorText.setStyle("-fx-fill: GREEN");

            name.setText("");
            location.setText("");
            phone.setText("");
            money.setText("0");

        } catch (MyException e) {
            errorText.setText("Tutti i campi devono essere riempiti");
            errorText.setStyle("-fx-fill: RED");
        }


    }


    @FXML
    private void tryA(KeyEvent k){
        if(k.getCode().toString().compareTo("ENTER") == 0)
            add();
    }
}
