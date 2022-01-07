package guicontroller;

import javafx.scene.text.Text;
import logic.bean.BeanStats;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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

    public void showM(String s){
        System.out.println("Interaction returned: " + s);
    }

    @FXML
    private void addStats() {
        String p, a, r, m;

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
            System.out.println("Wrong input");
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
