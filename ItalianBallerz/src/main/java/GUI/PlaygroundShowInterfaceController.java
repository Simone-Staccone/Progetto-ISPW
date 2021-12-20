package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;



public class PlaygroundShowInterfaceController extends GenericInterface{
    @FXML
    public ImageView userIcon;
    @FXML
    public Label homeLabel;
    @FXML
    public Label statsLabel;
    @FXML
    public Label playgroundLabel;
    @FXML
    public TextField serachList;

    private final boolean first = true;

    @FXML
    public void tryClear()
    {
        if(first)
        {
            serachList.setText("");
        }
    }

    @FXML
    public void PassOnInstance(){
        PassOn(userIcon,null);
    }
    @FXML
    public void PassOffInstance(){
        PassOff(userIcon,null);
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
    public void PassOnS(){
        PassOn(null,statsLabel);
    }
    @FXML
    public void PassOffS(){
        PassOff(null,statsLabel);
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
