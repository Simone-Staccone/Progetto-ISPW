package guicontroller;

import javafx.scene.text.Text;
import logic.bean.BeanStats;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Gestisce l'interfaccia grafica che permette all'utente di aggiungere statistiche.
 */
public class StatsInterfaceControl extends GenericInterface {
    @FXML
    private TextField pointsField;
    @FXML
    private TextField assistsField;
    @FXML
    private TextField reboundsField;
    @FXML
    private TextField minutesField;
    @FXML
    private Text returnText;



    @FXML
    private void addStats() {
        String p;
        String a;
        String r;
        String m;

        try {
            p = pointsField.getText();
            a = assistsField.getText();
            r = reboundsField.getText();
            m = minutesField.getText();

            BeanStats.add(p, a, r, m);
            returnText.setText("*Successfully added");
            returnText.setStyle("-fx-fill: GREEN");
            returnText.toFront();
        } catch (Exception e) {
            returnText.setText("*Wrong input");
            returnText.setStyle("-fx-fill: RED");
            returnText.toFront();
        } finally {
            pointsField.setText("");
            assistsField.setText("");
            reboundsField.setText("");
            minutesField.setText("");
        }
    }
}
