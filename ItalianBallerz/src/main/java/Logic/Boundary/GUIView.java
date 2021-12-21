package Logic.Boundary;

import GUI.GenericInterface;
import Logic.Bean.BeanStats;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GUIView extends GenericInterface {
    @FXML
    public AnchorPane mainPane;
    @FXML
    public Label homeLabel;
    @FXML
    public Label playgroundLabel;
    @FXML
    public Label statsLabel;
    @FXML
    public TextField pointsField;
    @FXML
    public TextField assistsField;
    @FXML
    public TextField reboundsField;
    @FXML
    public TextField minutesField;
    @FXML
    public ImageView userIcon;

    @FXML
    public void PassOnInstance(){
        super.PassOn(userIcon,null);
    }
    @FXML
    public void PassOffInstance(){
        super.PassOff(userIcon,null);
    }


    @FXML
    public void PassOnS(){
        PassOn(null,statsLabel);
    }
    @FXML
    public void PassOffS(){
        PassOff(null,statsLabel);
    }

    public void showM(String s){
        System.out.println("Interaction returned: " + s);
    }

    @FXML
    public void addStats() {
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


    @FXML
    public void PassOnP(){
        PassOn(null,playgroundLabel);
    }
    @FXML
    public void PassOffP(){
        PassOff(null,playgroundLabel);
    }



    @FXML
    public void PassOnH(){
        PassOn(null,homeLabel);
    }
    @FXML
    public void PassOffH(){
        PassOff(null,homeLabel);
    }


}
