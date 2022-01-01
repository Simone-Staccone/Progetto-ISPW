package gui_Graphic_Controller;

import Logic.Bean.BeanStats;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StatsInterfaceControl extends GenericInterface {
    @FXML
    private TextField pointsField;
    @FXML
    private TextField assistsField;
    @FXML
    private TextField reboundsField;
    @FXML
    private TextField minutesField;

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
            try {
                BeanStats.add(p, a, r, m);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Wrong input");
        } finally {
            pointsField.setText("");
            assistsField.setText("");
            reboundsField.setText("");
            minutesField.setText("");
        }
    }
}
