package guicontroller;

import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import logic.bean.BeanCourt;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


/**
 * Controller grafico utilizzato per la gestione dell'aggiunta di un nuovo campetto.
 * La classe tryAdd server per premere ENTER invece che dover schiacciare il pulsante manualmente con un click.
 * La classe addCourt prova ad aggiungere un nuovo campetto nel sistema.
 */
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

    /**
     * Aggiungi un nuovo campetto. Se viene trovato un errore il campetto non viene aggiunto, ma viene mostrato il testo di errore.
     */
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

    /**
     * Server per premere ENTER invece che cliccare.
     */
    @FXML
    private void tryAdd(KeyEvent k){
        if(k.getCode().toString().compareTo("ENTER") == 0)
            addCourt();
    }
}
